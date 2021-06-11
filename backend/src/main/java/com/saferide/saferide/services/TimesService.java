package com.saferide.saferide.services;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.TimesModel;

public interface TimesService {
    Error getMessage(TimesModel timesModel);
}
