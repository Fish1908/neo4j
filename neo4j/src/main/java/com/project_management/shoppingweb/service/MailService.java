package com.project_management.shoppingweb.service;

import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import org.springframework.mail.SimpleMailMessage;

public interface MailService {

    public RequestResultVO sengSimpleMail(String to, String subject, String content);
}
