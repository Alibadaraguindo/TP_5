package org.example.tp5;

import org.example.tp5.entities.Product;
import org.example.tp5.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class Tp5Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp5Application.class, args);
    }
    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(6000)
                    .quantity(24)
                    .build()
            );
            productRepository.save(Product.builder()
                    .name("Phone")
                    .price(20000)
                    .quantity(6)
                    .build()
            );
            productRepository.save(Product.builder()
                    .name("Keyboard")
                    .price(120)
                    .quantity(40)
                    .build()
            );
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });

        };
    }
}
