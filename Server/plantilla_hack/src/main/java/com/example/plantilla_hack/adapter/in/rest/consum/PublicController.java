package com.example.plantilla_hack.adapter.in.rest.consum;

import com.example.plantilla_hack.adapter.in.rest.security.dto.LoginResponse;
import com.example.plantilla_hack.adapter.in.rest.security.dto.LoginUserDTO;
import com.example.plantilla_hack.adapter.out.persistance.user.JPAUserRepository;
import com.example.plantilla_hack.application.port.in.user.*;
import com.example.plantilla_hack.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Controller de prueba para comprobar conectividad

@RestController
public class PublicController {
    private final GetRankingSpecificPoblacioUseCase getRankingSpecificPoblacioUseCase;
    private final GetAllRankingUseCase getAllRanking;
    private final JPAUserRepository userJpaRepository;
    private final GetRachaUseCase getRachaUseCase;
    private final AumentarRachaUseCase aumentarRachaUseCase;
    private final ReiniciarRachaUseCase reiniciarRachaUseCase;
    private final NewUserUseCase newUserUseCase;


    public PublicController(GetRankingSpecificPoblacioUseCase getRankingSpecificPoblacioUseCase, GetAllRankingUseCase getAllRanking,
                            JPAUserRepository userJpaRepository, GetRachaUseCase getRachaUseCase,
                            AumentarRachaUseCase aumentarRachaUseCase, ReiniciarRachaUseCase reiniciarRachaUseCase
                            , NewUserUseCase newUserUseCase) {
        this.getRankingSpecificPoblacioUseCase = getRankingSpecificPoblacioUseCase;
        this.getAllRanking = getAllRanking;
        this.userJpaRepository = userJpaRepository;
        this.getRachaUseCase = getRachaUseCase;
        this.aumentarRachaUseCase = aumentarRachaUseCase;
        this.reiniciarRachaUseCase = reiniciarRachaUseCase;
        this.newUserUseCase = newUserUseCase;
    }



    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }
    @GetMapping("/u/r/all")
    public List<User> getAllRankingPath1() {
        return getAllRanking.getAllRanking();
    }

    @PostMapping("/u/new")
    public void newUser(@RequestBody User user) {
         newUserUseCase.save(user);
    }

    @GetMapping("/user/ranking/poblacio")
    public List<User> getRankingSpecificPoblacio(@RequestParam String poblacio) {
        return getRankingSpecificPoblacioUseCase.getRankingSpecificPoblacio(poblacio);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto) {

        Optional<User> userOptional = userJpaRepository.findByEmail(loginUserDto.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(loginUserDto.getPassword())) {
                LoginResponse loginResponse = new LoginResponse("Login successful");
                return ResponseEntity.ok(loginResponse);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginResponse("Invalid email or password"));
    }


    @GetMapping("/get")
    public ResponseEntity<Integer> getRacha(@RequestParam String email) {
        int racha = getRachaUseCase.getRacha(email);
        return ResponseEntity.ok(racha);
    }

    @PostMapping("/increase")
    public ResponseEntity<Void> increaseRacha(@RequestParam String email) {
        aumentarRachaUseCase.aumentarRacha(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset")
    public ResponseEntity<Void> resetRacha(@RequestParam String email) {
        reiniciarRachaUseCase.reiniciarRacha(email);
        return ResponseEntity.ok().build();

    }
}