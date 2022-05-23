package br.com.lefashion.clothingstore.store.services.impl;

import br.com.lefashion.clothingstore.store.domains.User;
import br.com.lefashion.clothingstore.store.repository.UserRepository;
import br.com.lefashion.clothingstore.store.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository usuarioRepository;

    /*
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        //Usuario usu = usuarioRepository.findByUsuEmail(login);
        UsuarioDTO usu = new UsuarioDTO(1, "admin.login", "admin@gmail.com", "admin", "admin", null );
        if (usu == null){
            throw new UsernameNotFoundException(login);
        }
        //return new UserSS(usu.getUsuIden(), usu.getUsuEmail(), usu.getUsuSenha(), usu.getGruposUsuario());

        return new UserSS(usu.getId(), usu.getEmail(), usu.getSenha(), null);
    }*/

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return Optional
				.ofNullable(repo.findByEmail(email))
				.map(user ->  new UserSS(user.getIdUser(), user.getEmail(), user.getPasswordUser()))
				.orElseThrow(()-> new UsernameNotFoundException(email));
	}

}
