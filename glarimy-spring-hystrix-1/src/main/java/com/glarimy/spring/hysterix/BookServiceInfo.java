package com.glarimy.spring.hysterix;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class BookServiceInfo implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("details", Collections.singletonMap("description", "Book Service"));
	}

}