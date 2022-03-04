package com.teammealkit.mealkit.client.dto;

import com.teammealkit.mealkit.client.domain.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class ClientListResponseDTO {
    private final List<Client> clientList;
}
