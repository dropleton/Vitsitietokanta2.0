package vitsi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vitsi.domain.Vitsi;
import vitsi.repository.VitsiRepository;

@Controller
public class VitsiController {
    
    @Autowired
    private VitsiRepository vitsiRepository;
    
    @RequestMapping(value = "/jokes", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("jokes", vitsiRepository.findAll());
        return "index";
    }
    
    @RequestMapping(value = "/jokes", method = RequestMethod.POST)
    public String add(
            @RequestParam String otsikko, 
            @RequestParam String sisalto) {
        Vitsi vitsi = new Vitsi();
        vitsi.setOtsikko(otsikko);
        vitsi.setSisalto(sisalto);
        vitsiRepository.save(vitsi);
        return "redirect:/jokes";
    }
}
