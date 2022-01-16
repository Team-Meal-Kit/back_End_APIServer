package com.teammealkit.mealkit.apidocument;

import com.teammealkit.mealkit.client.dto.ClientCreateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;

@Api(tags="Client Controller")
public interface ClientControllerDocs {
    @ApiOperation(value = "회원가입", notes = "회원가입")
    public ResponseEntity createClient(@ApiParam(value = "회원 생성 정보") ClientCreateDTO dto);
}