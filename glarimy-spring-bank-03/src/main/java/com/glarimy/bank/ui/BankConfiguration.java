package com.glarimy.bank.ui;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.glarimy.bank")
@ImportResource("applicationContext.xml")
public class BankConfiguration {

}
