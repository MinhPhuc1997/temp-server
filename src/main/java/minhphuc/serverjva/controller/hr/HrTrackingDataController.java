package minhphuc.serverjva.controller.hr;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.hr.HrTimeRecorder;
import minhphuc.serverjva.domain.hr.HrTrackingData;
import minhphuc.serverjva.model.request.TrackingQuery;
import minhphuc.serverjva.service.hr.HrTrackingDataService;
import minhphuc.serverjva.utils.ExcelUtils;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "Dữ liệu chấm công")
@RestController()
@RequestMapping(value = "/api/hrTrackingData")
public class HrTrackingDataController {

    @Autowired
    HrTrackingDataService hrTrackingDataService;

    @ApiOperation("Tra cứu theo ngày")
    @GetMapping("")
    public MessageResult getHrTrackingDataByPage(PageUtil pageUtil, TrackingQuery trackingQuery,String language) throws NoSuchFieldException, IllegalAccessException {
        return hrTrackingDataService.getHrTrackingDataByPage(pageUtil,trackingQuery,language);
    }

    @ApiOperation("Xuất file excel")
    @GetMapping("/download")
    public void downloadData(HttpServletResponse response, TrackingQuery trackingQuery,String language) throws NoSuchFieldException, IllegalAccessException {
       ExcelUtils.exportBaseTemp("trackingData.xlsx",response,hrTrackingDataService.downloadData(trackingQuery,language));
     }

}
