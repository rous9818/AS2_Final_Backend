package gt.edu.umg.as2final;

import gt.edu.umg.as2final.As2p2Application;
import gt.edu.umg.as2final.model.DiseaseEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;


/**
 *
 * @author rossa
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = As2p2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class DiseaseServiceUnitTesting {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + "8080";

    }

         
    @Test
    public void contextLoads() {
        
    }

    @Test 
    public void whenExecute_thenGetAllDisease () {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
  
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/diseases",
				HttpMethod.GET, entity, String.class);
        
        Assert.assertNotNull(response.getBody());
    }

    
    @Test
    public void whenGiveId_getDiseaseDetails() {
        DiseaseEntity disease = restTemplate.getForObject(getRootUrl() + "/api/v1/diseases/1", DiseaseEntity.class);
        System.out.println(disease.getDiseaseName());
        Assert.assertNotNull(disease);
    }
    
    @Test
    public void whenCreateDisease_thenReturnNewDisease() {
        DiseaseEntity disease = new DiseaseEntity();
        disease.setDiseaseName("obesidad");
        disease.setDescription("malos habitos alimenticios");
        
        ResponseEntity<DiseaseEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/diseases", disease, DiseaseEntity.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void whenUpdateDisease_thenReturnUpdatedDisease() {
        int id = 1;
	DiseaseEntity disease = restTemplate.getForObject(getRootUrl() + "/api/v1/diseases/6" + id, DiseaseEntity.class);
	disease.setDiseaseName("Obesidad");
	disease.setDescription("malas habitos alimenticios");

	restTemplate.put(getRootUrl() + "/api/v1/diseases/6" + id, disease);

	DiseaseEntity updatedDisease = restTemplate.getForObject(getRootUrl() + "/api/v1/diseases/6" + id, DiseaseEntity.class);
	Assert.assertNotNull(updatedDisease);
    }

      @Test
    public void whenDeleteDisease_thenReturnTrue() {
        int id = 2;
	DiseaseEntity disease = restTemplate.getForObject(getRootUrl() + "/api/v1/diseases/6" + id, DiseaseEntity.class);
	Assert.assertNotNull(disease);

	restTemplate.delete(getRootUrl() + "/api/v1/diseases/6" + id);

	try {
            disease = restTemplate.getForObject(getRootUrl() + "/api/v1/diseases/6" + id, DiseaseEntity.class);
	} catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	}
    }
}

