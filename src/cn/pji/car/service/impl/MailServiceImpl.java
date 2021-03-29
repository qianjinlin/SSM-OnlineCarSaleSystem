package cn.pji.car.service.impl;

import cn.pji.car.dao.MailMapper;
import cn.pji.car.domain.AdminMail;
import cn.pji.car.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("MailService")
@Transactional
public class MailServiceImpl implements MailService {
    @Autowired
    private MailMapper mailMapper;
    @Override
    public boolean saveMsg(String sendMailer, String msgTheme, String message, String mailTime, String status) {
        Boolean result = mailMapper.saveMsg(sendMailer,msgTheme,message,mailTime,status);
        return result;
    }

    @Override
    public List<AdminMail> findUsername(String sendMailer) {
        List<AdminMail> list = mailMapper.findUsername(sendMailer);
        return list;
    }

    @Override
    public List<AdminMail> findAllApplication() {
        List<AdminMail> list = mailMapper.findAllApplication();
        return list;
    }

    @Override
    public boolean Agree(String username) {
        Boolean res = mailMapper.Agree(username);
        return res;
    }

    @Override
    public boolean statusDeal(String sendMailer) {
        Boolean res= mailMapper.statusDeal(sendMailer);
        return res;
    }

}
