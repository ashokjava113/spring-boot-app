package com.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class DemoApplicationTests {

	private Calculator calculator=new Calculator();

	@Test
	void contextLoads() {
	}

	@Test
	void testSum(){
		//expected
		int expectedResult=19;

		//actual
		int actualResult = calculator.doSum(12,2,5);

		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@Disabled
	void testProduct(){
		//expected
		int expectedResult = 40;

		//actual
		int actualResult = calculator.doProduct(8,5);

		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void testCompareNums(){
		Boolean actualResult = calculator.compareTwoNums(3,3);

		assertThat(actualResult).isTrue();
	}
}
