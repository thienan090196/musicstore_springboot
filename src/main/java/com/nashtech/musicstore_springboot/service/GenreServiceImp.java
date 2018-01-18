package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.dao.IGenreDao;
import com.nashtech.musicstore_springboot.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("genreService")
public class GenreServiceImp implements IGenreService {

    @Autowired
    IGenreDao genreDao;

    @Override
    public void save(Genre genre) {
        genreDao.save(genre);
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.findAll(new Sort(Sort.Direction.DESC, "modifiedAt", "createdAt"));
    }

    @Override
    public Genre findById(Integer genreId) {
        return genreDao.findOne(genreId);
    }

    @Override
    public void update(Genre genre) {
        genreDao.save(genre);
    }

    @Override
    public void deleteById(Integer genreId) {
        genreDao.delete(genreId);
    }
}
