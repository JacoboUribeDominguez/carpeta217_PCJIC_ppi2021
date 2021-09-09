package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.models.ComentarioModel;
import com.saferide.saferide.models.HurtoModel;
import com.saferide.saferide.repositories.ComentarioRepository;
import com.saferide.saferide.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioImplemens implements ComentarioService {

    //repositorio
    @Autowired
    private ComentarioRepository comentarioRepository;

    //Traer el ID del Usuario
    @Autowired
    private ComentarioImplemens comentarioImplemens;

    @Override
    public void saveComment(ComentarioModel comment) {
        Functions functions = new Functions();
        comment.setId_comentario(functions.makeId());
        comentarioRepository.save(comment);
    }

    @Override
    public List<ComentarioModel> readComments(String id_ruta) {
        return (List<ComentarioModel>) comentarioRepository.findAllById(id_ruta);
    }

    @Override
    public void deleteComment(String id_comment) {
        comentarioRepository.deleteById(id_comment);
    }
}
