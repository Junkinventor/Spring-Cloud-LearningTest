package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ProjectName: SpringMvcSpringMybatis
 * @Package: util
 * @ClassName: EmailUtil
 * @Author: 废材
 * @Description: 邮箱发送工具类
 * @Date: 2019/1/27 10:25
 * @Version: 1.0
 */

/**
 * 类的变量
 *   title：邮件的标题
 *   text：邮件内容
 */

public class EmailUtil {
    public static void sendEmail(String toEmail,
                                 String fromEmail,
                                 final String authEmail,
                                 final String authPaw,
                                 String title,
                                 String text) throws MessagingException {



        Properties propertiesEmail=new Properties();

        InputStream email = EmailUtil.class.getClassLoader().getResourceAsStream("Email");

        try {
            propertiesEmail.load(email);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*发送邮件的基本配置*/

        String ReceiveToEmail=toEmail;//用户接收邮箱地址
        String SendEmail=fromEmail;//发送人邮箱
        String host="smtp.qq.com";//指定发送邮件的主机
        propertiesEmail.getProperty("mail.smtp.host");//设置服务器地址
        propertiesEmail.getProperty("mail.debug");    //开启debug模式
        propertiesEmail.getProperty("mail.smtp.auth");//开启身份验证
        propertiesEmail.getProperty("mail.smtp.port","mail.smtp.port.Dc");//设置邮件发送服务器端口
        propertiesEmail.getProperty("mail.smtp.socketFactory.port","mail.smtp.socketFactory.port.Dc");//设置SSL加密端口
        propertiesEmail.getProperty("mail.smtp.timeout","mail.smtp.timeout.Dc");//设置连接超时




        //这两个读取properties文件的区别前者直接读自定义的properties文件，后者会优先去查找内存和缓存中的properties没有再使用用户自定义的
        Session session=Session.getInstance(propertiesEmail);
        //session.getDefaultInstance();

        //由于Message是抽象类所以需要使用MimeMessage类创建对象
        Message message=new MimeMessage(session);


        message.setFrom(new InternetAddress("1390926106@qq.com"));//设置发件人



        //设置收件人多个
        message.setRecipients(Message.RecipientType.TO,new InternetAddress[]{
                new InternetAddress("1390926106@qq.com")
        });
        //设置收件人单个
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("1390926106@qq.com"));




        message.setSubject("来自java的邮件");//邮件标题

        message.setText("Hello World");//邮件内容

        Transport transport=session.getTransport();//得到邮差对象

        transport.connect("xxxxxx@qq.com","QQ邮箱验证码"); //连接SMTP服务器直接传递用户认证信息


        transport.sendMessage(message,message.getAllRecipients());
    }

}
