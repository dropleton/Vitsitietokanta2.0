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
import vitsi.repository.TagiRepository;
import vitsi.repository.VitsiRepository;
import vitsi.service.LoggedInAccountService;
import vitsi.service.TagiService;

@Controller
public class VitsiController {

    @Autowired
    private VitsiRepository vitsiRepository;
    
    @Autowired
    private TagiRepository tagiRepository;
    
    @Autowired
    private TagiService tagiService;

    @Autowired
    private LoggedInAccountService kayttajaService;

    @RequestMapping(value = "/jokes", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("jokes", vitsiRepository.findAll());
        model.addAttribute("allTags", tagiRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/jokes/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable Long id) {
        Vitsi vitsi = vitsiRepository.findOne(id);
        if (vitsi != null) {
            model.addAttribute("joke", vitsiRepository.findOne(id));
            return "joke";
        } else {
            return "redirect:/jokes";
        }
    }

    @RequestMapping(value = "/jokes", method = RequestMethod.POST)
    public String add(
            @RequestParam String otsikko,
            @RequestParam String sisalto,
            @RequestParam String tags) {
        Kayttaja kayttaja = kayttajaService.getAuthenticatedAccount();
        if (kayttaja == null) {
            return "redirect:/error";
        }

        Vitsi vitsi = new Vitsi();
        vitsi.setOtsikko(otsikko);
        vitsi.setSisalto(sisalto);
        vitsi.setKayttaja(kayttaja);
        tagiService.addTagsToJoke(tags, vitsi);
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
