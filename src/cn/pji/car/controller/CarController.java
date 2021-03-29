package cn.pji.car.controller;

import cn.pji.car.dao.CarMapper;
import cn.pji.car.domain.*;
import cn.pji.car.service.CarService;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import net.sf.json.JSONArray;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/app")
public class CarController {
    @Autowired
    private CarService carService;
    @RequestMapping("/up1")
    @ResponseBody
    public UploadResult up1(MultipartFile file, HttpServletResponse response, HttpServletRequest request){
        //车辆图片上传
        UploadResult  result1 = new UploadResult();
        String mkdir="car/up1/";
        try {
            String path1 = WebUpload.uploads(file,mkdir, response,request);
            result1.setStatus(500);
            result1.setFilePath(path1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result1;

    }
    @RequestMapping("/up2")
    @ResponseBody
    public UploadResult up2(MultipartFile file, HttpServletResponse response, HttpServletRequest request){
        //车辆图片上传
        UploadResult  result2 = new UploadResult();
        String mkdir="car/up2/";
        try {
            String path2 = WebUpload.uploads(file,mkdir, response,request);
            result2.setStatus(500);
            result2.setFilePath(path2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result2;

    }
    @RequestMapping("/up3")
    @ResponseBody
    public UploadResult up3(MultipartFile file, HttpServletResponse response, HttpServletRequest request){
        //车辆图片上传
        UploadResult  result3 = new UploadResult();
        String mkdir="car/up3/";
        try {
            String path3 = WebUpload.uploads(file,mkdir, response,request);
            result3.setStatus(500);
            result3.setFilePath(path3);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result3;

    }
    @RequestMapping("/up4")
    @ResponseBody
    public UploadResult up4(MultipartFile file, HttpServletResponse response, HttpServletRequest request){
        //车辆图片上传
        UploadResult  result4 = new UploadResult();
        String mkdir="car/up4/";
        try {
            String path4 = WebUpload.uploads(file,mkdir, response,request);
            result4.setStatus(500);
            result4.setFilePath(path4);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result4;

    }
    /*用户发布汽车信息*/
    @RequestMapping("/apply")
    @ResponseBody
    public boolean applyCar(String productName,String productPrice,int productMeters,String productAddress,String productOwner,
                            String productOwnerPhone,String productTime,String productImage1,String productImage2,String productImage3,
                            String productImage4,String productOthers,String productColor,String productOil,int productLength,
                            int productWidth,String productBlueB,int productOrinPrice,String productBrand,String productMsg,
                            String productStatus,String productEndTime){
        String img1 = productImage1;String img2=productImage2;String img3=productImage3;String  img4=productImage4;
        String time = productTime;String price = productPrice;String name = productName;int meters = productMeters;
        String address = productAddress;String owner = productOwner;String phone = productOwnerPhone;String others = productOthers;String color=productColor;
        String oil = productOil;int length = productLength;int width = productWidth;String blue = productBlueB;int orinPrice = productOrinPrice;
        String brand = productBrand;String msg = productMsg;String status = productStatus;String  endTime = productEndTime;
        Boolean res = carService.applyCar(name,price,meters,address,owner,phone,time,img1,img2,img3,img4,others,color,oil,length,width,blue,orinPrice,brand,msg,status,endTime);
        if(res){
            return true;
        }
        return false;
    }
    /*加载所有的商品信息*/
    @RequestMapping("/show")
    @ResponseBody
    public List<Car> findAll(){
        List<Car> list = carService.findAll();
        return list;
    }
    /*显示物品详情页*/
    @RequestMapping("/info")
    @ResponseBody
    public List<Car> findAllById(int id){
        List<Car> list = carService.findAllById(id);
        return list;
    }
    /*我发布的商品*/
    @RequestMapping("/myapp")
    @ResponseBody
    public PageUtil3 myApply(String Name){

        List<Car> list = carService.myApply(Name);
        PageUtil3  p =new PageUtil3();
        p.setCount(list.size());
        p.setMsg("获取成功");
        p.setCode(0);
        JSONArray jsonArray =JSONArray.fromObject(list);
        p.setData(jsonArray);
        return p;
    }
    /*删除指定的商品*/
    @RequestMapping("/del")
    @ResponseBody
    public Boolean del(int id){
        boolean res= carService.del(id);
        if (res){
            return true;
        }
        return false;
    }
    //更新拍卖状态
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(int id){
        Boolean  res = carService.update(id);
        if(res){
            return true;
        }
        return false;
    }
    //修改价格
    @RequestMapping("/updatePrice")
    @ResponseBody
    public boolean updatePrice(String price,int id){
        boolean res = carService.updatePrice(price,id);
        if(res){
            return true;
        }
        return false;
    }
    @RequestMapping("/updateCom")
    @ResponseBody
    public boolean updateCom(String name){
        boolean  res = carService.updateCom(name);
        if(res){
            return true;
        }
        return false;
    }
    @RequestMapping("/findCom")
    @ResponseBody
    public PageUtil4 findCom(String name){
         List<Completed> list = carService.findCom(name);
         PageUtil4   p= new PageUtil4();
         p.setCode(0);
         p.setCount(list.size());
         p.setMsg("数据获取成功");
         JSONArray  jsonArray = JSONArray.fromObject(list);

         p.setData(jsonArray);
         return p;
    }
    //更多综合条件筛选
    @RequestMapping("/findMore")
    @ResponseBody
    public PageUtil3 findMore(){
        List<Car> list = carService.findMore();
        PageUtil3  pageUtil3 = new PageUtil3();
        pageUtil3.setCode(0);
        pageUtil3.setCount(list.size());
        pageUtil3.setMsg("数据获取成功");
        JSONArray jsonArray =JSONArray.fromObject(list);
        pageUtil3.setData(jsonArray);
        return pageUtil3;
    }
    //筛选条件
    @RequestMapping("/reload")
    @ResponseBody
    public PageUtil3 reload(String brand,String color,String address){
        PageUtil3 p =new PageUtil3();
        p.setCode(0);
        p.setMsg("获取成功");
        if(CheckNull(brand) & CheckNull(address)){
            System.out.println('1');
            List<Car> list = carService.findByColor(color);
            JSONArray  jsonArray = JSONArray.fromObject(list);
            p.setCount(list.size());
            p.setData(jsonArray);
        }else if(CheckNull(color) & CheckNull(brand)){
            System.out.println("2");
            List<Car> list = carService.findByAddress(address);
            JSONArray  jsonArray = JSONArray.fromObject(list);
            p.setCount(list.size());
            p.setData(jsonArray);
        }else if(CheckNull(color) & CheckNull(address)) {
            List<Car> list = carService.findByBrand(brand);
            JSONArray  jsonArray = JSONArray.fromObject(list);
            p.setCount(list.size());
            p.setData(jsonArray);
        }else if(CheckNull(brand)){
            List<Car> list = carService.findCA(color,address);
            JSONArray  jsonArray = JSONArray.fromObject(list);
            p.setCount(list.size());
            p.setData(jsonArray);
        }else if(CheckNull(color)){
            List<Car> list = carService.findBA(brand,address);
            JSONArray  jsonArray = JSONArray.fromObject(list);
            p.setCount(list.size());
            p.setData(jsonArray);
        }else if(CheckNull(address)){
            List<Car> list = carService.findBC(brand,color);
            JSONArray  jsonArray = JSONArray.fromObject(list);
            p.setCount(list.size());
            p.setData(jsonArray);
        }else {
            List<Car> list = carService.find3(brand,color,address);
            JSONArray  jsonArray = JSONArray.fromObject(list);
            p.setCount(list.size());
            p.setData(jsonArray);
        }
        return p;
    }
    public boolean CheckNull(String  str){
        if(str == null || str.equals("") || str.isEmpty()){
            return true;
        }
        return false;
    }
    //根据Brand查找
    @RequestMapping("/brand")
    @ResponseBody
    public List<Car> findByBrand(String brand){
        List<Car> list = carService.findByBrand(brand);
        return list;
    }
    //根据address查找
    @RequestMapping("/address")
    @ResponseBody
    public List<Car> findByAddress(String address){
        List<Car> list =carService.findByAddress(address);
        return list;
    }
    //根据oil查找
    @RequestMapping("/oil")
    @ResponseBody
    public List<Car> findByOil(String oil){
        List<Car> list = carService.findByOil(oil);
        return list;
    }
    //根据Meters
    @RequestMapping("/meters")
    @ResponseBody
    public List<Car> findByMeters(String  low,String high){
        List<Car> list  = carService.findByMeters(low,high);
        return list;
    }
    //根据环保标准查找
    @RequestMapping("/blue")
    @ResponseBody
    public List<Car> findByBlueB(String blue){
        List<Car> list = carService.findByBlue(blue);
        return list;
    }
    //根据过户次数查找
    @RequestMapping("/others")
    @ResponseBody
    public List<Car> findByG(String others){
        List<Car> list = carService.findByG(others);
        return list;
    }
    //更多里程数
    @RequestMapping("/metersMore")
    @ResponseBody
    public List<Car> more(){
        List<Car> MetersMore = carService.MetersMore();
        return MetersMore;
    }
    //实现分页效果
    @RequestMapping("/laypage")
    @ResponseBody
    public List<Car> laypage(int page,int limit){
        List<Car> list = carService.laypage(page,limit);
        return list;
    }
}
