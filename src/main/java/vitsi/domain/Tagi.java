package vitsi.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Tagi extends AbstractPersistable<Long> {
    
    private String nimi;
    
    @ManyToMany(mappedBy = "tagit")
    private List<Vitsi> vitsit;

    public String getNimi() {
        return nimi;
    }

    public List<Vitsi> getVitsit() {
        return vitsit;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setVitsit(List<Vitsi> vitsit) {
        this.vitsit = vitsit;
    }
}
