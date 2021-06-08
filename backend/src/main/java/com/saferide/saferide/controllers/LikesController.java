package com.saferide.saferide.controllers;

import com.saferide.saferide.models.LikeHurtoModel;
import com.saferide.saferide.models.LikeRutaModel;
import com.saferide.saferide.models.LikeSenderoModel;
import com.saferide.saferide.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.saferide.saferide.helpers.Error;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/ruta")
    public Error likeRuta(@RequestBody LikeRutaModel ruta) {
        return likesService.likeRuta(ruta);
    }

    @PostMapping("/sendero")
    public Error likeSendero(@RequestBody LikeSenderoModel sendero) {
        return likesService.likeSendero(sendero);
    }

    @PostMapping("/hurto")
    public Error likeHurto(@RequestBody LikeHurtoModel hurto) {
        return likesService.likeHurto(hurto);
    }
}
