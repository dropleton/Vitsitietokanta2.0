package vitsi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vitsi.domain.Kayttaja;
import vitsi.repository.KayttajaRepository;

@Service
public class LoggedInAccountService {
    
    @Autowired
    private KayttajaRepository kayttajaRepository;
    
    public Kayttaja getAuthenticatedAccount() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || !auth.isAuthenticated()) {
            return null;
        }
        return kayttajaRepository.findByUsername(auth.getName());
    }
    
}
