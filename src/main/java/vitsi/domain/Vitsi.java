package vitsi.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Vitsi extends AbstractPersistable<Long> {
    
    private String otsikko;
    private String sisalto;
    
    @ManyToOne
    private Kayttaja kayttaja;
    
    @ManyToMany
    private List<Tagi> tagit;
    
    public String getOtsikko() {
        return otsikko;
    }

    public String getSisalto() {
        return sisalto;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public List<Tagi> getTagit() {
        return tagit;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public void setSisalto(String sisalto) {
        this.sisalto = sisalto;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    public void setTagit(List<Tagi> tagit) {
        this.tagit = tagit;
    }
    
    
}
