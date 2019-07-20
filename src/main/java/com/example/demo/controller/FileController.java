package com.example.demo.controller;



import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.dao.CompanyMapper;
import com.example.demo.dao.DeptmentMapper;
import com.example.demo.dao.RecordingMapper;
import com.example.demo.po.Company;
import com.example.demo.po.Recording;
import com.example.demo.service.PldownloadService;
import com.example.demo.utils.FastDFSClient;
import com.example.demo.utils.FastDFSPollClient;
import com.example.demo.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/file")
public class FileController
{

    @Autowired
    private FastDFSClient fastDFSClient;

    @Autowired
    private FastDFSPollClient fastDFSPollClient;

    @Autowired
    private RecordingMapper recordingMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private PldownloadService pldownloadService;
    /**
     * 上传文件
     *
     * @author kokJuis
     * @version 1.0
     * @date 2016-12-12
     * @return
     */


    @PostMapping("uploadMsg")
    public boolean uploadMsg(@RequestBody Recording recording,@RequestParam String cname){
        Company company =  companyMapper.getByCname(cname);
        if(company!=null){
            recording.setCid(company.getCid());
        }else{
            Company c = new Company();
            c.setName(cname);
            companyMapper.insert(c);
            recording.setCid(c.getCid());
        }
        int insert = recordingMapper.insert(recording);
        if(insert>0){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public Map<String, Object> uploadFile(@RequestParam MultipartFile filedata)
    {

        Map<String, Object> m = new HashMap<String, Object>();

        if (filedata != null && !filedata.isEmpty())
        {
            try
            {
                String path = fastDFSPollClient.uploadFile(filedata.getBytes(), filedata.getOriginalFilename());
                m.put("code", 200);
                m.put("url", path);
                m.put("msg", "上传成功");
                System.out.println(path);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                m.put("code", 400);
                m.put("msg", "上传失败");
            }
        }
        else
        {
            m.put("code", 501);
            m.put("msg", "参数丢失");
        }
        return m;

    }

    /**
     * 下载文件
     *
     * @author kokJuis
     * @version 1.0
     * @date 2016-12-12
     * @return
     */
    @RequestMapping(value = "getFileByPath", method = RequestMethod.GET)
    public void getFileByPath(HttpServletResponse response, @RequestParam("path") String path,
                              @RequestParam("sname") String sname,
                              @RequestParam("cname") String cname,
                              @RequestParam("recordingTime") String recordingTime,
                              @RequestParam("dname") String dname,
                              @RequestParam("isAdopt") Integer isAdopt) {
        String adopt;
        if(isAdopt==1){
            adopt="面试通过";
        }else if(isAdopt==0){
            adopt="面试未通过";
        }else{
            adopt="等待通知";
        }
        String filename=FileUtil.getOriginalFilename(path);
        String subFilename=filename.substring(filename.indexOf("."),filename.length());
        String filenames =dname+sname+cname+recordingTime+adopt+subFilename;

        try
        {
            // 判断文件是否存在
            if (fastDFSPollClient.getFileInfo(path) != null)
            {
                byte[] buffer = fastDFSPollClient.downloadFile(path);
                // 清空response
                filenames=URLEncoder.encode(filenames, "UTF-8");
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


    @GetMapping("/plDownload")
    public void plDownload(HttpServletResponse response, @RequestParam String ids){
        pldownloadService.plDownload(response,ids);
    }

}

