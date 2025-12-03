package com.logcontrol.control;

import com.logcontrol.control.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogControlApplicationTests {

    Produto produto = new Produto("Arroz", 12.0, 100, "SADASD123");
	@Test
	void contextLoads() {
        Assertions.assertEquals("Arroz", produto.getNome());
	}

}
