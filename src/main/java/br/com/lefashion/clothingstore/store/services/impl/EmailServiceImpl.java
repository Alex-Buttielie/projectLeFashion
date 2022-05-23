package br.com.lefashion.clothingstore.store.services.impl;

import br.com.lefashion.clothingstore.store.domains.User;
import br.com.lefashion.clothingstore.store.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(SimpleMailMessage msg){ return null;}

    @Override
    public String sendNewPasswordEmail(User user, String newPass) {
        return sendMail(user, newPass);
    }

    public String sendMail(User user, String newPass) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Solicitação de nova senha");
        //message.setText("Olá! Sua nova senha é: " + usuario.getSenha());
        message.setText("Olá! Sua nova senha é: " + newPass);
        message.setTo(user.getEmail());
        message.setFrom(user.getEmail());
        message.setSentDate(new Date(System.currentTimeMillis()));

        try {

            enviarEmail(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }

    public void enviarEmail(SimpleMailMessage message) {
        mailSender.send(message);
    }

}
