package cn.pji.car.service;

import cn.pji.car.domain.Car;
import cn.pji.car.domain.Completed;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarService {
    public boolean applyCar(String productName,String productPrice,int productMeters,String productAddress,String productOwner,
                            String productOwnerPhone,String productTime,String productImage1,String productImage2,String productImage3,
                            String productImage4,String productOthers,String productColor,String productOil,int productLength,
                            int productWidth,String productBlueB,int productOrinPrice,String productBrand,String productMsg,
                            String productStatus,String productEndTime);
    public List<Car> findAll();
    public List<Car> findAllById(int id);
    public List<Car> myApply(String Name);
    boolean del(int id);
    boolean update(int id);
    boolean updatePrice(String price,int id);
    boolean updateCom(String name);
    List<Completed> findCom(String name);
    List<Car> findMore();
    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByAddress( String address);
    List<Car> findBC(String brand,String color);
    List<Car> findBA(String brand,String address);
    List<Car> findCA(String color,String address);
    List<Car> find3(String brand,String color,String address);

    List<Car> findByOil(String oil);
    List<Car> findByBlue(String blue);
    List<Car> findByG(String others);
    List<Car> findByMeters(String low,String high);
    List<Car> MetersMore();
    List<Car> laypage(int page,int limit);
}
