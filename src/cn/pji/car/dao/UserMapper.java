package cn.pji.car.dao;

import cn.pji.car.domain.History;
import cn.pji.car.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public User login(@Param("username") String username, @Param("password") String password);/*登录*/
    public List<User> findAllByUsername(@Param("username")String username);/*打开基本信息页面的时候就加载该人的所有信息*/
    public boolean updateImage(@Param("imgUrl")String imgUrl,@Param("username")String username);
    public boolean changePass(@Param("password")String password,@Param("username")String username);/*修改密码*/
    public boolean register(@Param("username") String username,@Param("password") String password,@Param("nickname") String nickname);/*注册用户*/
    public boolean addHistory(@Param("carName") String carName,@Param("time") String time,@Param("scanner") String scanner);
    public List<History> findHistory(@Param("scanner") String scanner);
    boolean delHis(@Param("id") int id);
}
