package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.dao.IArtistDao;
import com.nashtech.musicstore_springboot.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("artistService")
public class ArtistServiceImp implements IArtistService {

    @Autowired
    IArtistDao artistDao;

    @Override
    public void save(Artist artist) {
        artistDao.save(artist);
    }

    @Override
    public List<Artist> getAll() {
        return artistDao.findAll(new Sort(Sort.Direction.DESC, "modifiedAt", "createdAt"));
    }

    @Override
    public Artist findById(Integer artistId) {
        return artistDao.findOne(artistId);
    }

    @Override
    public void update(Artist artist) {
        artistDao.save(artist);
    }

    @Override
    public void deleteById(Integer artistId) {
        artistDao.delete(artistId);
    }
}
