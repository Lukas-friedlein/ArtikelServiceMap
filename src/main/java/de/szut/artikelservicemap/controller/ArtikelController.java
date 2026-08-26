package de.szut.artikelservicemap.controller;

import de.szut.artikelservicemap.model.Artikel;
import de.szut.artikelservicemap.service.ArtikelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myappdata/articles")
public class ArtikelController {

    private ArtikelService artikelService;

    public ArtikelController() {
        artikelService = new ArtikelService();
    }

    @GetMapping
    public ResponseEntity<List<Artikel>> getArtikel() {
        List<Artikel> artikelList = artikelService.readAll();
        return new ResponseEntity<>(artikelList, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Artikel> getArtikel(@PathVariable long id) {
        Artikel artikel = artikelService.read(id);
        return new ResponseEntity<>(artikel, HttpStatus.OK);

    }


}
