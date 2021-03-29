package cn.pji.car.controller;

import cn.pji.car.domain.AdminMail;
import cn.pji.car.domain.PageUtil;
import cn.pji.car.service.MailService;
import net.sf.json.JSONArray;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;
    /*保存用户申请的内容*/
    @RequestMapping("/save")
    @ResponseBody
    public boolean saveMsg(String sendMailer,String msgTheme,String message,String mailTime,String status){
        Boolean result  = mailService.saveMsg(sendMailer,msgTheme,message,mailTime,status);
        if(result){
            return true;
        }
        return false;
    }
    /*当用户点击申请超过两次，则返回false，不可以连续点击申请*/
    @RequestMapping("/find")
    @ResponseBody
    public boolean findUsername(String sendMailer){
        List<AdminMail> list=mailService.findUsername(sendMailer);
        if(list.size()<=0){
            return true;
        }
        return false;
    }
    /*查询所有用户的申请，layui要求返回的数据必须按照他的格式，所以一般的返回无效*/
    @RequestMapping("/findAllApplication")
    @ResponseBody
    public PageUtil findAllApplication(){
       List<AdminMail> list = mailService.findAllApplication();
       PageUtil result = new PageUtil();
       result.setCode(0);
       result.setMsg("数据获取成功");
       result.setCount(list.size());
       JSONArray jsonArray = JSONArray.fromObject(list);
       result.setData(jsonArray);
       return result;
   }
   /*当管理员点击同意的时候，就执行该代码*/
   @RequestMapping("/agree")
   @ResponseBody
   public boolean Agree(String username){
        Boolean res= mailService.Agree(username);
        if(res){
            return true;
        }
        return false;
   }
   /*修改邮件处理状态*/
   @RequestMapping("/statusDeal")
   @ResponseBody
   public boolean statusDeal(String sendMailer){
       System.out.println(sendMailer);
       Boolean res=mailService.statusDeal(sendMailer);
       if(res){
           return true;
       }
       return false;
   }


}
