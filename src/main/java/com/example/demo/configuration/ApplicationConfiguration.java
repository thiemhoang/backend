package com.example.demo.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.controller","com.example.service"})
public class ApplicationConfiguration {

}
