package com.nachimban.web.flaskapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nachimban.web.flaskapi.dto.FlaskApiRequestDto;
import com.nachimban.web.flaskapi.dto.FlaskApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FlaskApiService {

    private final ObjectMapper objectMapper;

    @Transactional
    public List<FlaskApiResponseDto> getPredictionsFromFlask(FlaskApiRequestDto dto) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // dto 객체를 JSON 문자열로 변환
        String param = objectMapper.writeValueAsString(dto);

        // JSON 문자열과 헤더를 포함하는 HttpEntity 객체 생성
        HttpEntity<String> entity = new HttpEntity<>(param, headers);
        // System.out.println("Sending JSON: " + param);

        // Flask 서버와 연결하기 위한 URL
        String url = "http://127.0.0.1:5000/predict";

        // Flask 서버로 요청 보내기
        ResponseEntity<FlaskApiResponseDto[]> response = restTemplate.postForEntity(url, entity, FlaskApiResponseDto[].class);

        // 응답이 null인지 확인하고, null이 아닐 경우 리스트로 반환
        return List.of(Objects.requireNonNull(response.getBody()));

    }

    @Transactional
    public List<FlaskApiResponseDto> getPredictionsFromFlask(FlaskApiRequestDto dto, String region) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // dto 객체를 JSON 문자열로 변환
        String param = objectMapper.writeValueAsString(dto);

        // JSON 문자열과 헤더를 포함하는 HttpEntity 객체 생성
        HttpEntity<String> entity = new HttpEntity<>(param, headers);
        // System.out.println("Sending JSON: " + param);

        // Flask 서버와 연결하기 위한 URL
        // UriComponentsBuilder를 사용하여 URL 설정 및 변수 바인딩
        String url = UriComponentsBuilder.fromUriString("http://127.0.0.1:5000/predict/{region}")
                .buildAndExpand(Collections.singletonMap("region", region))
                .toUriString();

        // Flask 서버로 요청 보내기
        ResponseEntity<FlaskApiResponseDto[]> response = restTemplate.postForEntity(url, entity, FlaskApiResponseDto[].class);

        // 응답이 null인지 확인하고, null이 아닐 경우 리스트로 반환
        return List.of(Objects.requireNonNull(response.getBody()));

    }

}
