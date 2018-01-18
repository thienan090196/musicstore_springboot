package com.nashtech.musicstore_springboot.api;

import com.nashtech.musicstore_springboot.controller.BaseController;
import com.nashtech.musicstore_springboot.model.Genre;
import com.nashtech.musicstore_springboot.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api/genre")
public class GenreControllerApi extends BaseController {

    @Autowired
    private IGenreService genreService;

    @RequestMapping(value = "/management-api/retrieve", method = RequestMethod.GET)
    public List<Genre> getAllAlbums() {
        return genreService.getAll();
    }
}
