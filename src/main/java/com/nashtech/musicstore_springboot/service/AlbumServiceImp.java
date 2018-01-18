package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.dao.IAlbumDao;
import com.nashtech.musicstore_springboot.model.Album;
import com.nashtech.musicstore_springboot.utilities.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service("albumService")
public class AlbumServiceImp implements IAlbumService {

    @Autowired
    IAlbumDao albumDao;

    public void save(Album album) {
        albumDao.save(album);
    }

    public List<Album> getAll() {
        return albumDao.findAll(new Sort(Sort.Direction.DESC, "modifiedAt", "createdAt"));
    }

    @Override
    public List<Album> getAllByGenreId(Integer genreId) {
        return albumDao.findAllByGenreId(genreId);
    }

    public Album findById(Integer albumId) {
        return albumDao.findOne(albumId);
    }

    public void update(Album album) {
        albumDao.save(album);
    }

    public void deleteById(Integer albumId) {
        albumDao.delete(albumId);
    }
}
