package npc.martin.little.repository;

import java.util.Optional;
import npc.martin.little.model.LinkPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */

@Repository
public interface LinkPairRepository extends JpaRepository<LinkPair, Long> {
    Optional<LinkPair> getByLinkId(String shortenedUrl);
}
