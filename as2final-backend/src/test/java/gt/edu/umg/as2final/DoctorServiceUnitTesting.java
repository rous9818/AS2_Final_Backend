package gt.edu.umg.as2final;


import gt.edu.umg.as2final.As2p2Application;
import gt.edu.umg.as2final.model.DoctorEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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
public class DoctorServiceUnitTesting {
    
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
    public void whenExecute_thenGetAllDoctors() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/doctors",
				HttpMethod.GET, entity, String.class);
        
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void whenGiveId_getDoctorDetails() {
        DoctorEntity doctor = restTemplate.getForObject(getRootUrl() + "/api/v1/doctors/1", DoctorEntity.class);
        System.out.println(doctor.getFirstName());
        Assert.assertNotNull(doctor);
    }

    @Test
    public void whenCreateDoctor_thenReturnNewDoctor() {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Juan");
        doctor.setMiddleName("Carlos");
        doctor.setLastName("Plata");
        doctor.setMaidenName("");
        doctor.setAddress1("Ciudad de Guatemala");
        doctor.setAddress2("");
        doctor.setGender('M');
        doctor.setCollegiateNumber("2358283282");
        doctor.setIsActive(true);
        
        ResponseEntity<DoctorEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/doctors", doctor, DoctorEntity.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

   @Test
    public void whenUpdateDoctor_thenReturnUpdatedDoctor() {
        int id = 1;
	DoctorEntity doctor = restTemplate.getForObject(getRootUrl() + "/api/v1/doctors/4" + id, DoctorEntity.class);
	doctor.setFirstName("Ovando");
	doctor.setLastName("Mejía");

	restTemplate.put(getRootUrl() + "/api/v1/doctors/4" + id, doctor);

	DoctorEntity updatedDoctor = restTemplate.getForObject(getRootUrl() + "/api/v1/doctors/4" + id, DoctorEntity.class);
	Assert.assertNotNull(updatedDoctor);
    }

    @Test
    public void whenDeleteDoctor_thenReturnTrue() {
        int id = 4;
	DoctorEntity doctor = restTemplate.getForObject(getRootUrl() + "/api/v1/doctors/4" + id, DoctorEntity.class);
	Assert.assertNotNull(doctor);

	restTemplate.delete(getRootUrl() + "/api/v1/doctors/4" + id);

	try {
            doctor= restTemplate.getForObject(getRootUrl() + "/api/v1/doctors/4" + id, DoctorEntity.class);
	} catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	}
    }
 }

    