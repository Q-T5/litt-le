package npc.martin.little.model;

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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author bikathi_martin
 */

@Entity
@Table(name = "link_pair")
public class LinkPair implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "original_url")
    private String originalUrl;
    
    @Column(name = "short_url")
    private String shortUrl;
    
    @Column(name = "link_id")
    private String linkId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public LinkPair(Long id, String originalUrl, String shortUrl, String linkId) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.linkId = linkId;
    }

    public LinkPair(String originalUrl, String shortUrl, String linkId) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.linkId = linkId;
    }
    
    public LinkPair() {}

    @Override
    public String toString() {
        return "LinkPair{" + "id=" + id + ", originalUrl=" + originalUrl 
            + ", shortUrl=" + shortUrl + ", linkId=" + linkId + '}';
    }
}
