package ru.develop.weather.server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.develop.weather.server.clients.AstroClient;
import ru.develop.weather.server.clients.CivilClient;
import ru.develop.weather.server.clients.CivilLightClient;
import ru.develop.weather.server.dto.free7times.astro.AstroDto;
import ru.develop.weather.server.dto.free7times.civil.CivilDto;
import ru.develop.weather.server.dto.free7times.civillight.CivilLightDto;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServerServiceImpl implements ServerService {
    private final CivilLightClient civilLightClient;
    private final CivilClient civilClient;
    private final AstroClient astroClient;
    private final ObjectMapper mapper = new ObjectMapper();
    private ResponseEntity<String> response;
    private final String serializingApi = "Serialize response from api";
    private final String badSerialize = "Bad deserialize.";
    private final String returnDto = "Return response with dto.";

    @Override
    public ResponseEntity<Object> getCivilLight(Double lon, Double lat, String unit, String output) {
        log.info("Sending request to free7times api, type civil light.");
        response = civilLightClient.getCivilLight(lon, lat, unit, output);
        if (response.getStatusCode().is2xxSuccessful()) {
            mapper.registerModule(new JavaTimeModule());
            CivilLightDto civilLightApi = null;
            try {
                log.info(serializingApi);
                civilLightApi = mapper.readValue(response.getBody(), CivilLightDto.class);
            } catch (JsonProcessingException e) {
                log.info(badSerialize);
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
            log.info(returnDto);
            return new ResponseEntity<>(civilLightApi, HttpStatus.OK);
        }
        return new ResponseEntity<>(CivilLightDto.builder().build(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<Object> getCivil(Double lon, Double lat, String unit, String output) {
        log.info("Sending request to free7times api, type civil, with param = {}, {}.", lon, lat);
        response = civilClient.getCivil(lon, lat, unit, output);
        if (response.getStatusCode().is2xxSuccessful()) {
            mapper.registerModule(new JavaTimeModule());
            CivilDto civilApi = null;
            try {
                log.info(serializingApi);
                civilApi = mapper.readValue(response.getBody(), CivilDto.class);
            } catch (JsonProcessingException e) {
                log.info(badSerialize);
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
            log.info(returnDto);
            return new ResponseEntity<>(civilApi, HttpStatus.OK);
        }
        return new ResponseEntity<>(CivilDto.builder().build(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<Object> getAstro(Double lon, Double lat, String unit, String output) {
        log.info("Sending request to free7times api, type astro, with param = {}, {}.", lon, lat);
        response = astroClient.getAstro(lon, lat, unit, output);
        if (response.getStatusCode().is2xxSuccessful()) {
            mapper.registerModule(new JavaTimeModule());
            AstroDto astroApi = null;
            try {
                log.info(serializingApi);
                astroApi = mapper.readValue(response.getBody(), AstroDto.class);
            } catch (JsonProcessingException e) {
                log.info(badSerialize);
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
            log.info(returnDto);
            return new ResponseEntity<>(astroApi, HttpStatus.OK);
        }
        return new ResponseEntity<>(AstroDto.builder().build(), response.getStatusCode());
    }
}
