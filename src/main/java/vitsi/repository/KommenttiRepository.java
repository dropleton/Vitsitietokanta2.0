package vitsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitsi.domain.Kommentti;

public interface KommenttiRepository extends JpaRepository<Kommentti, Long> {
    
}
