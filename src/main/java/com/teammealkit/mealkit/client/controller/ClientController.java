package com.teammealkit.mealkit.client.controller;

import com.teammealkit.mealkit.client.domain.Client;
import com.teammealkit.mealkit.client.dto.ClientListResponseDTO;
import com.teammealkit.mealkit.client.filter.TokenUtils;
import com.teammealkit.mealkit.client.repository.ClientRepository;
import com.teammealkit.mealkit.client.service.ClientService;
import com.teammealkit.mealkit.client.dto.ClientCreateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
@Lazy
public class ClientController {
    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 회원 전체 조회
//    @GetMapping()
//    public ResponseEntity selectClient(@RequestParam(required = false) Long id) {
//        log.info("selectClient::Success!!");
//
//        if (id == null)
//            return ResponseEntity.ok(clientService.selectClientList());
//
//        return ResponseEntity.ok(clientService.selectClient(id));
//    }
    @GetMapping(value = "/list")
    public ResponseEntity<ClientListResponseDTO> findAll() {
        final ClientListResponseDTO clientListResponseDTO = ClientListResponseDTO.builder()
                .clientList(clientService.selectClientList()).build();

        return ResponseEntity.ok(clientListResponseDTO);
    }

    // 회원가입
    @PostMapping()
    public ResponseEntity<String> createClient(@RequestBody ClientCreateDTO dto) {
        return clientService.isEmailDuplicated(dto.getEmail())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(TokenUtils.generateJwtToken(clientService.signUp(dto)));

//        Message message = new Message();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        // 중복검사
//        if (clientService.isEmailDuplicated(dto.getEmail())) {
//            return ResponseEntity.badRequest().build();
//        } else {
//            return ResponseEntity.ok((TokenUtils.generateJwtToken(clientService.signUp(dto))));
//        }
//        return new ResponseEntity<Message>(message, headers, HttpStatus.OK);

//        // DB에 회원정보 저장
//        Client client = clientService.createClient(dto);
//        Message message = new Message();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//        if (! (client == null)) {
//            // 회원가입 성공
//            message.setStatus(StatusEnum.OK.getStatusCode());
//            message.setMessage(StatusEnum.OK);
//        } else {
//            // 회원가입 실패
//            message.setStatus(StatusEnum.FORBIDDEN.getStatusCode());
//            message.setMessage(StatusEnum.FORBIDDEN);
//        }
//        return new ResponseEntity<Message>(message, headers, HttpStatus.OK);
    }

    // 중복검사 페이지
    @GetMapping("/user-emails/{email}/exists")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email) {
        return ResponseEntity.ok(clientService.isEmailDuplicated(email));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.login(client.getEmail(), client.getPw()));
    }
}
