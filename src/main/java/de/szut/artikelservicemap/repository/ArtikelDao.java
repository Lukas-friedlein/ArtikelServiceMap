package de.szut.artikelservicemap.repository;

import de.szut.artikelservicemap.model.Artikel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ArtikelDao {

    private Map<Long, Artikel> artikelListe;

    public ArtikelDao() {
        artikelListe = new HashMap<>();
        initHashMap();
    }

    private void initHashMap() {
        insert(new Artikel(1, "Café Small","kalt",0.17,1.5));
        insert(new Artikel(2, "McSundae","geschmolzen",0.53,2));

    }

    public Artikel findById(Long id) {
        return artikelListe.getOrDefault(id, null);
    }

    public List<Artikel> findAll() {
        return new ArrayList<>(artikelListe.values());
    }

    public void insert(Artikel artikel) {
        if(!artikelListe.containsKey(artikel.getId())) {
            artikelListe.put(artikel.getId(), artikel);
        }
    }

    public void update(Artikel artikel) {
        if(artikelListe.containsKey(artikel.getId())) {
            artikelListe.put(artikel.getId(), artikel);
        }
    }

    public void delete(long id) {
        artikelListe.remove(id);
    }
}
