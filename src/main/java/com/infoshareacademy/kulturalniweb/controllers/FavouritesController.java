package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
import com.infoshareacademy.kulturalniweb.services.FavouritesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FavouritesController {

    FavouritesService favouritesService;
    Integer favId = 0;

    public FavouritesController(FavouritesService favouritesService) {
        this.favouritesService = favouritesService;
    }

    @GetMapping("/favour")
    public String favourites(Model model) {

        List<EventDto> eventDtos = favouritesService.getFavourites();
        //Integer i = eventDtos.size();
        //eventDtos.get(i - 1).setFavourite(true);
        model.addAttribute("listOfEventDto", eventDtos);

        System.out.println("favo");

        return "favourites";
    }

    @GetMapping(value = "/favselectFav")
    public String favSelect(@RequestParam("id") Integer id,
                            @RequestParam("favStatus") Boolean favStatus) {
        favId = id;
        System.out.println(favId);
        favouritesService.updateFavourite(id, favStatus);

        return "redirect:favour";
    }
}
