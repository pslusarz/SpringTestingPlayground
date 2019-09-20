package clients;

import domain.HistoryClient;
import domain.Listing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import vinkenstein.AppConfig;
import vinkenstein.TestAppConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
public class HistoryClientFocusedIntegrationTest {
    @Autowired HistoryClient historyClient;

    @Test
    public void getASingleVin() {
        Listing listing = historyClient.getHistory("WBSBG9321VEY74382");
        assertNotNull(listing);
        assertEquals("WBSBG9321VEY74382", listing.getVin());
        assertEquals(2, listing.getNumberOfOwners());
        assertEquals(12, listing.getNumberOfAccidents());
    }
}
