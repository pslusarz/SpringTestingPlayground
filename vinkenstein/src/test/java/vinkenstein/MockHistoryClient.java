package vinkenstein;

import domain.HistoryClient;
import domain.Listing;

public class MockHistoryClient extends HistoryClient {
    public MockHistoryClient(String remoteServerHostname) {
        super(remoteServerHostname);
    }

    @Override
    public Listing getHistory(String vin) {
        Listing listing = new Listing();
        return listing;
    }
}
