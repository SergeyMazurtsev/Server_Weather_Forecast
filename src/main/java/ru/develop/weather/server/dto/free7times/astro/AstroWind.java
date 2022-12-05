package ru.develop.weather.server.dto.free7times.astro;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AstroWind {
    private String direction;
    private Integer speed;
}
