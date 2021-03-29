package cn.pji.car.controller;

import cn.pji.car.domain.UploadResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*用户头像上传模块*/
@Controller
@RequestMapping("/car")
public class UploadController {
    @RequestMapping("/upload")
    @ResponseBody
    public UploadResult uploadImages(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
        /*服务器的图片是永久存在的,关闭服务器就获取不了头像信息什么的了*/
        System.out.println("我进来了");
        String dir = "web/img/";
        UploadResult result =new UploadResult();
        try{
            String path= WebUpload.uploads(file,dir,response,request);
            result.setStatus(400);
            result.setFilePath(path);
            System.out.println(path);//现在这个path就是你后台接收到的path
        }catch (Exception e){
            throw e;
        }
        return result;
    }

}
