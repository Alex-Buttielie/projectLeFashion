package br.com.lefashion.clothingstore.store.services;

import br.com.lefashion.clothingstore.store.domains.User;
import org.springframework.stereotype.Service;


@Service
public interface EmailService {

    String sendNewPasswordEmail(User User, String newPass);

}
