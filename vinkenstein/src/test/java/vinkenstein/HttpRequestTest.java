package vinkenstein;

import domain.Assessment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=TestAppConfig.class)
@ActiveProfiles("test")
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //, properties = "spring.main.allow-bean-definition-overriding=true")
public class HttpRequestTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void assessingHonda() {
        Assessment assessment = restTemplate.getForObject("/assessment?vin=WBSBG9321VEY74382", Assessment.class);
        System.out.println(assessment);
        assertEquals(assessment.getAssessedVehicle().getVin(), "WBSBG9321VEY74382");
        assertEquals(assessment.getSuggestedPrice(), 24000);
        assertTrue(assessment.getComparables().size()> 0);
        assertTrue(assessment.getComparables().get(0).getListing().getVin() != null);
    }

}