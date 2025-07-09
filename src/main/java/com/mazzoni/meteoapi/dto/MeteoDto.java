package com.mazzoni.meteoapi.dto;

public class MeteoDto {

    private Double temperatura;

    public MeteoDto() {
    }

    public MeteoDto(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
}
