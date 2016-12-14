package vitsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitsi.domain.Vitsi;

public interface VitsiRepository extends JpaRepository<Vitsi, Long> {
    
}
