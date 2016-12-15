package vitsi.controllers;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vitsi.domain.Kayttaja;
import vitsi.repository.KayttajaRepository;

@Controller
public class DefaultController {

//    kommentoitu, koska kirjautuminen ei toiminut tällä tavalla. Tutkitaan asiaa myöhemmin
    @Autowired
    private KayttajaRepository kayttajaRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (kayttajaRepository.findByUsername("jenni") != null) {
            return;
        }

        Kayttaja user = new Kayttaja();
        user.setUsername("jenni");
        user.setPassword(passwordEncoder.encode("porkkana"));
        kayttajaRepository.save(user);
    }

    @RequestMapping("*")
    public String handleDefault() {
        return "index";
    }
}
