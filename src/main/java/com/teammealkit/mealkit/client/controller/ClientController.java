package com.teammealkit.mealkit.client.controller;

import com.teammealkit.mealkit.client.service.ClientService;
import com.teammealkit.mealkit.client.dto.ClientCreateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
@Lazy
public class ClientController {
    private final ClientService clientService;

//    @GetMapping("/hello")
//    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//        log.info("hello");
//
//        return "hello";
//    }
//
//    @GetMapping("/main")
//    public String main() {
//        log.info("main");
//
//        return "main";
//    }

    // 회원전체 조회
    @GetMapping()
    public ResponseEntity selectClient(@RequestParam(required = false) Long id) {
//        log.error("error message");
//        log.warn("warn message");
//        log.info("info message");
//        log.debug("debug message");
//        log.trace("trace message");

        if (id == null)
            return ResponseEntity.ok(clientService.selectClientList());

        return ResponseEntity.ok(clientService.selectClient(id));
    }

    // 회원가입
    @PostMapping()
    public ResponseEntity createClient(@RequestBody ClientCreateDTO dto) {
        return ResponseEntity.ok(clientService.createClient(dto));
    }
}
