package npc.martin.little.controller;

import npc.martin.little.model.LinkPair;
import npc.martin.little.payload.request.ShortenRequest;
import npc.martin.little.service.ConvenienceService;
import npc.martin.little.service.LinkPairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author bikathi_martin
 */

@RestController
@RequestMapping(value = "/r")
public class LittleController {
    @Autowired
    private LinkPairService linkPairService;
    
    @Autowired
    private ConvenienceService convenienceService;
    
    private final Logger logger = LoggerFactory.getLogger(LinkPairService.class);
    
    @GetMapping(value = "/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody ShortenRequest shortenRequest) {
        LinkPair newPair = new LinkPair(
            shortenRequest.getOriginalUrl(), null, null);
        
        String linkId = convenienceService.generateUniqueId();
        
        String shortenedUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path(String.format("/r/%s", linkId))
            .toString();
        
        newPair.setShortUrl(shortenedUrl);
        newPair.setLinkId(linkId);
        
        try {
            linkPairService.createShortenedUrl(newPair);
            return new ResponseEntity(shortenedUrl, HttpStatus.OK);
        } catch(Exception ex) {
            logger.error("Encountered error while shortening URL");
            return new ResponseEntity(
                "Encountered error while shortening URL", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value = "/{linkId}")
    public ResponseEntity<?> reverseShortening(@PathVariable String linkId) {
        try {
            linkPairService.getOriginalUrl(linkId);
        } catch(Exception ex) {
            logger.error("Encountered error while reversing shortened URL");
            return new ResponseEntity(
                "Encountered error while reversing shortened URL", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
