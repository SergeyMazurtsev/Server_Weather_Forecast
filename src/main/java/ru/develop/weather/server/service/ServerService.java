package ru.develop.weather.server.service;

import org.springframework.http.ResponseEntity;

public interface ServerService {
    ResponseEntity<Object> getCivilLight(Double lon, Double lat, String unit, String output);

    ResponseEntity<Object> getCivil(Double lon, Double lat, String unit, String output);

    ResponseEntity<Object> getAstro(Double lon, Double lat, String unit, String output);
}
