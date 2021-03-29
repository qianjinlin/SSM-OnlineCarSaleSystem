package cn.pji.car.controller;

import cn.pji.car.domain.*;
import cn.pji.car.service.AuctionService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@RequestMapping("/auc")
@Controller
public class AuctionController {
    @Autowired
    private AuctionService auctionService;
    //用户点击拍卖成功后就会在卖家的信息里添加信息告诉卖家
    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(String sellerName,String userName,String Message,String productName,int price,String time){
        String  time1 = time;
        boolean  res = auctionService.insert(sellerName,userName,Message,productName,price,time1);
        if(res){
            return true;
        }
        return false;
    }
    //显示参与该商品拍卖的人
    @RequestMapping("/findAllByName")
    @ResponseBody
    public PageUtil1  findAllByName(String  productName){
        List<UserMessage> list = auctionService.findAllByName(productName);
        PageUtil1 pageUtil = new PageUtil1();
        pageUtil.setCode(0);
        pageUtil.setMsg("数据获取成功");
        pageUtil.setCount(list.size());
        JSONArray  jsonArray = JSONArray.fromObject(list);
        pageUtil.setData(jsonArray);
        System.out.println(jsonArray);
        return pageUtil;
    }
    //显示商品参数
    @RequestMapping("/findAllById")
    @ResponseBody
    public PageUtil3 findAllById(int id){
         List<Car> list = auctionService.findAllById(id);
         PageUtil3  page = new PageUtil3();
         page.setCode(0);
         page.setMsg("数据获取成功");
         page.setCount(list.size());
         JSONArray  jsonArray = JSONArray.fromObject(list);
         page.setData(jsonArray);
         return page;
    }
    /*将用户的评论存储起来*/
    @RequestMapping("/insertCo")
    @ResponseBody
    public boolean insertCo(String text,String username,String time,String Name){
        Boolean res = auctionService.insertCo(text,username,time,Name);
        if(res){
            return true;
        }
        return false;

    }
    //加载评论
    @RequestMapping("/findCo")
    @ResponseBody
    public List<UserComments> findCo(String Name){
        List<UserComments> list = auctionService.findCo(Name);
        return list;
    }
    //显示用户所有的拍卖信息
    @RequestMapping("/userMsg")
    @ResponseBody
    public PageUtil1 userMsg1(String sellerName){
        List<UserMessage> list = auctionService.userMsg(sellerName);
        System.out.println(list);
        PageUtil1 pa = new PageUtil1();
        pa.setCode(0);
        pa.setMsg("数据获取成功");
        pa.setCount(list.size());
        JSONArray jsonArray = JSONArray.fromObject(list);
        pa.setData(jsonArray);
        return pa;
    }
    //批量删除拍卖信息
    @RequestMapping("/delD")
    @ResponseBody
    public boolean delD(String name){
        Boolean res = auctionService.delD(name);
        if (res){
            return true;
        }
        return false;
    }
    //成交订单
    @RequestMapping("/com")
    @ResponseBody
    public boolean complete(String name,String user,String time,int price,String Name){
        Boolean res= auctionService.complete(name,user,time,price,Name);
        if(res){
            return true;
        }
        return false;
    }
    //显示我的评论
    @RequestMapping("/myCom")
    @ResponseBody
    public PageUtil5 myCom(String  username){
        List<UserComments> list = auctionService.myCom(username);
        PageUtil5 p =new PageUtil5();
        p.setCode(0);
        p.setMsg("数据获取成功");
        p.setCount(list.size());
        JSONArray  data =JSONArray.fromObject(list);
        p.setData(data);
        return p;
    }
    //删除评论
    @RequestMapping("/delCom")
    @ResponseBody
    public boolean delCom(int id){
        Boolean res = auctionService.delCom(id);
        if(res){
            return true;
        }
        return false;
    }
}
