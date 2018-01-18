package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.model.Artist;
import java.util.List;

public interface IArtistService {
    void save(Artist artist);
    List<Artist> getAll();
    Artist findById(Integer artistId);
    void update(Artist artist);
    void deleteById(Integer artistId);
}
