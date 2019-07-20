package com.example.demo.service.impl;

import com.example.demo.dao.RecordingMapper;
import com.example.demo.dto.StudentRecordIngListDTO;
import com.example.demo.service.PldownloadService;
import com.example.demo.utils.FastDFSPollClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class PldownloadServiceImpl implements PldownloadService {
    @Autowired
    private RecordingMapper recordingMapper;

    @Autowired
    private FastDFSPollClient fastDFSPollClient;

    @Override
    public void plDownload(HttpServletResponse response, String ids) {
        List<StudentRecordIngListDTO> list= recordingMapper.selectByIds(ids);

        String path = "";
        String name = "";
        if(list.size()==1){
            StudentRecordIngListDTO sdto = list.get(0);
            path=sdto.getFileurl();
            String adopt;
            if(sdto.getIsadopt()==1){
                adopt="面试通过";
            }else if(sdto.getIsadopt()==0){
                adopt="面试未通过";
            }else{
                adopt="等待通知";
            }
            String subStr =  sdto.getFileurl().substring(sdto.getFileurl().indexOf("."),sdto.getFileurl().length());
            name = sdto.getDeptments().get(0).getDname()+sdto.getSname()+sdto.getName()+sdto.getRecordingtime()+adopt+subStr;
        }else{
            long nowTime = new Date().getTime();
            name = "recording_" + nowTime + ".zip";

        }
        try
        {// 判断文件是否存在
            if (fastDFSPollClient.getFileInfo(path) != null)
            {
                byte[] buffer = fastDFSPollClient.downloadFile(path);
                // 清空response
                String filenames=URLEncoder.encode(path, "UTF-8");
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Disposition",
                        "attachment;filename=" + filenames);
                response.addHeader("Content-Length", "" + buffer.length);
                // 通过文件流的形式写到客户端
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                toClient.write(buffer);
                // 写完以后关闭文件流
                toClient.flush();
                toClient.close();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
