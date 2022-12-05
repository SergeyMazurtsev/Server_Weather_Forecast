package ru.develop.weather.server.clients;

import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.develop.weather.server.dto.free7times.civillight.CivilLightDto;

@Component
@FeignClient(name = "yandex", url = "${server.url.yandex}")
public interface YandexClient {

    @Headers("X-Yandex-API-Key: {apiKey}")
    ResponseEntity<CivilLightDto> getCivil(@Param("apiKey") String apiKey);

}
