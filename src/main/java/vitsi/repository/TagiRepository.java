package vitsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitsi.domain.Tagi;

public interface TagiRepository extends JpaRepository<Tagi, Long> {
    
}
