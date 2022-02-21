package com.teammealkit.mealkit.client.service;

import com.teammealkit.mealkit.client.domain.Client;
import com.teammealkit.mealkit.client.repository.ClientRepository;
import com.teammealkit.mealkit.client.dto.ClientCreateDTO;
import com.teammealkit.mealkit.client.role.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Lazy
public class ClientService {
    private final ClientRepository clientRepository;
    private final BCryptPasswordEncoder passwordEncoder;

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
    public Client signUp(final ClientCreateDTO dto) {
        final Client client = Client.builder()
                .email(dto.getEmail())
                .pw(passwordEncoder.encode(dto.getPw()))
                .userName(dto.getUserName())
                .birthDay(dto.getBirthDay())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .buyCnt(new Long(0))
                .role(UserRole.ROLE_CLIENT)
                .build();

        return clientRepository.save(client);
//        clientRepository.findByEmail(dto.getEmail());
//        if (validateDuplicateClient(dto.toEntity())) {
//            dto.setPassword(passwordEncoder.encode(dto.getPassword()));
//            return clientRepository.save(dto.toEntity());
//        } else {
//            return null;
//        }
    }

    // email Button 중복 검사
    public boolean isEmailDuplicated(String email) {
        return clientRepository.existsByEmail(email);
    }

//    // 회원가입 시 중복회원 검사
//    private boolean validateDuplicateClient(Client user) {
//        Optional<Client> optionalClient = clientRepository.findByEmail(user.getEmail());
//        if (optionalClient.isPresent()) {
//            return false;
//        } else {
//            return true;
//        }
//    }
}
