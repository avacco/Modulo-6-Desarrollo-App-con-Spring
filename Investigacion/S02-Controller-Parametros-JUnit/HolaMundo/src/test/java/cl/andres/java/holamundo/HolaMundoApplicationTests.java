package cl.andres.java.holamundo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HolaMundoApplicationTests {
	
	//con Autowired instancia automaticamente la clase, sin necesidad de un = new AppController();
	@Autowired
	private AppController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
