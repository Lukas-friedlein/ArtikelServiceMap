package de.szut.artikelservicemap.service;

import de.szut.artikelservicemap.model.Artikel;
import de.szut.artikelservicemap.repository.ArtikelDao;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ArtikelService {

    private ArtikelDao artikelDao;

    public ArtikelService() {
        artikelDao = new ArtikelDao();
    }

    public Artikel read(long id) {
        return artikelDao.findById(id);
    }

    public List<Artikel> readAll() {
        return  artikelDao.findAll();
    }

    public Artikel add(Artikel artikel) {
        artikelDao.insert(artikel);
        return artikelDao.findById(artikel.getId());
    }

    public Artikel update(Artikel artikel) {
        artikelDao.update(artikel);
        return artikelDao.findById(artikel.getId());
    }

    public void delete(long id) {
        artikelDao.delete(id);
    }
}
