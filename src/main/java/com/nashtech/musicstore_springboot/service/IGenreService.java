package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.model.Genre;
import java.util.List;

public interface IGenreService {
    void save(Genre genre);
    List<Genre> getAll();
    Genre findById(Integer genreId);
    void update(Genre genre);
    void deleteById(Integer genreId);
}
