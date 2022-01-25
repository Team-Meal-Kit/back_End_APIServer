package com.teammealkit.mealkit.client.controller;

import com.teammealkit.mealkit.Message;
import com.teammealkit.mealkit.StatusEnum;
import com.teammealkit.mealkit.client.domain.Client;
import com.teammealkit.mealkit.client.service.ClientService;
import com.teammealkit.mealkit.client.dto.ClientCreateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Map;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;

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
        log.info("selectClient::Success!!");

        if (id == null)
            return ResponseEntity.ok(clientService.selectClientList());

        return ResponseEntity.ok(clientService.selectClient(id));
    }

    // 회원가입
    @PostMapping()
    public ResponseEntity<Message> createClient(@RequestBody ClientCreateDTO dto) {
        log.info("create Client::start");
        log.info("create Client::" + dto.getEmail());
        Client client = clientService.createClient(dto);
        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        if (! (client == null)) {
            // 회원가입 성공
            log.info("create Client::Success!!");
            message.setStatus(StatusEnum.OK);
            message.setMessage("Success");
            message.setData(client);
        } else {
            // 회원가입 실패
            log.info("create Client::Email that already exits.");
            message.setStatus(StatusEnum.FORBIDDEN);
            message.setMessage("Fail");
            message.setData(client);
        }
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    // 중복검사
    @GetMapping("/user-emails/{email}/exists")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email) {
        return ResponseEntity.ok(clientService.checkEmailDuplicate(email));
    }
}
