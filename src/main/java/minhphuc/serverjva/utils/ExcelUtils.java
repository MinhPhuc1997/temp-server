package minhphuc.serverjva.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import minhphuc.serverjva.model.orther.ExcelBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;


public class ExcelUtils {

    public static void exportExcel(String filename , String sheetname, List<?> list, Class<?> pojoClass, HttpServletResponse response){
        try {
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,HttpHeaders.CONTENT_DISPOSITION);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment;filname="+filename+System.currentTimeMillis());
        EasyExcel.write(response.getOutputStream(),pojoClass).sheet(filename).doWrite(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exportBaseTemp(String filename,HttpServletResponse response,List<?> list){
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,HttpHeaders.CONTENT_DISPOSITION);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+filename);
        ClassPathResource pathResource = new ClassPathResource("templates/"+filename);
        try(InputStream inputStream = pathResource.getInputStream();

            ServletOutputStream outputStream = response.getOutputStream()
        ){
            ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(list,fillConfig,writeSheet);
            excelWriter.finish();
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }
}
