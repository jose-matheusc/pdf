package com.async.pdf.controller.jwt;

import com.async.pdf.dtos.TokenPresenterDto;
import com.async.pdf.service.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class JwtController {

    private final JwtService jwtService;

    public JwtController(JwtService jwtService){
        this.jwtService = jwtService;
    }

    @PostMapping("/jwt/created")
    public ResponseEntity<String> createdTokenJwt(@RequestBody TokenPresenterDto tokenPresenterDto){
        return ResponseEntity.ok(jwtService.generateToken(tokenPresenterDto));
    }
}
