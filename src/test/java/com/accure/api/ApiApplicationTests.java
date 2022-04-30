package com.accure.api;

import com.accure.api.controllers.*;
import com.accure.api.controllers.OrganizationController;
import com.accure.api.controllers.TimeLogController;
import com.accure.api.controllers.UserController;
import com.accure.api.services.TimeLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	private AuthController authControllerTest;
	@Autowired
	private TestController testControllerTest;
	@Autowired
	private OrganizationController organizationControllerTest;
	@Autowired
	private TimeLogController timeLogControllerTest;
	@Autowired
	private UserController userControllerTest;
	@Autowired
	private TimeLogService timeLogService;


	@Test
	void contextLoads() {
		assertThat(authControllerTest).isNotNull();
		assertThat(testControllerTest).isNotNull();
		assertThat(organizationControllerTest).isNotNull();
		assertThat(timeLogControllerTest).isNotNull();
		assertThat(userControllerTest).isNotNull();

		assertThat(timeLogService).isNotNull();
	}

}
