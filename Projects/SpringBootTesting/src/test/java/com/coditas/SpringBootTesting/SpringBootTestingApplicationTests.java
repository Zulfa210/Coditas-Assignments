package com.coditas.SpringBootTesting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WebMvcTest
class SpringBootTestingApplicationTests {

	private Calculator calculator = new Calculator();
	@Test
	void contextLoads() {
	}

	@Test
	void testSum(){

		int expectedResult = 60;
		int actualResult = calculator.doSum(10,20,30);

		assertThat(actualResult).isEqualTo(expectedResult);
		assertEquals(actualResult,expectedResult);
	}


	@Test
	void testCompareNumbers(){
		boolean expectedResult  = true;
		boolean actualResult = calculator.isEqual(2,2);
		assertThat(actualResult).isTrue();
	}

}
