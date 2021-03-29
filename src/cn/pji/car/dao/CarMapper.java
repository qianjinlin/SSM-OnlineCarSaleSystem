package cn.pji.car.dao;

import cn.pji.car.domain.Car;
import cn.pji.car.domain.Completed;
import cn.pji.car.domain.LayPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
     public boolean applyCar(@Param("productName")String productName,@Param("productPrice") String productPrice, @Param("productMeters") int productMeters, @Param("productAddress") String productAddress, @Param("productOwner") String productOwner,
                             @Param("productOwnerPhone") String productOwnerPhone, @Param("productTime") String productTime, @Param("productImage1") String productImage1,@Param("productImage2")  String productImage2,@Param("productImage3")  String productImage3,
                             @Param("productImage4") String productImage4,@Param("productOthers")  String productOthers,@Param("productColor")  String productColor,@Param("productOil")  String productOil, @Param("productLength") int productLength,
                             @Param("productWidth") int productWidth,@Param("productBlueB")  String productBlueB, @Param("productOrinPrice") int productOrinPrice, @Param("productBrand") String productBrand, @Param("productMsg") String productMsg,
                             @Param("productStatus") String productStatus,@Param("productEndTime")  String productEndTime);/*申请汽车*/
     public List<Car> findAll();
     public List<Car> findAllById(@Param("id") int id);
     public List<Car> myApply(@Param("Name") String Name);
     public boolean del(@Param("id") int id);
     boolean update(@Param("id")int id);
     boolean updatePrice(@Param("price") String price,@Param("id") int id);
     boolean updateCom(@Param("name") String name);
     List<Completed> findCom(@Param("name") String name);
     List<Car> findMore();
     List<Car> findByBrand(@Param("brand") String brand);
     List<Car> findByColor(@Param("color") String color);
     List<Car> findByAddress(@Param("address") String address);
     List<Car> findByOil(@Param("oil") String oil);
     List<Car> findByBlue(@Param("blue") String blue);
     List<Car> findByG(@Param("others") String others);
     List<Car> findByMeters(@Param("low") String low,@Param("high") String high);
     List<Car> findBC(@Param("brand") String brand,@Param("color")String color);
     List<Car> findBA(@Param("brand")String brand,@Param("address")String address);
     List<Car> findCA(@Param("color")String color,@Param("address")String address);
     List<Car> find3(@Param("brand")String brand,@Param("color")String color,@Param("address")String address);
     List<Car> MetersMore();
     List<Car> laypage(@Param("page") int page,@Param("limit") int limit);

}
