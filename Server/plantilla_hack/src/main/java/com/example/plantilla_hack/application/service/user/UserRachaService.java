package com.example.plantilla_hack.application.service.user;

import com.example.plantilla_hack.application.port.in.user.AumentarRachaUseCase;
import com.example.plantilla_hack.application.port.in.user.GetRachaUseCase;
import com.example.plantilla_hack.application.port.in.user.ReiniciarRachaUseCase;
import com.example.plantilla_hack.application.port.out.persistance.UserRepository;

public class UserRachaService implements AumentarRachaUseCase, ReiniciarRachaUseCase, GetRachaUseCase {

private final UserRepository userRepository;

    public UserRachaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void aumentarRacha(String email) {
        userRepository.aumentarRacha(email);
    }

    @Override
    public void reiniciarRacha(String email) {
        userRepository.reiniciarRacha(email);
    }

    @Override
    public int getRacha(String email) {
        return userRepository.getRacha(email);
    }
}
