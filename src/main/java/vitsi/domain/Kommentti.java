package vitsi.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kommentti extends AbstractPersistable<Long> {
    
    private String sisalto;
    @ManyToOne
    private Kayttaja kayttaja;
    @ManyToOne
    private Vitsi vitsi;

    public String getSisalto() {
        return sisalto;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public Vitsi getVitsi() {
        return vitsi;
    }

    public void setSisalto(String sisalto) {
        this.sisalto = sisalto;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    public void setVitsi(Vitsi vitsi) {
        this.vitsi = vitsi;
    }
}
