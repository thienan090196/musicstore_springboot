package com.nashtech.musicstore_springboot.dao;

import com.nashtech.musicstore_springboot.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreDao extends JpaRepository<Genre, Integer> {
}
