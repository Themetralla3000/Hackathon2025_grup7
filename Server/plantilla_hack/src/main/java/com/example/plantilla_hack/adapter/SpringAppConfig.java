package com.example.plantilla_hack.adapter;

import com.example.plantilla_hack.application.port.in.consum.*;
import com.example.plantilla_hack.application.port.in.user.*;
import com.example.plantilla_hack.application.port.out.persistance.ConsumRepository;
import com.example.plantilla_hack.application.port.out.persistance.UserRepository;
import com.example.plantilla_hack.application.service.consum.ConsumeDaysService;
import com.example.plantilla_hack.application.service.user.UserRachaService;
import com.example.plantilla_hack.application.service.user.UserRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAppConfig {

    @Autowired
    ConsumRepository consumRepository;

    @Autowired
    UserRepository userRepository;



    @Bean
    GetAllDaysUseCase getAllDaysUseCase() {
        return new ConsumeDaysService(consumRepository);
    }

    @Bean
    GetConsumSpecificDayUseCase getConsumSpecificDayUseCase() {
        return new ConsumeDaysService(consumRepository);
    }

    @Bean
    GetLastMonthUseCase getLastMonthUseCase() {
        return new ConsumeDaysService(consumRepository);
    }

    @Bean
    GetLastWeekUseCase getLastWeekUseCase() {
        return new ConsumeDaysService(consumRepository);
    }

    @Bean
    GetYesterdayUseCase getYesterdayUseCase() {
        return new ConsumeDaysService(consumRepository);
    }

    @Bean
    AumentarRachaUseCase aumentarRachaUseCase() {
        return new UserRachaService(userRepository);
    }

    @Bean
    GetRachaUseCase getRachaUseCase() {
        return new UserRachaService(userRepository);
    }

    @Bean
    ReiniciarRachaUseCase reiniciarRachaUseCase() {
        return new UserRachaService(userRepository);
    }



    @Bean
    GetRankingSpecificPoblacioUseCase getRankingSpecificPoblacioUseCase() {
        return new UserRankingService(userRepository);
    }

    @Bean
    GetAllRankingUseCase getAllRanking() {
        return new UserRankingService(userRepository);
    }
    @Bean
    NewUserUseCase newUserUseCase() {
        return new UserRankingService(userRepository);
    }

}
