package vitsi.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kayttaja extends AbstractPersistable<Long> {

    private String username;
    private String password;
    @OneToMany
    private List<Vitsi> vitsit;
    @OneToMany
    private List<Kommentti> kommentit;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Vitsi> getVitsit() {
        if(this.vitsit == null) {
            this.vitsit = new ArrayList<>();
        }
        return vitsit;
    }

    public List<Kommentti> getKommentit() {
        return kommentit;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVitsit(List<Vitsi> vitsit) {
        this.vitsit = vitsit;
    }

    public void setKommentit(List<Kommentti> kommentit) {
        this.kommentit = kommentit;
    }

}
