package com.mazzoni.meteoapi.service;

import com.mazzoni.meteoapi.dto.MeteoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class MeteoService {

    private static final Map<String, double[]> COORDINATE_CITTA = Map.of(
            "Roma", new double[]{41.9028, 12.4964},
            "Milano", new double[]{45.4642, 9.1900},
            "Napoli", new double[]{40.8518, 14.2681},
            "Torino", new double[]{45.0703, 7.6869}
    );

    private static final String OPEN_METEO_URL = "https://api.open-meteo.com/v1/forecast";

    private final RestTemplate restTemplate = new RestTemplate();

    public MeteoDto getMeteoPerCitta(String citta) {
        double[] coord = COORDINATE_CITTA.getOrDefault(citta, new double[]{41.9028, 12.4964});

        String url = UriComponentsBuilder.fromHttpUrl(OPEN_METEO_URL)
                .queryParam("latitude", coord[0])
                .queryParam("longitude", coord[1])
                .queryParam("current_weather", true)
                .build()
                .toUriString();

        OpenMeteoResponse response = restTemplate.getForObject(url, OpenMeteoResponse.class);

        if (response != null && response.currentWeather != null) {
            Double temperatura = response.currentWeather.temperature;
            Double temperaturaPercepita = response.currentWeather.apparentTemperature;
            return new MeteoDto(temperatura, temperaturaPercepita);
        }
        return new MeteoDto(null, null);
    }

    private static class OpenMeteoResponse {
        @JsonProperty("current_weather")
        public CurrentWeather currentWeather;
    }

    private static class CurrentWeather {
        @JsonProperty("temperature")
        public Double temperature;

        @JsonProperty("apparent_temperature")
        public Double apparentTemperature;
    }
}
