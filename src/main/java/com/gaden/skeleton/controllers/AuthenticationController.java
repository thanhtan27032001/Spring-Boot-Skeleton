package com.gaden.skeleton.controllers;

import com.gaden.skeleton.security.models.AuthenticationRequest;
import com.gaden.skeleton.security.models.AuthenticationResponse;
import com.gaden.skeleton.utils.AuthenticationService;
import com.gaden.skeleton.security.models.RegisterRequest;
import com.gaden.skeleton.models.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ResponseObject> register(@RequestBody RegisterRequest request) {
        AuthenticationResponse response = authenticationService.register(request);
        if (response != null) {
            return ResponseEntity.ok(
                    ResponseObject
                            .builder()
                            .status("200 OK")
                            .message("OK")
                            .data(response)
                            .build()
            );
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ResponseObject
                        .builder()
                        .status("409 Conflict")
                        .message("Email already existed")
                        .data(null)
                        .build()
        );
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseObject> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            return ResponseEntity.ok(
                    ResponseObject
                            .builder()
                            .status("200 OK")
                            .message("OK")
                            .data(authenticationService.authenticate(request))
                            .build()
            );
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    ResponseObject
                            .builder()
                            .status("Unauthorized")
                            .message("Email or Password incorrect")
                            .data(null)
                            .build()
            );
        }
    }
}
