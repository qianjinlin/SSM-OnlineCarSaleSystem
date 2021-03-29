package cn.pji.car.service.impl;

import cn.pji.car.dao.AuctionMapper;
import cn.pji.car.domain.Car;
import cn.pji.car.domain.UserComments;
import cn.pji.car.domain.UserMessage;
import cn.pji.car.service.AuctionService;
import com.sun.org.apache.bcel.internal.generic.LUSHR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AuctionService")
@Transactional
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    private AuctionMapper auctionMapper;
    @Override
    public boolean insert(String sellerName, String userName, String Message,String productName, int price, String time) {
        boolean res = auctionMapper.insert(sellerName,userName,Message,productName,price,time);
        return res;
    }

    @Override
    public List<UserMessage> findAllByName(String productName) {
        List<UserMessage> list = auctionMapper.findAllByName(productName);
        return list;
    }

    @Override
    public List<Car> findAllById(int id) {
        List<Car> list = auctionMapper.findAllById(id);
        return list;
    }

    @Override
    public boolean insertCo(String text, String username, String time, String Name) {
        Boolean res  = auctionMapper.insertCo(text,username,time,Name);
        return res;
    }

    @Override
    public List<UserComments> findCo(String Name) {
        List<UserComments> list = auctionMapper.findCo(Name);
        return list;
    }

    @Override
    public List<UserMessage> userMsg(String sellerName) {
        List<UserMessage> list = auctionMapper.userMsg(sellerName);
        return list;
    }

    @Override
    public boolean delD(String name) {
        Boolean  res = auctionMapper.delD(name);
        return res;
    }

    @Override
    public boolean complete(String name, String user, String time, int price,String Name) {
        Boolean res=auctionMapper.complete(name,user,time,price,Name);
        return res;
    }

    @Override
    public List<UserComments> myCom(String username) {
        List<UserComments> list =auctionMapper.myCom(username);
        return list;
    }

    @Override
    public boolean delCom(int id) {
        Boolean res = auctionMapper.delCom(id);
        return res;
    }

}
