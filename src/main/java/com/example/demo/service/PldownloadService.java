package com.example.demo.service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface PldownloadService {
    void plDownload(HttpServletResponse response,String ids);
}
