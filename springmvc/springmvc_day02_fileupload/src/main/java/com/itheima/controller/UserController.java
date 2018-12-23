package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
@RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws IOException {
    System.out.println("跨服务器上传");
    String path="http://localhost:9090/uploads";
    String filename=upload.getOriginalFilename();
    String uuid= UUID.randomUUID().toString().replace("-","");
    filename=uuid+"_"+filename;
    Client client=Client.create();
    WebResource webResource=client.resource(path+filename);
    webResource.put(upload.getBytes());
    return "success";
}

@RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
    System.out.println("文件上传");
    String path=request.getSession().getServletContext().getRealPath("/upload/");
    File file=new File(path);
    if (!file.exists()){
        file.mkdir();

    }
    DiskFileItemFactory factory=new DiskFileItemFactory();
    ServletFileUpload upload=new ServletFileUpload(factory);
    List<FileItem> items=upload.parseRequest(request);
    for (FileItem item : items) {
        if (item.isFormField()){
            String filename=item.getName();
            String uuid = UUID.randomUUID().toString().replace("-", "");
            filename = uuid+"_"+filename;
            item.write(new File(path,filename));
            item.delete();
        }
    }return "success";
}
}
