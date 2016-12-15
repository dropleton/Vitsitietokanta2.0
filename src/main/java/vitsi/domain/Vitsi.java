package vitsi.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Vitsi extends AbstractPersistable<Long> {
    
    private String otsikko;
    private String sisalto;
    
    @ManyToOne
    private Kayttaja kayttaja;
    
    @ManyToMany
    private List<Tagi> tagit;
    
    @OneToMany
    private List<Kommentti> kommentit;
    
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

    public List<Kommentti> getKommentit() {
        return kommentit;
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

    public void addKommentti(Kommentti kommentti) {
        this.kommentit = new ArrayList();
        this.kommentit.add(kommentti);
    }
    
    
}
