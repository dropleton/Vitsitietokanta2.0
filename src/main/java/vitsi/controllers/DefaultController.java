package vitsi.controllers;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vitsi.domain.Kayttaja;
import vitsi.repository.KayttajaRepository;

@Controller
public class DefaultController {

    @Autowired
    private KayttajaRepository kayttajaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (kayttajaRepository.findByUsername("jenni") != null) {
            return;
        }

        Kayttaja user = new Kayttaja();
        user.setUsername("jenni");
        user.setPassword(passwordEncoder.encode("porkkana"));
        kayttajaRepository.save(user);
        
        if (kayttajaRepository.findByUsername("vierailija") != null) {
            return;
        }
        
        Kayttaja vierailija = new Kayttaja();
        vierailija.setUsername("vierailija");
        vierailija.setPassword(passwordEncoder.encode("salasana"));
        kayttajaRepository.save(vierailija);
    }

    @RequestMapping("*")
    public String handleDefault() {
        return "index";
    }
}
