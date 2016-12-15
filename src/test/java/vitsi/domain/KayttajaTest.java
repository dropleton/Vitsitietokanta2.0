package vitsi.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class KayttajaTest {

    Kayttaja kayttaja;
    String username = "jenni";
    String password = "porkkana";
    List<Vitsi> vitsit = new ArrayList();
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public KayttajaTest() {
    }

    @Before
    public void setUp() {
        this.kayttaja = new Kayttaja();
        this.kayttaja.setUsername(username);
        this.kayttaja.setPassword(password);
        Vitsi vitsi1 = new Vitsi();
        this.vitsit.add(vitsi1);
        this.kayttaja.setVitsit(vitsit);
    }

    @Test
    public void getteritToimivat() {
        assertEquals(this.kayttaja.getUsername(), username);
        assertEquals(this.kayttaja.getPassword(), password);
        assertEquals(this.kayttaja.getVitsit(), vitsit);
    }

    @Test
    public void setteritToimivat() {
        this.kayttaja.setUsername("tapio");
        this.kayttaja.setPassword("peruna");
        ArrayList vitsit2 = new ArrayList();
        this.kayttaja.setVitsit(vitsit2);
        
        assertEquals(this.kayttaja.getUsername(), "tapio");
        assertEquals(this.kayttaja.getPassword(), "peruna");
        assertEquals(vitsit2, this.kayttaja.getVitsit());
    }
    
    @Test
    public void passwordEncodingWorks() {
        this.kayttaja.setPassword(passwordEncoder.encode("porkkana"));
        assertNotEquals(this.kayttaja.getPassword(), "porkkana");
    }
    
    
}
