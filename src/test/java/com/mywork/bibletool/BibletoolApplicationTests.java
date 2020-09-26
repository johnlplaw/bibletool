package com.mywork.bibletool;

import com.mywork.bibletool.controller.WebController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BibletoolApplicationTests {

	@Autowired
	private WebController webController;

	@Test
	void contextLoads() {
		assertThat(webController).isNotNull();
	}

}
