package br.com.lefashion.clothingstore.store.resources;

import br.com.lefashion.clothingstore.store.dtos.EmailDTO;
import br.com.lefashion.clothingstore.store.security.JWTUtil;
import br.com.lefashion.clothingstore.store.security.UserSS;
import br.com.lefashion.clothingstore.store.services.AuthService;
import br.com.lefashion.clothingstore.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return this.userService;
    }

    public AuthService getService () {
        return this.service;
    }

    public JWTUtil getJwtUtil() {
        return this.jwtUtil;
    }

    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = this.getUserService().authenticated();
        String token = this.getJwtUtil().generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ResponseEntity<String> forgot(@Valid @RequestBody EmailDTO dto) {
        return ResponseEntity.ok().body(this.getService().sendNewPassword(dto.getEmail()));
    }
}
