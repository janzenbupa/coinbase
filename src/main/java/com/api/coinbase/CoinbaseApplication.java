package com.api.coinbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = { "com.api.coinbase", "com.api.currency", "com.api.gson" })
public class CoinbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinbaseApplication.class, args);
    }

}
