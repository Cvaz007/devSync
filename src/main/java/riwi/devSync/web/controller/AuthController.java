package riwi.devSync.web.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import riwi.devSync.domain.dto.AuthResponse;
import riwi.devSync.domain.dto.LoginRequest;
import riwi.devSync.domain.dto.RegisterRequest;
import riwi.devSync.domain.service.AuthService;


@RestController
@RequestMapping("/auth")
//Lombok is no recommend to use, because this cause that this application depend on this library, in hexagonal architecture is a bad practise
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
