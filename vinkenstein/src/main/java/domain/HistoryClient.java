package domain;

import org.springframework.web.client.RestTemplate;

public class HistoryClient {
    private final String hostname;

    public HistoryClient(String hostname) {
        this.hostname = hostname;
    }

    public Listing getHistory(String vin) {
        //Listing result = new Listing();
        //result.setVin(vin);
        RestTemplate restTemplate = new RestTemplate();
        Listing result = restTemplate.getForObject("http://"+hostname+":8093/history?vin="+vin, Listing.class);
        return result;
    }
}
