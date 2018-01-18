package com.nashtech.musicstore_springboot.controller;

import com.nashtech.musicstore_springboot.service.IAlbumService;
import com.nashtech.musicstore_springboot.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/genre")
public class GenreController {

    @Autowired
    private IAlbumService albumService;

    @Autowired
    private IGenreService genreService;

    @RequestMapping(value = "/{genreId}", method = RequestMethod.GET)
    public String listAlbum(@PathVariable("genreId") int genreId,
                            Model model) {
        try {
            model.addAttribute("listAlbums", albumService.getAllByGenreId(genreId));
            model.addAttribute("genreList", genreService.getAll());
            model.addAttribute("title", genreService.findById(genreId).getName());
            return "list_album";
        } catch (NumberFormatException ex) {
            return "page_not_found";
        }
    }
}
