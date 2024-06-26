package org.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // Step 1
public class AppConfig {
    // step 2: create methods
    // step 3: annotation @Bean
    @Bean("parrot-kesha")
    public Parrot getParrot() {
        return new Parrot();
    }

    @Bean("dog")
    @Scope("prototype")
    public Dog getDog() {
        return new Dog();
    }

    @Bean
    public Cat getCat(Parrot parrot) {
        Cat cat = new Cat();
        cat.setName(parrot.getName() + " - killer");
        return new Cat();
    }
}
