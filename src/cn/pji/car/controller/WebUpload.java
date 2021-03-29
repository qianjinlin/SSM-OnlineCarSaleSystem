package cn.pji.car.controller;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebUpload {
    //限制上传的文件的后缀名
    private static String suffixStr = "bmp|png|jpg|gif|PNG";
    public static String uploads(MultipartFile file, String dir, HttpServletResponse response, HttpServletRequest request) throws  Exception{
        /*获取文件上传的真实路径*/
        String uploadPath= request.getSession().getServletContext().getRealPath("/");
        try{
            /*判断后缀名是否符合要求*/
            String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            if(suffixStr.indexOf(suffix) == -1){
                System.out.println("文件格式不正确");
            }
            String filePath = dir + File.separator+createNewDir();
            File destfile = new File(uploadPath+filePath);
            if(!destfile.exists()){
                destfile.mkdirs();
            }
            /*保存文件的路径，要是想知道路径的话，直接在controller获取即可*/
            String fileNameNew = getFileNameNew()+"."+suffix;
            File f=new File(destfile.getAbsoluteFile()+File.separator+fileNameNew);//File.separator就是文件名的间隔符
            if(f.exists()){
                return filePath+File.separator+fileNameNew;
            }
            file.transferTo(f);
            f.createNewFile();
            return filePath+File.separator+fileNameNew;
        }catch (Exception e){
            throw e;
        }
    }
    /*为文件重新命名，规则就是当前时间*/
    private static String getFileNameNew(){
        SimpleDateFormat  f= new SimpleDateFormat("yyyyMMddmmssSSS");
        return f.format(new Date());

    }
    /*以当前日期为名创建新文件夹*/
    private static String createNewDir(){
        SimpleDateFormat f= new SimpleDateFormat("yyyyMMdd");
        return f.format(new Date());
    }
}
