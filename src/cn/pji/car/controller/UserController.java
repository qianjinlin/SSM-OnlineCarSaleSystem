package cn.pji.car.controller;

import cn.pji.car.domain.History;
import cn.pji.car.domain.PageUtil6;
import cn.pji.car.domain.User;
import cn.pji.car.service.UserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.List;


@Controller
@RequestMapping("/car")
public class UserController {
    @Autowired
    private UserService userservice;
    //登录
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpSession session) {
        user = userservice.login(user.getUsername(), user.getPassword());
        if (user != null) {
            session.setAttribute("u", user.getUsername());
            return "ok";
        }
        return "error";
    }
    //查询个人信息
    @RequestMapping("/findAllByUsername")
    @ResponseBody
    public List<User> findAllByUsername(String username){
        List<User> list = userservice.findAllByUsername(username);
        return list;
    }
    //更新图片url
    @RequestMapping("/updateImg")
    @ResponseBody
    public boolean updateImageUrl(User user){
        String url= user.getImgUrl();
        Boolean  result = userservice.updateImage(url,user.getUsername());
       if(result){
           return true;
       }
       return false;
    }
    /*修改密码*/
    @RequestMapping("/changePass")
    @ResponseBody
    public boolean changePass(String password,String username){
        Boolean  res= userservice.changePass(password,username);
        if(res){
            return true;
        }
        return false;
    }
    //注册用户
    @RequestMapping("/reg")
    @ResponseBody
    public boolean register(String username,String password,String nickname){
        System.out.println("注册");
        Boolean result=userservice.register(username,password,nickname);
        if(result){
            return true;
        }
        return false;
    }
    //添加浏览记录
    @RequestMapping("/addHistory")
    @ResponseBody
    public boolean addHistory(String carName, String time, String scanner){
        Boolean res = userservice.addHistory(carName,time,scanner);
        if(res){
            return true;
        }
        return false;
    }
    //查找浏览记录
    @RequestMapping("/findHistory")
    @ResponseBody
    public PageUtil6 findHistory(String scanner){
        List<History> list = userservice.findHistory(scanner);
        PageUtil6  p  = new PageUtil6();
        p.setCode(0);
        p.setCount(list.size());
        p.setMsg("获取数据");
        JSONArray jsonArray = JSONArray.fromObject(list);
        p.setData(jsonArray);
        return p;
    }
    //删除浏览记录
    @RequestMapping("/delHis")
    @ResponseBody
    public boolean delHis(int id){
        Boolean res = userservice.delHis(id);
        if(res){
            return true;
        }
        return false;
    }



}


