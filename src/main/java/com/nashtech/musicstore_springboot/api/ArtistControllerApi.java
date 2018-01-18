package com.nashtech.musicstore_springboot.api;

import com.nashtech.musicstore_springboot.controller.BaseController;
import com.nashtech.musicstore_springboot.model.Artist;
import com.nashtech.musicstore_springboot.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api/artist")
public class ArtistControllerApi extends BaseController {

    @Autowired
    private IArtistService artistService;

    @RequestMapping(value = "/management-api/retrieve", method = RequestMethod.GET)
    public List<Artist> getAllAlbums() {
        return artistService.getAll();
    }
}
