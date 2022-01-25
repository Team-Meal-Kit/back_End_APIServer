package com.teammealkit.mealkit.client.service;

import com.teammealkit.mealkit.client.domain.Client;
import com.teammealkit.mealkit.client.repository.ClientRepository;
import com.teammealkit.mealkit.client.dto.ClientCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Lazy
public class ClientService {
    private final ClientRepository clientRepository;

    // SELECT client
    public Client selectClient(Long id) {
        Client client = clientRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Can't find target client"
                ));

        return client;
    }

    //SELECT ALL Clients
    public List<Client> selectClientList() {
        return clientRepository.findAll();
    }

    // CREATE Client
    public Client createClient(ClientCreateDTO dto) {
        clientRepository.findByEmail(dto.getEmail());
        if (validateDuplicateClient(dto.toEntity())) {
            // 오늘 날짜
            return clientRepository.save(dto.toEntity());
        } else {
            return null;
        }
    }

    // email Button 중복 검사
    public boolean checkEmailDuplicate(String email) {
        return clientRepository.existsByEmail(email);
    }

    // 회원가입 시 중복회원 검사
    private boolean validateDuplicateClient(Client user) {
        Optional<Client> optionalClient = clientRepository.findByEmail(user.getEmail());
        if (optionalClient.isPresent()) {
            return false;
        } else {
            return true;
        }
    }
    
    // 로그인
    //        Client findClient = clientRepository.findByEmail(dto.getEmail())
    //                .orElseThrow(() -> new IllegalArgumentException("잘못된 이메일입니다."));
}
