package com.atguigu.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/7 16:11
 * @Version 1.0
 */
@Controller
public class FileController {
    @RequestMapping("/test/download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        // 获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        // 获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        FileInputStream stream = new FileInputStream(realPath);
        // 创建字节数组  stream.available()获取文件的字节数
        byte[] bytes = new byte[stream.available()];
        // 将流读到字节数组中
        stream.read(bytes);
        // 创建HttpHeaders对象设置响应头
        MultiValueMap<String, String> headers = new HttpHeaders();
        // 设置要下载的方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,statusCode);
        //关闭输入流
        stream.close();
        return responseEntity;
    }

    @RequestMapping("/test/upload")
    public String testUpload(MultipartFile photo, HttpSession session) throws IOException {
        // 获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        // 获取img文件的真实路径
        String realPath = servletContext.getRealPath("img");
        // 判断img目录是否存在，不存在则创建
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }

        // 获取文件的文件名
        String filename = photo.getOriginalFilename();
        //处理文件重名问题
        String type = filename.substring(filename.lastIndexOf("."));
        String name = filename.substring(0, filename.lastIndexOf("."));
        filename = name + UUID.randomUUID().toString() + type;

        String finalPath = realPath + File.separator + filename;

        photo.transferTo(new File(finalPath));
        return "success";
    }
}
