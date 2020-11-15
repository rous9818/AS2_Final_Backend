package gt.edu.umg.as2final;

import gt.edu.umg.as2final.As2p2Application;
import gt.edu.umg.as2final.model.PatientEntity;
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
 * PatientServiceUnitTesting
 * Clase para probar las llamadas al API de Pacientes y ejecutar los casos de prueba
 * @author AK272DT
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = As2p2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class PatientServiceUnitTesting {
    
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
    public void whenExecute_thenGetAllPatients() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/patients",
				HttpMethod.GET, entity, String.class);
        
        Assert.assertNotNull(response.getBody());
    }
    
    @Test
    public void whenGiveId_getPatientDetails() {
        PatientEntity patient = restTemplate.getForObject(getRootUrl() + "/api/v1/patients/1", PatientEntity.class);
        System.out.println(patient.getFirstName());
        Assert.assertNotNull(patient);
    }
    
    @Test
    public void whenCreatePatient_thenReturnNewPatient() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Juan");
        patient.setMiddleName("Carlos");
        patient.setLastName("Plata");
        patient.setMaidenName("");
        patient.setAddress1("Ciudad de Guatemala");
        patient.setAddress2("");
        patient.setPhone1("22334455");
        patient.setPhone2("22993333");
        patient.setGender('M');
        patient.setPatientState(true);
        
        ResponseEntity<PatientEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/patients", patient, PatientEntity.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }
    
    @Test
    public void whenUpdatePatient_thenReturnUpdatedPatient() {
        int id = 1;
	PatientEntity patient = restTemplate.getForObject(getRootUrl() + "/api/v1/patients/" + id, PatientEntity.class);
	patient.setFirstName("Ovando");
	patient.setLastName("Mejía");

	restTemplate.put(getRootUrl() + "/api/v1/patients/" + id, patient);

	PatientEntity updatedPatient = restTemplate.getForObject(getRootUrl() + "/api/v1/patients/" + id, PatientEntity.class);
	Assert.assertNotNull(updatedPatient);
    }
    
    @Test
    public void whenDeletePatient_thenReturnTrue() {
        int id = 2;
	PatientEntity patient = restTemplate.getForObject(getRootUrl() + "/api/v1/patients/" + id, PatientEntity.class);
	Assert.assertNotNull(patient);

	restTemplate.delete(getRootUrl() + "/api/v1/patients/" + id);

	try {
            patient = restTemplate.getForObject(getRootUrl() + "/api/v1/patients/" + id, PatientEntity.class);
	} catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	}
    }
}
