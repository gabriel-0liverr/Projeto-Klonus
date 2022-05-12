package ifpi.ads.projintegrador1.klonus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpi.ads.projintegrador1.klonus.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}
