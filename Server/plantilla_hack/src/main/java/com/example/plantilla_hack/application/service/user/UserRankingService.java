package com.example.plantilla_hack.application.service.user;

import com.example.plantilla_hack.application.port.in.user.GetAllRankingUseCase;
import com.example.plantilla_hack.application.port.in.user.GetRankingFamilias;
import com.example.plantilla_hack.application.port.in.user.GetRankingSpecificPoblacioUseCase;
import com.example.plantilla_hack.application.port.in.user.NewUserUseCase;
import com.example.plantilla_hack.application.port.out.persistance.UserRepository;
import com.example.plantilla_hack.model.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UserRankingService implements  GetRankingSpecificPoblacioUseCase, GetAllRankingUseCase, NewUserUseCase {

    private final UserRepository userRepository;

    public UserRankingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }



    @Override
    public List<User> getRankingSpecificPoblacio(String poblacio) {
        return userRepository.getRankingSpecificPoblacio(poblacio);
    }

    @Override
    public List<User> getAllRanking() {
        return userRepository.getAllRanking();
    }
}
