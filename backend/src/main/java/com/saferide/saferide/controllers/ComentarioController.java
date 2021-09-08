package com.saferide.saferide.controllers;

import com.saferide.saferide.models.ComentarioModel;
import com.saferide.saferide.models.HurtoModel;
import com.saferide.saferide.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public void createComment(@RequestBody ComentarioModel comment) {
        comentarioService.saveComment(comment);
    }

    @GetMapping
    public List<ComentarioModel> readComments(@RequestParam String id_ruta) {
        return comentarioService.readComments(id_ruta);
    }

    @DeleteMapping
    public void deleteComment(@RequestParam String id_comentario) {
        comentarioService.deleteComment(id_comentario);
    }
}
