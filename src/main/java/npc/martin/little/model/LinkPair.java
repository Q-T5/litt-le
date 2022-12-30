package npc.martin.little.model;

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
