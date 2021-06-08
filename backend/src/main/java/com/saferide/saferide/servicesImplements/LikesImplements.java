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
    public Error dislikeRuta(LikeRutaModel ruta) {
        return new Error("", 0);
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
        return new Error("", 0);
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
        return new Error("", 0);
    }
}
