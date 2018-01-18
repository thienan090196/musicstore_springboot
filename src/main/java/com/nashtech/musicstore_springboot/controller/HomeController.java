package com.nashtech.musicstore_springboot.controller;

import com.nashtech.musicstore_springboot.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private IGenreService genreService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String index(Model model,
                        HttpServletRequest request) {
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("title", "HomePage");
        return "index";
    }

    @RequestMapping(value = "/page-not-found", method = RequestMethod.GET)
    public String pageNotFound(Model model,
                               HttpServletRequest request) {
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("title", "File Not Found");
        return "error-page/404";
    }

    @RequestMapping(value = "/forbidden", method = RequestMethod.GET)
    public String forbiddenPage(Model model,
                                HttpServletRequest request) {
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("title", "Forbidden");
        return "error-page/403";
    }

    @RequestMapping(value = "/bad-request", method = RequestMethod.GET)
    public String badRequest(Model model,
                             HttpServletRequest request) {
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("title", "Bad Request");
        return "error-page/400";
    }
}
