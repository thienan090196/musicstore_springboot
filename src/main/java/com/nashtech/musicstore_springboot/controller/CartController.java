package com.nashtech.musicstore_springboot.controller;

import com.nashtech.musicstore_springboot.model.Album;
import com.nashtech.musicstore_springboot.service.IAlbumService;
import com.nashtech.musicstore_springboot.service.IGenreService;
import com.nashtech.musicstore_springboot.utilities.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    IGenreService genreService;

    @Autowired
    IAlbumService albumService;

    @RequestMapping(value = "/getCart", method = RequestMethod.GET)
    public String getCart(Model model,
                          HttpServletRequest request) {
        HttpSession session = request.getSession();
        HashMap<Integer, Album> listCart = (HashMap<Integer, Album>) session.getAttribute(ConstantValues.CART_SESSION);
        if (listCart == null || listCart.isEmpty()) {
            model.addAttribute("empty_cart", "Your cart is empty");
        } else{
            model.addAttribute("list_cart", listCart.values());
        }
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("title", "Cart");
        return "cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addToCart(@RequestParam("albumId") Integer albumId,
                            Model model,
                            HttpServletRequest request) {
        HttpSession session = request.getSession();
        HashMap<Integer, Album> listCart = (HashMap<Integer, Album>) session.getAttribute(ConstantValues.CART_SESSION);
        if (listCart == null || listCart.isEmpty()) {
            listCart = new HashMap<Integer, Album>();
        }
        Album album = albumService.findById(albumId);
        if (listCart.containsKey(albumId)) {
            album.setQuantity(listCart.get(albumId).getQuantity() + 1);
        } else {
            album.setQuantity(1);
        }
        listCart.put(albumId, album);
        session.setAttribute(ConstantValues.CART_SESSION, listCart);
        return "redirect:/album/detail/" + albumId;
    }

    @RequestMapping(value = "/remove/{albumId}", method = RequestMethod.GET)
    public String removeFromCart(@PathVariable("albumId") Integer albumId,
                                 Model model,
                                 HttpServletRequest request) {
        HttpSession session = request.getSession();
        HashMap<Integer, Album> listCart = (HashMap<Integer, Album>) session.getAttribute(ConstantValues.CART_SESSION);
        if (listCart == null || listCart.isEmpty()) {
            model.addAttribute("empty_cart", "Your cart is empty");
        }
        Album album = albumService.findById(albumId);
        if (album != null) {
            listCart.remove(albumId);
        }
        session.setAttribute(ConstantValues.CART_SESSION, listCart);
        return "redirect:/cart/getCart";
    }
}
