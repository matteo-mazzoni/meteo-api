package com.mazzoni.meteoapi.dto;

public class MeteoDto {

    private Double temperatura;
    private Double temperaturaPercepita;

    public MeteoDto() {
    }

    public MeteoDto(Double temperatura, Double temperaturaPercepita) {
        this.temperatura = temperatura;
        this.temperaturaPercepita = temperaturaPercepita;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getTemperaturaPercepita() {
        return temperaturaPercepita;
    }

    public void setTemperaturaPercepita(Double temperaturaPercepita) {
        this.temperaturaPercepita = temperaturaPercepita;
    }
}
