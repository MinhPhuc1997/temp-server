package minhphuc.serverjva.service.hr;

import minhphuc.serverjva.config.DataSourceType;
import minhphuc.serverjva.config.DynamicRoutingDataSource;
import minhphuc.serverjva.domain.hr.HrStatistical;
import minhphuc.serverjva.domain.system.SystemDepartment;
import minhphuc.serverjva.mapper.hr.HrStatisticalMapper;
import minhphuc.serverjva.mapper.system.SystemDepartmentMapper;
import minhphuc.serverjva.model.response.MonthTrackingData;
import minhphuc.serverjva.utils.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HrStatisticalService {

    @Autowired
    HrStatisticalMapper hrStatisticalMapper;

    @Autowired
    SystemDepartmentMapper systemDepartmentMapper;

    public MessageResult getStatistical(Integer year, Integer month){
        HrStatistical statistical = new HrStatistical();
        MonthTrackingData trackingData = new MonthTrackingData();
        trackingData.setOffsetNum(hrStatisticalMapper.getOffsetByMonth(year,month));
        trackingData.setPersonNum(hrStatisticalMapper.getPersonByMonth(year,month));
        DynamicRoutingDataSource.setDataSource(DataSourceType.JLK);
        trackingData.setDataNum(hrStatisticalMapper.getTrackingByMonth(year,month));
        DynamicRoutingDataSource.setDataSource(DataSourceType.ERP);
        trackingData.setFurloughNum(0);
        List<SystemDepartment> departments= systemDepartmentMapper.getOrgannize();
        List<HrOrgannizeSummary> orgDetal = new ArrayList<>();
        for (SystemDepartment item: departments ) {
            HrOrgannizeSummary statisticalRowDetail = new HrOrgannizeSummary();
            statisticalRowDetail.setOrgName(item.getOrgName());
            statisticalRowDetail.setOffsetNum(hrStatisticalMapper.getDetailOrgannize(year,month,item.getOrganizeId()));
            statisticalRowDetail.setFurloughNum(0);
            orgDetal.add(statisticalRowDetail);
        }
        statistical.setOrgDetail(orgDetal);
        statistical.setOffsetDetail(hrStatisticalMapper.getOffsetDetail(year,month));
        statistical.setMonthStatis(trackingData);
        return MessageResult.success(statistical);
    }

}
