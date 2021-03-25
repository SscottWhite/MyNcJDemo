package com.example.integration.email2;

/**
 * https://blog.csdn.net/tterminator/article/details/53327468?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&dist_request_id=1328679.64927.16164863129753995&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
 * @author KJS_352
 *
 */
public class MailTest {
	public static void main(String[] args) throws Exception {
        MailSender mailSender = MailSender.getInstance();
        MailInfo mailInfo = mailSender.getMailInfo();
        mailSender.sendHtmlMail(mailInfo, 3);
    }
}
