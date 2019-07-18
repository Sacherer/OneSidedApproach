package com.example.demo.controller;



import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.utils.FastDFSClient;
import com.example.demo.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/file")
public class FileController
{

    @Autowired
    private FastDFSClient fastDFSClient;

    /**
     * 上传文件
     *
     * @author kokJuis
     * @version 1.0
     * @date 2016-12-12
     * @return
     */

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public Map<String, Object> uploadFile(@RequestParam MultipartFile filedata)
    {

        Map<String, Object> m = new HashMap<String, Object>();

        if (filedata != null && !filedata.isEmpty())
        {
            try
            {

                String path = fastDFSClient.uploadFile(filedata.getBytes(), filedata.getOriginalFilename());

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
     * @param imagePath
     * @param local
     * @return
     */
    @RequestMapping(value = "getFileByPath", method = RequestMethod.GET)
    public void getFileByPath(HttpServletResponse response, String path)
    {

        try
        {
            // 判断文件是否存在
            if (fastDFSClient.getFileInfo(path) != null)
            {
                byte[] buffer = fastDFSClient.downloadFile(path);
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Disposition",
                        "attachment;filename=" + FileUtil.getOriginalFilename(path));
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

