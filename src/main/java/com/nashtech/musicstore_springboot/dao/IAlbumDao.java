package com.nashtech.musicstore_springboot.dao;

import com.nashtech.musicstore_springboot.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAlbumDao extends JpaRepository<Album, Integer> {
    List<Album> findAllByGenreId(Integer genreId);
}
