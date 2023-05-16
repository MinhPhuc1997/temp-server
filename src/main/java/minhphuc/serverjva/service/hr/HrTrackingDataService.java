package minhphuc.serverjva.service.hr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import minhphuc.serverjva.config.DataSourceType;
import minhphuc.serverjva.config.DynamicRoutingDataSource;
import minhphuc.serverjva.domain.hr.HrBoxDoorRecord;
import minhphuc.serverjva.domain.hr.HrTrackingData;
import minhphuc.serverjva.domain.hr.ViewPersonShift;
import minhphuc.serverjva.domain.system.SystemCode;
import minhphuc.serverjva.mapper.hr.HrBoxDoorRecordMapper;
import minhphuc.serverjva.mapper.hr.ViewPersonShiftMapper;
import minhphuc.serverjva.model.request.TrackingQuery;
import minhphuc.serverjva.model.response.DataPage;
import minhphuc.serverjva.model.response.ReportTracking;
import minhphuc.serverjva.model.response.TimeTracking;
import minhphuc.serverjva.service.system.SystemCodeService;
import minhphuc.serverjva.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class HrTrackingDataService {

    @Autowired
    ViewPersonShiftMapper viewPersonShiftMapper;

    @Autowired
    HrBoxDoorRecordMapper hrBoxDoorRecordMapper;

    @Autowired
    SystemCodeService systemCodeService;

    public MessageResult getHrTrackingDataByPage(PageUtil pageUtil, TrackingQuery trackingQuery, String lan) throws NoSuchFieldException, IllegalAccessException {

        if (trackingQuery.getDateBegin() == null || trackingQuery.getDateEnd() == null) {
            return MessageResult.error("Vui lòng nhập ngày tháng");
        }
        List<HrTrackingData> result = new ArrayList<>();
        IPage<ViewPersonShift> personShiftIPages = viewPersonShiftMapper
                .selectPage(new Page<>(pageUtil.getPage(), pageUtil.getRows()), Tools.trackQueryWarapper(trackingQuery));
        List<String> personList = Tools.getListInObject(personShiftIPages.getRecords(), "personNo");
        if (personList.size() == 0) {
            return MessageResult.success(null);
        }
        DynamicRoutingDataSource.setDataSource(DataSourceType.JLK);
        List<HrBoxDoorRecord> hrBoxDoorRecords = hrBoxDoorRecordMapper.selectList(new QueryWrapper<HrBoxDoorRecord>()
                .in("PersonNO", personList)
                .ge("ActionTime", trackingQuery.getDateBegin() + " 00:00:00")
                .le("ActionTime", trackingQuery.getDateEnd() + " 23:59:59")
                .orderByAsc("PersonNO", "ActionTime")
        );
        DynamicRoutingDataSource.setDataSource(DataSourceType.ERP);
        List<SystemCode> systemCodes = systemCodeService.getSystemCodeList(null);
        for (ViewPersonShift shift : personShiftIPages.getRecords()) {
            if (shift != null) {
                TimeTracking timeTracking = TrackingUtils.getTimeKeeping(Tools.search(hrBoxDoorRecords, "personNo", shift.getPersonNo()), shift);
                HrTrackingData trackingData = new HrTrackingData();
                BeanUtils.copyProperties(shift, trackingData);
                BeanUtils.copyProperties(timeTracking, trackingData);

                trackingData.setShiftName(StringUtils.GetValue(systemCodes, "workShift", String.valueOf(shift.getPsInc()), lan));
                trackingData.setDayOfWeek(Tools.DayOfWeek(trackingData.getTrackingDate()));
                trackingData.setWorkHours(Float.valueOf(trackingData.getStatus() == null ? 0 : 8));
                result.add(trackingData);
            }
        }
        DataPage dataPage = new DataPage();
        dataPage.setRecords(result);
        dataPage.setCurrent(pageUtil.getPage());
        dataPage.setRows(pageUtil.getRows());
        dataPage.setTotal((int) personShiftIPages.getTotal());
        return MessageResult.success(dataPage);
    }

    public List<ReportTracking> downloadData(TrackingQuery trackingQuery, String language) {
        try {
            PageUtil pageUtil = new PageUtil();
            pageUtil.setRows(100000);
            MessageResult messageResult = getHrTrackingDataByPage(pageUtil, trackingQuery, language);
            DynamicRoutingDataSource.setDataSource(DataSourceType.ERP);
            if (messageResult.getCode() == 0) {
                DataPage dataPage = (DataPage) messageResult.getData();
                List<SystemCode> codes = systemCodeService.getSystemCodeList(null);
                List<HrTrackingData> hrTrackingData = (List<HrTrackingData>) dataPage.getRecords();
                List<ReportTracking> reportTracking = hrTrackingData.stream()
                        .map(hr -> {
                            ReportTracking report = new ReportTracking();
                            BeanUtils.copyProperties(hr, report);
                            report.setIndex(hrTrackingData.indexOf(hr) + 1);
                            report.setTrackingDate(report.getTrackingDate().substring(0, 10));
                            report.setDayOfWeek(ReportUtils.GetValue(codes, "dayOfWeek", hr.getDayOfWeek(), language));
                            report.setOffset(ReportUtils.GetValue(codes, "bool", String.valueOf(hr.getOffset()), language));
                            report.setFourghName("");
                            report.setFourghHours("");
                            return report;
                        })
                        .collect(Collectors.toList());
                BeanUtils.copyProperties(messageResult.getData(), reportTracking);
                return reportTracking;
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
