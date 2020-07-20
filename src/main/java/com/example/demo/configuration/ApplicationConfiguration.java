package com.example.demo.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.demo.controller","com.example.demo.service", "com.example.demo.dao"})
public class ApplicationConfiguration {

}
