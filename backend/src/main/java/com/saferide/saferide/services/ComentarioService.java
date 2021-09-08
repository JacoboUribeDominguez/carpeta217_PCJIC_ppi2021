package com.saferide.saferide.services;

import com.saferide.saferide.models.ComentarioModel;

import java.util.List;

public interface ComentarioService {
    void saveComment(ComentarioModel comment);//Create

    List<ComentarioModel> readComments(String id_ruta);//Read

    void deleteComment(String id_comment);//Delete

}
