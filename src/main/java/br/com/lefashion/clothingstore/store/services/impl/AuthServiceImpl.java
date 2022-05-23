package br.com.lefashion.clothingstore.store.services.impl;


import br.com.lefashion.clothingstore.store.domains.User;
import br.com.lefashion.clothingstore.store.repository.UserRepository;
import br.com.lefashion.clothingstore.store.services.AuthService;
import br.com.lefashion.clothingstore.store.services.EmailService;
import br.com.lefashion.clothingstore.store.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder pe;

    protected UserRepository getRepository () {
        return this.repository;
    }

    @Autowired
    private EmailService emailService;

    @Override
    public String sendNewPassword(String email) {
        return Optional
                .ofNullable(getRepository().findByEmail(email))
                .map(user -> createNewPassword(user))
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));


    }

    private String createNewPassword(User user) {
        String newPass = Util.newPassword();
        String newPasswordEncrypted = pe.encode(newPass);
        user.setPasswordUser(newPasswordEncrypted);
        user = getRepository().save(user);
        return emailService.sendNewPasswordEmail(user, newPass);
    }

}
