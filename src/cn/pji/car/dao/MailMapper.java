package cn.pji.car.dao;

import cn.pji.car.domain.AdminMail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MailMapper {
    public boolean saveMsg(@Param("sendMailer") String sendMailer, @Param("msgTheme") String msgTheme, @Param("message") String message,@Param("mailTime") String mailTime,
            @Param("status") String status);
    public List<AdminMail> findUsername(@Param("sendMailer")String sendMailer);
    public List<AdminMail> findAllApplication();
    public boolean Agree(@Param("username")String username);
    public boolean statusDeal(@Param("sendMailer")String sendMailer);
}
