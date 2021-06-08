package com.saferide.saferide.services;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.LikeHurtoModel;
import com.saferide.saferide.models.LikeRutaModel;
import com.saferide.saferide.models.LikeSenderoModel;

public interface LikesService {
    Error likeRuta(LikeRutaModel ruta);
    Error likeSendero(LikeSenderoModel sendero);
    Error likeHurto(LikeHurtoModel hurto);
}
