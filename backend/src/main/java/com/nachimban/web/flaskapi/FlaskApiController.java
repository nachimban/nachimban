package com.nachimban.web.flaskapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nachimban.web.flaskapi.dto.FlaskApiRequestDto;
import com.nachimban.web.flaskapi.dto.FlaskApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api") //// Mapping url 확인 필요!
public class FlaskApiController {

    private final FlaskApiService flaskApiService;
    private final DtoStorageService dtoStorageService;


    // 여행지 추천
    @PostMapping("/predict")
    public List<FlaskApiResponseDto> getRegionPredictionsFromFlask(@RequestBody FlaskApiRequestDto dto) throws JsonProcessingException {
        dtoStorageService.saveRequestDto("latestDto", dto);
        return flaskApiService.getPredictionsFromFlask(dto);
    }

    // 관광지 추천
    @PostMapping("/predict/{region}")
    public List<FlaskApiResponseDto>  getPlacePredictionsFromFlask(@PathVariable String region) throws JsonProcessingException {
        FlaskApiRequestDto dto = dtoStorageService.getRequestDto("latestDto");
        if (dto == null) {
            throw new RuntimeException("No DTO available, please call /predict first");
        }
        return flaskApiService.getPredictionsFromFlask(dto, region);
    }
}
