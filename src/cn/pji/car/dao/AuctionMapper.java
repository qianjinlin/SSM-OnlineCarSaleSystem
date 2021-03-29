package cn.pji.car.dao;

import cn.pji.car.domain.Car;
import cn.pji.car.domain.UserComments;
import cn.pji.car.domain.UserMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuctionMapper {
    boolean insert(@Param("sellerName") String sellerName,@Param("userName") String userName, @Param("Message") String Message,@Param("productName") String productName,@Param("price") int price,@Param("time") String time);
    public List<UserMessage> findAllByName(@Param("productName") String productName);
    public List<Car> findAllById(@Param("id") int id);
    boolean insertCo(@Param("text") String text,@Param("username") String username,@Param("time") String time,@Param("Name") String Name);
    List<UserComments> findCo(@Param("Name") String Name);
    List<UserMessage> userMsg(@Param("sellerName") String sellerName);
    boolean delD(@Param("name") String name);
    boolean complete(@Param("name") String name,@Param("user") String user,@Param("time") String time,@Param("price") int price,@Param("Name")String Name);
    List<UserComments> myCom(@Param("username") String  username);
    boolean delCom(@Param("id") int id);
}
