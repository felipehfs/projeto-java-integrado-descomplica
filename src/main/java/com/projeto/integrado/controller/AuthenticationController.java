package com.projeto.integrado.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.integrado.dto.LoginResponse;
import com.projeto.integrado.dto.LoginUserDto;
import com.projeto.integrado.dto.RegisterUserDto;
import com.projeto.integrado.model.User;
import com.projeto.integrado.repository.UserRepository;
import com.projeto.integrado.service.AuthenticationService;
import com.projeto.integrado.service.JwtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    
    private  JwtService jwtService;
    private final AuthenticationService authenticationService;
    private UserRepository userRepository;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService,  UserRepository userRepository) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @Operation(summary = "Faz o registro na plataforma")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)),
        }),
         @ApiResponse(responseCode = "400", description = "Dados fornecidos estão inválidos", content = @Content),
    })
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {

        if (userRepository.findByEmail(registerUserDto.email()).isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        return ResponseEntity.ok(new LoginResponse(jwtToken));
    }
    
}
