package com.nachimban.web.flaskapi;

import com.nachimban.web.flaskapi.dto.FlaskApiRequestDto;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class DtoStorageService {
    private final ConcurrentHashMap<String, FlaskApiRequestDto> storage = new ConcurrentHashMap<>();

    public void saveRequestDto(String key, FlaskApiRequestDto dto) {
        storage.put(key, dto);
    }

    public FlaskApiRequestDto getRequestDto(String key) {
        return storage.get(key);
    }

    public void removeRequestDto(String key) {
        storage.remove(key);
    }
}
