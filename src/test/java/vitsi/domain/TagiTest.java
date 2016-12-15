package vitsi.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TagiTest {

    Tagi tagi;
    String nimi = "turkulainen";
    Vitsi vitsi;
    List<Vitsi> vitsit;

    public TagiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.tagi = new Tagi();
        this.vitsi = new Vitsi();
        this.vitsit = new ArrayList();
        this.vitsit.add(vitsi);
        this.tagi.setNimi(nimi);
        this.tagi.setVitsit(vitsit);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getteritToimivat() {
        assertEquals(this.tagi.getNimi(), this.nimi);
        assertEquals(this.tagi.getVitsit(), this.vitsit);
    }
    
    @Test
    public void setteritToimivat() {
        this.tagi.setNimi("blondi");
        ArrayList<Vitsi> vitsit2 = new ArrayList();
        this.tagi.setVitsit(vitsit2);
        assertEquals(this.tagi.getNimi(), "blondi");
        assertEquals(this.tagi.getVitsit(), vitsit2);
    }
}
