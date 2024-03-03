package com.example.jobseeker.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleMail(String receiver) {
        // Creating a simple mail message
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        // Setting up necessary details
        mailMessage.setFrom(sender);
        mailMessage.setTo(receiver);
        mailMessage.setText("Mã OTP của bạn là: 123456.\n\n Không chia sẻ mã này cho bất kỳ ai!");
        mailMessage.setSubject("[Techmaster] OTP Vefification");

        // Sending the mail
        javaMailSender.send(mailMessage);
    }

    public void sendMailWithAttachment(String receiver) throws MessagingException {
        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        // Setting multipart as true for attachments to
        // be send
        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(receiver);
        mimeMessageHelper.setText("Email có đính kèm file");
        mimeMessageHelper.setSubject("[DEMO MAIL] Gửi mail kèm file");

        // Adding the attachment
        FileSystemResource file = new FileSystemResource(new File("/Users/buibatruong/Desktop/1506ccd7-58d2-410d-b284-39c86a1dc2a4.png"));
        mimeMessageHelper.addAttachment(file.getFilename(), file);

        // Sending the mail
        javaMailSender.send(mimeMessage);
    }
    public void otpSendingMail(String name, String receiver, String otp) throws MessagingException {
        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        // Setting multipart as true for attachments to be send
        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(receiver);
        mimeMessageHelper.setText("Bạn <b>" + name +
                "</b> thân mến,<br>Đây là OTP của bạn, OTP có giá trị sử dụng một lần duy nhất. Vui lòng truy cập website để lấy lại mật khẩu.<br>" +
                otp, true);
        mimeMessageHelper.setSubject("[Larna - Học tập] Lấy lại mật khẩu");

        // Adding the attachment
//        FileSystemResource file = new FileSystemResource(new File("data/1.jpg"));
//        mimeMessageHelper.addAttachment(file.getFilename(), file);

        // Sending the mail
        javaMailSender.send(mimeMessage);
    }
    @Async
    public void verifyAccount(Long id, String name, String receiver) throws MessagingException {
        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        // Setting multipart as true for attachments to be send
        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(receiver);
        mimeMessageHelper.setSubject("[Larna - Học tập] Kích hoạt tài khoản");

        String emailContent = "Xin chào <b>" + name + "</b>,<br>" +
                "Chúc mừng bạn đã đăng ký thành công tài khoản với username " + receiver +
                ".<br> Vui lòng click vào liên kết sau để kích hoạt tài khoản: <br><br>" +
                "<a class=\"btn btn-primary f-500\" target=\"_blank\" " +
                "href=\"http://localhost:8080/accounts/"+ id +"/activation\">Kích hoạt tài khoản</a>";
        mimeMessageHelper.setText(emailContent, true);

        // Sending the mail
        javaMailSender.send(mimeMessage);
    }

}
