package com.gaden.skeleton.controllers;

import com.gaden.skeleton.models.ResponseObject;
import com.gaden.skeleton.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoController {

    private final JwtService jwtService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> demo() {
        return ResponseEntity.ok(
                ResponseObject
                        .builder()
                        .status("200 OK")
                        .message("")
                        .data("Hello world")
                        .build()
        );
    }
}
