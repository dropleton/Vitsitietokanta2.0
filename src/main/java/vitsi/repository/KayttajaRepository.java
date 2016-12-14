package vitsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitsi.domain.Kayttaja;

public interface KayttajaRepository extends JpaRepository<Kayttaja, Long> {

    public Kayttaja findByUsername(String username);
}
