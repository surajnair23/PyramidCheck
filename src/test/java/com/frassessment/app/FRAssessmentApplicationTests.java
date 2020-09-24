package com.frassessment.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.frassessment.app.services.PyramidServiceImpl;

@SpringBootTest
class FRAssessmentApplicationTests {
	

	@Autowired
	PyramidServiceImpl pyramidService;
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(pyramidService).isNotNull();
	}
	
	@Test
	public void checkBlankWord() throws Exception{
		assertThat(pyramidService.isPyramid("")).isNotNull();
	}
	
	@Test
	public void checkStringArray() throws Exception{
		assertThat("this is a test case".trim().length()>1);
	}
	
	@Test
	public void inValidString() throws Exception{
		assertThat("test %67".matches("^[a-zA-Z]*$"));
	}

}
