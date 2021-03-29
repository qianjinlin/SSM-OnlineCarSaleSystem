package cn.pji.car.service.impl;

import cn.pji.car.dao.CarMapper;
import cn.pji.car.domain.Car;
import cn.pji.car.domain.Completed;
import cn.pji.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CarService")
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public boolean applyCar(String productName, String productPrice, int productMeters, String productAddress, String productOwner, String productOwnerPhone, String productTime, String productImage1, String productImage2, String productImage3, String productImage4, String productOthers, String productColor, String productOil, int productLength, int productWidth, String productBlueB, int productOrinPrice, String productBrand, String productMsg, String productStatus, String productEndTime) {
        Boolean  res=carMapper.applyCar(productName,productPrice,productMeters,productAddress,productOwner,productOwnerPhone,productTime,productImage1,productImage2,productImage3,productImage4,productOthers,productColor,productOil,productLength,productWidth,productBlueB,productOrinPrice,productBrand,productMsg,productStatus,productEndTime);
        return res;
    }

    @Override
    public List<Car> findAll() {
        List<Car> list = carMapper.findAll();
        return list;
    }

    @Override
    public List<Car> findAllById(int id) {
        List<Car> list = carMapper.findAllById(id);
        return list;
    }

    @Override
    public List<Car> myApply(String Name) {
        List<Car> list = carMapper.myApply(Name);
        return list;
    }

    @Override
    public boolean del(int id) {
        boolean res= carMapper.del(id);
        return res;
    }

    @Override
    public boolean update(int id) {
        boolean res= carMapper.update(id);
        return res;
    }

    @Override
    public boolean updatePrice(String price, int id) {
        boolean res = carMapper.updatePrice(price,id);
        return res;
    }

    @Override
    public boolean updateCom(String name) {
        Boolean res = carMapper.updateCom(name);
        return true;
    }

    @Override
    public List<Completed> findCom(String name) {
        List<Completed> list = carMapper.findCom(name);
        return list;
    }

    @Override
    public List<Car> findMore() {
        List<Car> list = carMapper.findMore();
        return list;
    }

    @Override
    public List<Car> findByBrand(String brand) {
        List<Car> list = carMapper.findByBrand(brand);
        return list;
    }

    @Override
    public List<Car> findByColor(String color) {
        List<Car> list = carMapper.findByColor(color);
        return list;
    }

    @Override
    public List<Car> findByAddress(String address) {
        List<Car> list = carMapper.findByAddress(address);
        return list;
    }

    @Override
    public List<Car> findBC(String brand, String color) {
        List<Car> list = carMapper.findBC(brand,color);
        return list;
    }

    @Override
    public List<Car> findBA(String brand, String address) {
        List<Car> list = carMapper.findBA(brand,address);
        return list;
    }

    @Override
    public List<Car> findCA(String color, String address) {
        List<Car> list = carMapper.findCA(color,address);
        return list;
    }

    @Override
    public List<Car> find3(String brand, String color, String address) {
        List<Car> list = carMapper.find3(brand,color,address);
        return list;
    }

    @Override
    public List<Car> findByOil(String oil) {
        List<Car> list = carMapper.findByOil(oil);
        return list;
    }

    @Override
    public List<Car> findByBlue(String blue) {
        List<Car> list =carMapper.findByBlue(blue);
        return list;
    }

    @Override
    public List<Car> findByG(String others) {
        List<Car> list =carMapper.findByG(others);
        return list;
    }

    @Override
    public List<Car> findByMeters(String low, String high) {
        List<Car> list =carMapper.findByMeters(low,high);
        return list;
    }

    @Override
    public List<Car> MetersMore() {
        List<Car> list = carMapper.MetersMore();
        return list;
    }

    @Override
    public List<Car> laypage(int page, int limit) {
        List<Car> list = carMapper.laypage(page,limit);
        return list;
    }

}
