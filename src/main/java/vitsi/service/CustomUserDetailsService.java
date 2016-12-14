package vitsi.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vitsi.domain.Kayttaja;
import vitsi.repository.KayttajaRepository;

//kommentoitu @Service, koska tämän lisääminen ei toiminut vielä, enkä halua tämän nyt sotkevan
//@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private KayttajaRepository kayttajaRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Kayttaja kayttaja = kayttajaRepository.findByUsername(username);
        if (kayttaja == null) {
            throw new UsernameNotFoundException("No such user: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                kayttaja.getUsername(),
                kayttaja.getPassword(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
    
}
