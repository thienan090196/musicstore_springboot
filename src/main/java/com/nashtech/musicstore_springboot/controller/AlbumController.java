package com.nashtech.musicstore_springboot.controller;

import com.nashtech.musicstore_springboot.model.Album;
import com.nashtech.musicstore_springboot.service.IAlbumService;
import com.nashtech.musicstore_springboot.service.IArtistService;
import com.nashtech.musicstore_springboot.service.IGenreService;
import com.nashtech.musicstore_springboot.utilities.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

@Controller
@RequestMapping(value = "/album")
public class AlbumController extends BaseController {

    @Autowired
    IAlbumService albumService;

    @Autowired
    IGenreService genreService;

    @Autowired
    IArtistService artistService;

    @RequestMapping(value = "/detail/{albumId}", method = RequestMethod.GET)
    public String detail (@PathVariable("albumId") int albumId,
                          Model model) {
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("detail_album", albumService.findById(albumId));
        model.addAttribute("title", albumService.findById(albumId).getTitle());
        return "detail_album";
    }

    @RequestMapping(value = "/management/all", method = RequestMethod.GET)
    public String getAll(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model, HttpServletRequest request) {
        PagedListHolder<Album> pagedListHolder = new PagedListHolder(albumService.getAll());
        pagedListHolder.setPageSize(ConstantValues.PAGE_SIZE_ADMIN);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());
        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;
        model.addAttribute("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
        }
        model.addAttribute("listModel", pagedListHolder.getPageList());
        return "admin_list_all_album";
    }

    @RequestMapping(value = "/management/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("genres_list", genreService.getAll());
        model.addAttribute("artists_list", artistService.getAll());
        Album album = new Album();
        album.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        album.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        model.addAttribute("album", album);
        return "admin_add_album";
    }

    @RequestMapping(value = "management/save", method = RequestMethod.POST)
    public String save(@Validated @ModelAttribute("album") Album album,
                       BindingResult result, Model model,
                       @RequestParam("file") MultipartFile file,
                       HttpServletRequest request) throws IOException {
        model.addAttribute("genres_list", genreService.getAll());
        model.addAttribute("artists_list", artistService.getAll());
        if (result.hasErrors()) {
            model.addAttribute("album", album);
            return "admin_add_album";
        }

        if (album.getAlbumId() == null) {
            if (file.isEmpty()) {
                model.addAttribute("album", album);
                model.addAttribute("imageError", "Image is required");
                return "admin_add_album";
            }
            album.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        }

        if (!file.isEmpty()) {
            if (validateFileSize(file.getSize()) && validateFileType(file.getContentType()) && uploadFileSuccess(file, request)) {
                album.setImagePath(ConstantValues.UPLOAD_DIRECTORY + file.getOriginalFilename());
            } else {
                model.addAttribute("imageError", "Invalid image!");
                model.addAttribute("album", album);
                return "admin_add_album";
            }
        }
        album.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        albumService.save(album);
        return "redirect:/album/management/all";
    }

    @RequestMapping(value = "/management/edit/{albumId}", method = RequestMethod.GET)
    public String update(@PathVariable("albumId") int albumId,
                         Model model) {
        model.addAttribute("genres_list", genreService.getAll());
        model.addAttribute("artists_list", artistService.getAll());
        model.addAttribute("album", albumService.findById(albumId));
        return "admin_add_album";
    }

    @RequestMapping(value = "/management/delete/{albumId}", method = RequestMethod.GET)
    public String delete(@PathVariable("albumId") int albumId,
                         Model model) {
        albumService.deleteById(albumId);
        return "redirect:/album/management/all";
    }
}
