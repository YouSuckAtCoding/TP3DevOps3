package infnet.edu.tp3devops3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import infnet.edu.tp3devops3.WebClient.WebClientOps;
import reactor.test.StepVerifier;

@SpringBootTest
class Tp3devops3ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void Should_Call_Weather_Api_Through_WebClient() throws InterruptedException
	{
		WebClientOps ops = new WebClientOps();
		WebClient client = ops.CreateWebClient();

		var result = ops.MakeWeatherRequest(client);
		StepVerifier.create(result)
		.consumeNextWith(x -> {
			System.out.println(x);
		})
		.verifyComplete();
		
	}

}
