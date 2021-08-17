package com.wangqi.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author 王琦
 * @Date 2021/8/14 23:01
 * @Discription
 */
@Slf4j
@Controller
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * 上传文件
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestPart("singleFile") MultipartFile singleFile,
                         @RequestPart("multipleFile") MultipartFile[] multipleFile,
                         Model model) throws IOException {
        // 打印上传信息
        log.info("邮箱={},密码={},单个文件名称={},多个文件个数={}",email,password,singleFile.getSize(),multipleFile.length);
        // 保存到文件服务器，OSS服务器。
        // 这里保存到磁盘
        if (!singleFile.isEmpty()){
            String originalFilename = singleFile.getOriginalFilename();
            singleFile.transferTo(new File("C:\\JAVA_workspace\\uploadTest\\"+originalFilename));
        }
        for (MultipartFile file : multipleFile) {
            if (!file.isEmpty()){
                String filename = file.getOriginalFilename();
                file.transferTo(new File("C:\\JAVA_workspace\\uploadTest\\"+filename));
            }
        }
        // 上传完成刷新页面提示提交成功。
        model.addAttribute("successMsg","提交成功");
        return "form/form_layouts";
    }
}
