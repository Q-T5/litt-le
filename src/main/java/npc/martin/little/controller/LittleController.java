package npc.martin.little.controller;

/*
 * Copyright 2022 bikathi_martin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import jakarta.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import npc.martin.little.model.LinkPair;
import npc.martin.little.payload.request.ShortenRequest;
import npc.martin.little.service.ConvenienceService;
import npc.martin.little.service.LinkPairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    
    @PostMapping(value = "/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody ShortenRequest shortenRequest) {
        LinkPair newPair = new LinkPair(
            shortenRequest.getOriginalUrl(), null, null);
        
        String linkId = convenienceService.generateUniqueId();
        
        String shortenedUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path(String.format("/r/%s", linkId))
            .toUriString();
        
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
    
    @RequestMapping(value = "/{linkId}")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public ResponseEntity<?> redirectHandler(
        @PathVariable String linkId, HttpServletResponse httpServletResponse) throws URISyntaxException {
        
        LinkPair linkPair = linkPairService.getOriginalUrl(linkId).orElseThrow(() -> {
           throw new RuntimeException(
                String.format("Pair with id: %s not found", linkId));
        });
        
        URI originalUrl = new URI(linkPair.getOriginalUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        
        httpHeaders.setLocation(originalUrl);
        return new ResponseEntity(httpHeaders, HttpStatus.SEE_OTHER);
    }
}
