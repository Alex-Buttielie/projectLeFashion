package br.com.lefashion.clothingstore.store.services.impl;

import br.com.lefashion.clothingstore.store.security.UserSS;
import br.com.lefashion.clothingstore.store.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (Exception e) {
            return null;
        }
    }
}
