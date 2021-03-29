package cn.pji.car.service;

import cn.pji.car.domain.AdminMail;

import java.util.List;

public interface MailService {
    public boolean saveMsg(String sendMailer,String msgTheme,String message,String mailTime,String status);
    public List<AdminMail> findUsername(String sendMailer);
    public List<AdminMail> findAllApplication();
    public boolean Agree(String username);
    public boolean statusDeal(String sendMailer);
}
