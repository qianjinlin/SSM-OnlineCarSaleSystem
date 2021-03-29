package cn.pji.car.service;

import cn.pji.car.domain.Car;
import cn.pji.car.domain.UserComments;
import cn.pji.car.domain.UserMessage;
import org.apache.ibatis.annotations.Param;

import java.security.SecureRandom;
import java.util.List;

public interface AuctionService {
    boolean insert(String sellerName,String userName,String Message,String productName,int price,String time);
    public List<UserMessage> findAllByName(String productName);
    public List<Car> findAllById(int id);
    boolean insertCo(String text, String username,String time,String Name);
    List<UserComments>  findCo(String  Name);
    List<UserMessage> userMsg(String sellerName);
    boolean delD(String name);
    boolean complete(String name,String user,String time,int price,String Name);
    List<UserComments> myCom(String username);
    boolean delCom(int id);


 }
