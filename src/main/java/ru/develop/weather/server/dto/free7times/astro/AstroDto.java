package ru.develop.weather.server.dto.free7times.astro;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AstroDto {
    private String product;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyyMMddHH")
    @JsonFormat(pattern = "yyyyMMddHH")
    private LocalDateTime init;
    private List<AstroDataSeries> dataseries;
}
