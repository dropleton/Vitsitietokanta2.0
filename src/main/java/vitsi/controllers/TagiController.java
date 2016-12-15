package vitsi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vitsi.domain.Tagi;
import vitsi.repository.TagiRepository;

@Controller
public class TagiController {
    
    @Autowired
    private TagiRepository tagiRepository;
    
    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public String listTags(Model model) {
        model.addAttribute("tags", tagiRepository.findAll());
        return "tags";
    }
    
    @RequestMapping(value = "/tags", method = RequestMethod.POST)
    public String addTag(@RequestParam String nimi) {
        Tagi tagi = new Tagi();
        tagi.setNimi(nimi);
        tagiRepository.save(tagi);
        return "redirect:/tags";
    }
    
}
