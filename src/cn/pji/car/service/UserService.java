package cn.pji.car.service;

import cn.pji.car.domain.History;
import cn.pji.car.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public User login(String username, String password);

    public List<User> findAllByUsername(String username);

    public boolean updateImage(String imgUrl, String username);

    public boolean changePass(String password, String username);

    public boolean register(String username, String password, String nickname);
    public boolean addHistory(String carName,String time,String scanner);
    public List<History> findHistory( String scanner);
    boolean  delHis(int id);
}
