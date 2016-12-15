package vitsi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vitsi.domain.Kayttaja;
import vitsi.domain.Vitsi;
import vitsi.repository.VitsiRepository;
import vitsi.service.LoggedInAccountService;

@Controller
public class VitsiController {

    @Autowired
    private VitsiRepository vitsiRepository;

    @Autowired
    private LoggedInAccountService kayttajaService;

    @RequestMapping(value = "/jokes", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("jokes", vitsiRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/jokes/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable Long id) {
        model.addAttribute("joke", vitsiRepository.findOne(id));
        return "joke";
    }

    @RequestMapping(value = "/jokes", method = RequestMethod.POST)
    public String add(
            @RequestParam String otsikko,
            @RequestParam String sisalto) {
        Kayttaja kayttaja = kayttajaService.getAuthenticatedAccount();
        if (kayttaja == null) {
            return "redirect:/error";
        }

        Vitsi vitsi = new Vitsi();
        vitsi.setOtsikko(otsikko);
        vitsi.setSisalto(sisalto);
        vitsi.setKayttaja(kayttaja);
        vitsiRepository.save(vitsi);
        return "redirect:/jokes";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }

    //tämä metodi ei ilmeisesti tee mitään. Olisin halunnut uudelleenohjauksen
    //osoitteeseen /login, mutta päätyy osoitteeseen 
    //login?logout
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/login";
    }
}
