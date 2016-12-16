package vitsi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vitsi.domain.Kayttaja;
import vitsi.domain.Kommentti;
import vitsi.domain.Vitsi;
import vitsi.repository.KommenttiRepository;
import vitsi.repository.VitsiRepository;
import vitsi.service.LoggedInAccountService;

@Controller
public class KommenttiController {

    @Autowired
    private VitsiRepository vitsiRepository;

    @Autowired
    private KommenttiRepository kommenttiRepository;

    @Autowired
    private LoggedInAccountService kayttajaService;

    @RequestMapping(value = "/jokes/{id}", method = RequestMethod.POST)
    public String addComment(
            @PathVariable long id,
            @RequestParam String sisalto) {

        Kayttaja kayttaja = kayttajaService.getAuthenticatedAccount();
        if (kayttaja == null) {
            return "redirect:/error";
        }

        Vitsi vitsi = vitsiRepository.findOne(id);
        Kommentti kommentti = new Kommentti();
        kommentti.setSisalto(sisalto);
        kommentti.setKayttaja(kayttaja);
        kommentti.setVitsi(vitsi);
        kommenttiRepository.save(kommentti);

        vitsi.addKommentti(kommentti);
        vitsiRepository.save(vitsi);
        return "redirect:/jokes/{id}";
    }

}
