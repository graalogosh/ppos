package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 18.02.2016.
 */
@RestController
@RequestMapping(value = "mail")
public class MailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(method = RequestMethod.GET)
    public Boolean sendEmail(
            @RequestParam(value = "to", required = true) String sendTo,
            @RequestParam(value = "from", defaultValue = "admin@graalogosh.tk") String replyTo,
            @RequestParam(value="subject", defaultValue = "HelloWorld") String subject,
            @RequestParam(value = "text", required = true) String text
    ){
        MimeMessage mail= javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(sendTo);
            helper.setReplyTo(replyTo);
            helper.setFrom(replyTo);
            helper.setSubject(subject);
            helper.setText(text);
        }
        catch (MessagingException e){
            e.printStackTrace();
            return false;
        }
        javaMailSender.send(mail);
        return true;
    }
}
