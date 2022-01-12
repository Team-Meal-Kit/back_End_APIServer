package com.teammealkit.mealkit.client.service;

import com.teammealkit.mealkit.client.domain.Client;
import com.teammealkit.mealkit.client.repository.ClientRepository;
import com.teammealkit.mealkit.client.dto.ClientCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return clientRepository.save(dto.toEntity());
    }
}
