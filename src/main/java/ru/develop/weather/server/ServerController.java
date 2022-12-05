package ru.develop.weather.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.develop.weather.server.service.ServerService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ServerController {
    private final ServerService service;

    @GetMapping("/astro")
    public ResponseEntity<Object> getAstro(
            @RequestHeader(name = "City-lat") Double lat,
            @RequestHeader(name = "City-lon") Double lon) {
        log.info("Get request to astro weather.");
        return service.getAstro(lon, lat, "metric", "json");
    }

    @GetMapping("/civil_light")
    public ResponseEntity<Object> getCivilLight(
            @RequestHeader(name = "City-lat") Double lat,
            @RequestHeader(name = "City-lon") Double lon) {
        log.info("Get request to civil light weather.");
        return service.getCivilLight(lon, lat, "metric", "json");
    }

    @GetMapping("/civil")
    public ResponseEntity<Object> getCivil(
            @RequestHeader(name = "City-lat") Double lat,
            @RequestHeader(name = "City-lon") Double lon) {
        log.info("Get request to civil weather.");
        return service.getCivil(lon, lat, "metric", "json");
    }

    @GetMapping("/yandex")
    public ResponseEntity<Object> getYandex() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
