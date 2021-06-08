package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.LikeHurtoModel;
import com.saferide.saferide.models.LikeRutaModel;
import com.saferide.saferide.models.LikeSenderoModel;
import com.saferide.saferide.repositories.LikeHurtoRepository;
import com.saferide.saferide.repositories.LikeRutaRepository;
import com.saferide.saferide.repositories.LikeSenderoRepository;
import com.saferide.saferide.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikesImplements implements LikesService {

    @Autowired
    private LikeRutaRepository likeRutaRepository;
    @Autowired
    private LikeSenderoRepository likeSenderoRepository;
    @Autowired
    private LikeHurtoRepository likeHurtoRepository;

    @Override
    public Error likeRuta(LikeRutaModel ruta) {
        try {
            likeRutaRepository.save(ruta);
            return new Error("Like exitoso", 0);
        } catch (Exception e) {
            return new Error("Hubo un error", 1);
        }
    }

    @Override
    @Transactional
    public Error dislikeRuta(LikeRutaModel ruta) {
        try {
            likeRutaRepository.deleteRuta(ruta.getId_ruta(), ruta.getId_usuario());
            return new Error("Eliminación exitosa", 0);
        } catch (Exception e) {
            System.out.println(e);
            return new Error("Hubo un error", 1);
        }
    }

    @Override
    public Error likeSendero(LikeSenderoModel sendero) {
        try {
            likeSenderoRepository.save(sendero);
            return new Error("Like exitoso", 0);
        } catch (Exception e) {
            return new Error("Hubo un error", 1);
        }
    }

    @Override
    public Error dislikeSendero(LikeSenderoModel sendero) {
        try {
            likeSenderoRepository.deleteSendero(sendero.getId_sendero(), sendero.getId_usuario());
            return new Error("Eliminación exitosa", 0);
        } catch (Exception e) {
            return new Error("Hubo un error", 1);
        }
    }

    @Override
    public Error likeHurto(LikeHurtoModel hurto) {
        try {
            likeHurtoRepository.save(hurto);
            return new Error("Like exitoso", 0);
        } catch (Exception e) {
            return new Error("Hubo un error", 1);
        }
    }

    @Override
    public Error dislikeHurto(LikeHurtoModel hurto) {
        try {
            likeHurtoRepository.deleteHurto(hurto.getId_hurto(), hurto.getId_usuario());
            return new Error("Eliminación exitosa", 0);
        } catch (Exception e) {
            return new Error("Hubo un error", 1);
        }
    }
}
