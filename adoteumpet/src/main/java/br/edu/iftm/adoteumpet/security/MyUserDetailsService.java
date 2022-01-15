package br.edu.iftm.adoteumpet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.iftm.adoteumpet.model.Usuario;
import br.edu.iftm.adoteumpet.repository.UsuarioRepository;


public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UsuarioRepository usuarioRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.buscaPorEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new MyUserDetails(usuario);
    }
}
