package com.project_management.shoppingweb.service;

import org.springframework.mail.SimpleMailMessage;

public interface MailService {

    public void sengSimpleMail(String to, String subject, String content);
}
