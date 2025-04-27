package com.falynsky.infrastructure;


import com.falynsky.adapter.SpringTransactionalUnitOfWork;
import com.falynsky.domain.UnitOfWork;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTransactionalConfig {

    @Bean
    public UnitOfWork unitOfWork() {
        return new SpringTransactionalUnitOfWork();
    }

}
