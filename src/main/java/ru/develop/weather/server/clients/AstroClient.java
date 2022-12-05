package ru.develop.weather.server.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@FeignClient(name = "Astro", url = "https://www.7timer.info/bin/astro.php")
public interface AstroClient {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> getAstro(
            @RequestParam(name = "lon") Double lon,
            @RequestParam(name = "lat") Double lat,
            @RequestParam(name = "unit", required = false, defaultValue = "metric") String unit,
            @RequestParam(name = "output", required = false, defaultValue = "json") String output);
}
