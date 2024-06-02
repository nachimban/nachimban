package com.nachimban.web.flaskapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nachimban.web.flaskapi.dto.FlaskApiRequestDto;
import com.nachimban.web.flaskapi.dto.FlaskApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api") //// Mapping url 확인 필요!
public class FlaskApiController {

    private final FlaskApiService flaskApiService;

    // Flask 서버로 데이터 전송
    @PostMapping("/predict")
    public List<FlaskApiResponseDto>  getPredictionsFromFlask(@RequestBody FlaskApiRequestDto dto) throws JsonProcessingException {
        return flaskApiService.getPredictionsFromFlask(dto);
    }
}