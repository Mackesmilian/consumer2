package com.wolf.consumer2;

import com.wolf.consumer2.entity.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureStubRunner(ids = {"at.wolf.dependencies:8080"}, stubsMode =
		StubRunnerProperties.StubsMode.LOCAL)
class Consumer2ApplicationTests {

	@Test
	public void getCustomerInfo() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Customer>> customerResponseEntity = restTemplate.exchange(
				"http://localhost:8080/customers/balance", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>(){});
		assertThat(customerResponseEntity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(customerResponseEntity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(customerResponseEntity.getBody()).isNotEmpty();
	}

}
