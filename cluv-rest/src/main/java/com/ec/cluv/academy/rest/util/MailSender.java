package com.ec.cluv.academy.rest.util;

import com.ec.cluv.academy.config.MailConfiguration;
import com.ec.cluv.academy.model.dto.publick.UsuarioDto;
import com.ec.cluv.academy.model.dto.utils.MailDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class MailSender {
    private static final String TEMPLATE_NAME = "registration";
    private static final String HEADER_IMAGE = "templates/images/header.png";
    private static final String FOOTER_IMAGE = "templates/images/footer.png";
    private static final String PNG_MIME = "image/png";

    @Value("spring.mail.host")
    private String host;
    @Value("spring.mail.port")
    private String port;
    @Value("spring.mail.password")
    private String password;
    @Value("spring.mail.username")
    private String username;
    @Value("spring.mail.contenido")
    private String contenido;
    private final Environment environment;
    private final JavaMailSender mailSender;
    private final TemplateEngine htmlTemplateEngine;
    private MailConfiguration config;

    public MailSender(Environment environment, JavaMailSender mailSender, TemplateEngine htmlTemplateEngine) {
        this.environment = environment;
        this.mailSender = mailSender;
        this.htmlTemplateEngine = htmlTemplateEngine;
    }

    public String sendEmail(MailDTO mail, UsuarioDto user) {
        EmailValidator emialVD = new EmailValidator();
        try {
            if (emialVD.validaremail(mail.getTo())) {
                JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

                mailSender.setHost(this.environment.getProperty("spring.mail.host"));
                mailSender.setPort(Integer.parseInt(Objects.requireNonNull(this.environment.getProperty("spring.mail.port"))));
                mailSender.setUsername(this.environment.getProperty("spring.mail.username"));
                mailSender.setPassword(this.environment.getProperty("spring.mail.password"));

                Properties javaMailProperties = new Properties();
                javaMailProperties.put("mail.smtp.starttls.enable", "true");
                javaMailProperties.put("mail.smtp.auth", "true");
                javaMailProperties.put("mail.transport.protocol", "smtp");
                javaMailProperties.put("mail.debug", "true");
                javaMailProperties.put("mail.smtp.from", mail.getFrom());

                mailSender.setJavaMailProperties(javaMailProperties);

                String confirmationUrl = "generated_confirmation_url";
                String mailFrom = environment.getProperty("spring.mail.properties.mail.smtp.from");
                String mailFromName = environment.getProperty("mail.from.name", "ACCESS EPN");

                final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
                final MimeMessageHelper email;
                email = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                String[] toEmails = mail.getTo().split(",");
                email.setTo(toEmails);
                email.setSubject(mail.getSubject());
                email.setFrom(new InternetAddress(mailFrom, mailFromName));

                final Context ctx = new Context(LocaleContextHolder.getLocale());
                ctx.setVariable("email", user.getEmailInstitucional());
                ctx.setVariable("name", user.getNombres());
                ctx.setVariable("header", HEADER_IMAGE);
                ctx.setVariable("footer", FOOTER_IMAGE);
                ctx.setVariable("content", mail.getContent());
                ctx.setVariable("url", confirmationUrl);

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                ctx.setVariable("hora", sdf.format(new Date()));
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                ctx.setVariable("fecha", sdf.format(new Date()));
                ctx.setVariable("usuario", user.getCedula());
                ctx.setVariable("postulante", user.getNombres());
                ctx.setVariable("clave", user.getClave());
                ctx.setVariable("estado", "ESTATUS");
                ctx.setVariable("contenido", contenido);

                final String htmlContent = this.htmlTemplateEngine.process(TEMPLATE_NAME, ctx);

                email.setText(htmlContent, true);

                ClassPathResource clr = new ClassPathResource(HEADER_IMAGE);
                ClassPathResource clr1 = new ClassPathResource(FOOTER_IMAGE);

                email.addInline("header", clr, PNG_MIME);
                email.addInline("footer", clr1, PNG_MIME);

                mailSender.send(mimeMessage);

                return "Correo enviado exiosamente";

            } else {
                return "Ingrese una dirección de correo válida.";

            }


        } catch (Exception e) {
            e.printStackTrace();
            return "Error general al enviar el correo";
        }
    }
}
