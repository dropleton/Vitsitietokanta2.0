package vitsi.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Vitsi extends AbstractPersistable<Long> {
    private String otsikko;
    private String sisalto;
    @ManyToOne
    private Kayttaja kayttaja;
    
    public String getOtsikko() {
        return otsikko;
    }

    public String getSisalto() {
        return sisalto;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
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
    
    
}
