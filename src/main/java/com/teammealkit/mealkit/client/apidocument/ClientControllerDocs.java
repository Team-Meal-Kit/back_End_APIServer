package com.teammealkit.mealkit.client.apidocument;

import com.teammealkit.mealkit.client.dto.ClientCreateDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientControllerDocs {
    @ApiOperation(value = "회원가입", notes = "회원가입")
    public ResponseEntity createClient(@RequestBody ClientCreateDTO dto);
}
