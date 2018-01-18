package com.nashtech.musicstore_springboot.dao;

import com.nashtech.musicstore_springboot.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistDao extends JpaRepository<Artist, Integer> {
}
