package com.keroles.Pharmacy;

import com.keroles.Pharmacy.Constant.ConstantSystemConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PharmacyApplication extends SpringBootServletInitializer {

    public static final ConstantSystemConfig.system_mode app_mode= ConstantSystemConfig.system_mode.dev;
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PharmacyApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(PharmacyApplication.class, args);
    }

}
