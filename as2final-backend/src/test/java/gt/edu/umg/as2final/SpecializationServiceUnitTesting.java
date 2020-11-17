package gt.edu.umg.as2final;

import gt.edu.umg.as2final.As2p2Application;
import gt.edu.umg.as2final.model.SpecializationEntity;
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
public class SpecializationServiceUnitTesting {

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
    public void whenExecute_thenGetAllSpecializations () {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
  
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/specializations",
				HttpMethod.GET, entity, String.class);
        
        Assert.assertNotNull(response.getBody());
    }
    
    @Test
    public void whenGiveId_getSpecializationDetails() {
        SpecializationEntity specialization = restTemplate.getForObject(getRootUrl() + "/api/v1/specializations/1", SpecializationEntity.class);
        System.out.println(specialization.getSpecializationName());
        Assert.assertNotNull(specialization);
    }

    @Test
    public void whenCreateSpecialization_thenReturnNewSpecialization() {
        SpecializationEntity specialization = new SpecializationEntity();
        specialization.setSpecializationName("Cirujía cardiovascular");
        specialization.setDescription("Sistema Circulatorio");
        
        ResponseEntity<SpecializationEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/specializations", specialization, SpecializationEntity.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }
   
    @Test
    public void whenUpdateSpecialization_thenReturnUpdatedSpecialization() {
        int id = 1;
	SpecializationEntity specialization = restTemplate.getForObject(getRootUrl() + "/api/v1/specializations/2" + id, SpecializationEntity.class);
	specialization.setSpecializationName("Cirujía Cardiovascular");
	specialization.setDescription("Sistema Circulatorio");

	restTemplate.put(getRootUrl() + "/api/v1/specializations/2" + id, specialization);

	SpecializationEntity updatedSpecialization = restTemplate.getForObject(getRootUrl() + "/api/v1/specializations/2" + id, SpecializationEntity.class);
	Assert.assertNotNull(updatedSpecialization);
    }

    @Test
    public void whenDeleteSpecialization_thenReturnTrue() {
        int id = 2;
	SpecializationEntity specialization = restTemplate.getForObject(getRootUrl() + "/api/v1/specializations/2" + id, SpecializationEntity.class);
	Assert.assertNotNull(specialization);

	restTemplate.delete(getRootUrl() + "/api/v1/specializations/" + id);

	try {
            specialization = restTemplate.getForObject(getRootUrl() + "/api/v1/specializations/2" + id, SpecializationEntity.class);
	} catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	}
    }
}
