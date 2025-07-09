package com.mazzoni.meteoapi.controller;

import com.mazzoni.meteoapi.dto.MeteoDto;
import com.mazzoni.meteoapi.service.MeteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MeteoController {

    @Autowired
    private MeteoService meteoService;

    private static final List<String> CITTA = List.of("Roma", "Milano", "Napoli", "Torino","Firenze", "Venezia","Bologna","Genova", "Palermo","Bari");

    // Mostra form per scegliere città
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cittaDisponibili", CITTA);
        return "index";
    }

    // Mostra meteo per la città selezionata
    @GetMapping("/meteo")
    public String meteo(@RequestParam(name="citta", required=false, defaultValue="Roma") String citta, Model model) {
        model.addAttribute("cittaDisponibili", CITTA);
        model.addAttribute("cittaSelezionata", citta);

        MeteoDto meteo = meteoService.getMeteoPerCitta(citta);
        model.addAttribute("temperatura", meteo.getTemperatura());

        return "meteo";
    }
}
