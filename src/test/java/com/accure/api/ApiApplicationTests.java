package com.accure.api;

import com.accure.api.controllers.*;
import com.accure.api.controllers.OrganizationRController;
import com.accure.api.controllers.TimeLogRController;
import com.accure.api.controllers.UserRController;
import com.accure.api.security.services.UserDetailsImpl;
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
	private OrganizationRController organizationRControllerTest;
	@Autowired
	private TimeLogRController timeLogRControllerTest;
	@Autowired
	private UserRController userRControllerTest;
	@Autowired
	private TimeLogService timeLogService;


	@Test
	void contextLoads() {
		assertThat(authControllerTest).isNotNull();
		assertThat(testControllerTest).isNotNull();
		assertThat(organizationRControllerTest).isNotNull();
		assertThat(timeLogRControllerTest).isNotNull();
		assertThat(userRControllerTest).isNotNull();

		assertThat(timeLogService).isNotNull();
	}

}
