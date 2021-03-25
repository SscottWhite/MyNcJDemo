package com.example.integration;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class  EmailGetDemo {
    // 发送邮件的账号
    public static String ownEmailAccount = "111@qq.com";
    // 发送邮件的密码------》授权码
    public static String ownEmailPassword = "mfaohwwfzysbbgeb";
    // 发送邮件的smtp 服务器 地址
    public static String myEmailSMTPHost = "smtp.qq.com";//smtp.qq.com
    // 发送邮件对方的邮箱
    public static String receiveMailAccount = "111@qq.com";

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        // 设置邮件传输采用的协议smtp
        prop.setProperty("mail.transport.protocol", "smtp");
        // 设置发送人邮件服务器的smtp地址
        // 这里以网易的邮箱smtp服务器地址为例
        prop.setProperty("mail.smtp.host", myEmailSMTPHost);
        // 设置验证机制
        prop.setProperty("mail.smtp.auth", "true");

        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        // 需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        // QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)

        /*final String smtpPort = "465";
        prop.setProperty("mail.smtp.port", smtpPort);
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");
        prop.setProperty("mail.smtp.socketFactory.port", smtpPort);*/

        // 创建对象回话跟服务器交互
        Session session = Session.getInstance(prop);
        // 会话采用debug模式
        session.setDebug(true);
        // 创建邮件对象
        Message message = createSimpleMail(session);

        Transport trans = session.getTransport();
        // 链接邮件服务器
        trans.connect(ownEmailAccount, ownEmailPassword);
        // 发送信息
        trans.sendMessage(message, message.getAllRecipients());
        // 关闭链接
        trans.close();
    }

    /**  
    * @Title: createSimpleMail  
    * @Description: 创建邮件对象
    * @author: chengpeng
    * @param @param session
    * @param @return
    * @param @throws Exception    设定文件  
    * @return Message    返回类型  
    * @throws  
    */
    public static Message createSimpleMail(Session session) throws Exception {
        MimeMessage msg = new MimeMessage(session);
        // 设置发送邮件地址,param1 代表发送地址 param2 代表发送的名称(任意的) param3 代表名称编码方式
        msg.setFrom(new InternetAddress(ownEmailAccount, "张三", "utf-8"));
        // 代表收件人
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMailAccount, "李四", "utf-8"));
        // To: 增加收件人（可选）
        /*message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
        // Cc: 抄送（可选）
        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
        // Bcc: 密送（可选）
        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));*/
        // 设置邮件主题
        msg.setSubject("测试转发邮件");
        
       /* // 设置邮件内容
        message.setContent("早安,世界   你最近好吗！", "text/html;charset=utf-8");
        // 设置发送时间
        message.setSentDate(new Date());
        // 保存上面的编辑内容
        message.saveChanges();
        // 将上面创建的对象写入本地
        OutputStream out = new FileOutputStream("MyEmail.eml");
        message.writeTo(out);
        out.flush();
        out.close();
        */
        
        
        // 5. 创建图片"节点"
        MimeBodyPart image = new MimeBodyPart();
        // 读取本地文件
        DataHandler dh = new DataHandler(new FileDataSource("src\\main\\java\\tect2.jpg"));
        // 将图片数据添加到"节点"
        image.setDataHandler(dh);
        // 为"节点"设置一个唯一编号（在文本"节点"将引用该ID）
        image.setContentID("mailTestPic");    
         
        // 6. 创建文本"节点"
        MimeBodyPart text = new MimeBodyPart();
        // 这里添加图片的方式是将整个图片包含到邮件内容中, 实际上也可以以 http 链接的形式添加网络图片
        text.setContent("这是一张图片<br/><a href='www.baidu.com'><img src='cid:mailTestPic'/></a>", "text/html;charset=UTF-8");
         
        // 7. （文本+图片）设置 文本 和 图片"节点"的关系（将 文本 和 图片"节点"合成一个混合"节点"）
        MimeMultipart mm_text_image = new MimeMultipart();
        mm_text_image.addBodyPart(text);
        mm_text_image.addBodyPart(image);
        mm_text_image.setSubType("related");    // 关联关系
         
        // 8. 将 文本+图片 的混合"节点"封装成一个普通"节点"
        // 最终添加到邮件的 Content 是由多个 BodyPart 组成的 Multipart, 所以我们需要的是 BodyPart,
        // 上面的 mailTestPic 并非 BodyPart, 所有要把 mm_text_image 封装成一个 BodyPart
        MimeBodyPart text_image = new MimeBodyPart();
        text_image.setContent(mm_text_image);
        
        // 9. 创建附件"节点"
        MimeBodyPart attachment = new MimeBodyPart();
        // 读取本地文件
        DataHandler dh2 = new DataHandler(new FileDataSource("src\\main\\java\\textName.txt"));
        // 将附件数据添加到"节点"
        attachment.setDataHandler(dh2);
        // 设置附件的文件名（需要编码）
        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));       
         
        // 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合"节点" / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text_image);
        mm.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
        mm.setSubType("mixed");         // 混合关系
 
        // 11. 设置整个邮件的关系（将最终的混合"节点"作为邮件的内容添加到邮件对象）
        msg.setContent(mm);
        //设置邮件的发送时间,默认立即发送
        msg.setSentDate(new Date());
         
        return msg;

    }

}