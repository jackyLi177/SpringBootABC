package com.jacky.mail.service;

/**
 * @Author : liyongjie
 * @Date : 2018/8/17 0017
 */
public interface MyMailService {

    public void sendSimpleMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content,String filePath);

    public void sendHtmlMail(String to, String subject, String content);

    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
