package com.gaden.skeleton.controller;

import com.gaden.skeleton.model.ResponseObject;
import com.gaden.skeleton.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
