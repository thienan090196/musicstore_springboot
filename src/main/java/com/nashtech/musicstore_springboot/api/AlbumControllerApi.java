package com.nashtech.musicstore_springboot.api;

import com.nashtech.musicstore_springboot.controller.BaseController;
import com.nashtech.musicstore_springboot.model.Album;
import com.nashtech.musicstore_springboot.service.IAlbumService;
import com.nashtech.musicstore_springboot.service.IArtistService;
import com.nashtech.musicstore_springboot.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/api/album")
public class AlbumControllerApi extends BaseController {

    @Autowired
    IAlbumService albumService;

    @Autowired
    IGenreService genreService;

    @Autowired
    IArtistService artistService;

    @RequestMapping(value = "management-api/create", method = RequestMethod.POST)
    public void addOneAlbum(@RequestBody Album album) {
        album.setImagePath("testImage.abc");
        album.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        album.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        albumService.save(album);
    }

    @RequestMapping(value = "/management-api/retrieve", method = RequestMethod.GET)
    public List<Album> getAllAlbums() {
        return albumService.getAll();
    }

    @RequestMapping(value = "/management-api/update/{albumId}", method = RequestMethod.GET)
    public Album getAlbumDetail(@PathVariable("albumId") int albumId) {
        return albumService.findById(albumId);
    }

    @RequestMapping(value = "management-api/update", method = RequestMethod.PUT)
    public void updateOneAlbum(@RequestBody Album album) {
        album.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        albumService.save(album);
    }

    @RequestMapping(value = "/management-api/delete/{albumId}", method = RequestMethod.DELETE)
    public void deleteOneAlbum(@PathVariable("albumId") int albumId) {
        albumService.deleteById(albumId);
    }
}
