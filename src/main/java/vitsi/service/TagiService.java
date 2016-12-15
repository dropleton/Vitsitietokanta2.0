package vitsi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitsi.domain.Tagi;
import vitsi.domain.Vitsi;
import vitsi.repository.TagiRepository;

@Service
public class TagiService {
    
    @Autowired
    private TagiRepository tagiRepository;
    
    public void addTagsToJoke(String tags, Vitsi vitsi) {
        ArrayList<Long> ids = castStringToIds(tags);
        List<Tagi> foundTags = findTags(ids);
        vitsi.setTagit(foundTags);
    }
    
    private ArrayList<Tagi> findTags(ArrayList<Long> ids) {
        ArrayList<Tagi> foundTags = new ArrayList();
        for(Long id : ids) {
            foundTags.add(tagiRepository.findOne(id));
        }
        return foundTags;
    }
    
    private ArrayList<Long> castStringToIds(String tags) {
        String[] split = tags.split(",");
        ArrayList<Long> ids = new ArrayList();
        for(String i : split) {
            ids.add(Long.valueOf(i));
        }
        return ids;
    }
    
}
