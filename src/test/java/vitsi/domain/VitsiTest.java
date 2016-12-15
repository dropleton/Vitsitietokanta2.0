package vitsi.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VitsiTest {

    String otsikko = "Kaksi naista";
    String sisalto = "Kaksi naista istui hiljaa.";
    Kayttaja kayttaja = new Kayttaja();
    Vitsi vitsi = new Vitsi();

    public VitsiTest() {
    }

    @Before
    public void setUp() {
        vitsi.setOtsikko(otsikko);
        vitsi.setSisalto(sisalto);
        vitsi.setKayttaja(kayttaja);
    }

    @Test
    public void getteritToimivat() {
        assertEquals(this.vitsi.getKayttaja(), this.kayttaja);
        assertEquals(this.vitsi.getOtsikko(), this.otsikko);
        assertEquals(this.vitsi.getSisalto(), this.sisalto);
    }
    
    @Test
    public void setteritToimivat() {
        Kayttaja kayttaja2 = new Kayttaja();
        String otsikko2 = "Uusi otsikko";
        String sisalto2 = "Uusi sisalto";
        vitsi.setKayttaja(kayttaja2);
        vitsi.setOtsikko(otsikko2);
        vitsi.setSisalto(sisalto2);
        assertEquals(this.vitsi.getKayttaja(), kayttaja2);
        assertEquals(this.vitsi.getOtsikko(), otsikko2);
        assertEquals(this.vitsi.getSisalto(), sisalto2);
    }
}
