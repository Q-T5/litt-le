package npc.martin.little.payload.request;

/**
 *
 * @author bikathi_martin
 */
public class ShortenRequest {
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public ShortenRequest(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    
    public ShortenRequest() {  }

    @Override
    public String toString() {
        return "ShortenRequest{" + "originalUrl=" + originalUrl + '}';
    }
}
