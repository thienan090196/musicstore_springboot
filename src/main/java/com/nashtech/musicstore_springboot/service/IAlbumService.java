package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.model.Album;

import java.util.List;

public interface IAlbumService {
    void save(Album album);
    List<Album> getAll();
    List<Album> getAllByGenreId(Integer genreId);
    Album findById(Integer albumId);
    void update(Album album);
    void deleteById(Integer albumId);
}
