package vitsi.controllers;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vitsi.domain.Kayttaja;
import vitsi.repository.KayttajaRepository;

@Controller
public class DefaultController {

    //Salasanan encryptaus poistettu käytöstä herokun virheen takia.
    //Paikallisesti toimi vain encryptauksen kanssa. Tutkin asiaa
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
        user.setPassword("porkkana");
        kayttajaRepository.save(user);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping("*")
    public String handleDefault() {
        return "index";
    }
}
