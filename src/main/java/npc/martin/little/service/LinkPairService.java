package npc.martin.little.service;

import java.util.Optional;
import npc.martin.little.model.LinkPair;
import npc.martin.little.repository.LinkPairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bikathi_martin
 */

@Service
public class LinkPairService {
    @Autowired
    private LinkPairRepository linkPairRepository;
    
    public void createShortenedUrl(LinkPair linkPair) {
        linkPairRepository.save(linkPair);
    }
    
    public Optional<LinkPair> getOriginalUrl(String linkId) {
        return linkPairRepository.getByLinkId(linkId);
    }
}
