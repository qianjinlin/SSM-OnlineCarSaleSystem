package cn.pji.car.service.impl;

import cn.pji.car.dao.UserMapper;
import cn.pji.car.domain.History;
import cn.pji.car.domain.User;
import cn.pji.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usermapper;
    @Override
    public User login(String username, String password) {
        User user=usermapper.login(username,password);
        if(user.getPassword().equals(password)){
           return user;
        }
        return null;
    }
    /* 查询个人信息*/
    @Override
    public List<User> findAllByUsername(String username) {
        List<User> list = usermapper.findAllByUsername(username);
        return list;
    }
    /*更新用户头像地址*/
    @Override
    public boolean updateImage(String imgUrl,String username) {
        boolean result = usermapper.updateImage(imgUrl,username);
        return result;
    }
    /*修改密码*/
    @Override
    public boolean changePass(String password, String username) {
        Boolean res = usermapper.changePass(password,username);
        return res;
    }
    /*注册用户*/
    @Override
    public boolean register(String username, String password, String nickname) {
        Boolean res = usermapper.register(username,password,nickname);
        return res;
    }

    @Override
    public boolean addHistory(String carName, String time, String scanner) {
        boolean res = usermapper.addHistory(carName,time,scanner);
        return res;
    }

    @Override
    public List<History> findHistory(String scanner) {
        List<History> list = usermapper.findHistory(scanner);
        return list;
    }

    @Override
    public boolean delHis(int id) {
        boolean res = usermapper.delHis(id);
        return res;
    }


}
