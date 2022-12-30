package npc.martin.little.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author bikathi_martin
 */

@Service
public class ConvenienceService {
    public String generateUniqueId() {
        return UUID.randomUUID().toString()
            .replace("-", "")
            .substring(0, 10);
    }
}
