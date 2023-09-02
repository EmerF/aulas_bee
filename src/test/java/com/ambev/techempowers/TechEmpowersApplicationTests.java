package com.ambev.techempowers;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TechEmpowersApplicationTests {
	Login l = new Login();
	CadastroProduto cp = new CadastroProduto();
	String ret ;

	@Test
	void contextLoads() {
		System.out.println("Hoje o baguio ta loko");
	}

	@Test
	void testLoginSucesso(){
		ret = l.login("Sucesso");
		Assertions.assertEquals("ok", ret);
	}
	@Test
	void testLoginFalha(){
		ret = l.login("Erro");
		Assertions.assertNotEquals("Erro", ret);
	}

	@Test
	void testCadastroProduto(){

		String ret = cp.cadastrar("cafe");
		Assertions.assertEquals("cadastrado", ret);
	}
	@Test
	void testErroCadastroProduto(){
		String ret = cp.cadastrar("erro");
		Assertions.assertNotEquals("cadastrado", ret);
	}
}
