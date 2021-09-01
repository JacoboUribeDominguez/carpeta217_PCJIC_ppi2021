package com.saferide.saferide.controllers;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.TimesModel;
import com.saferide.saferide.services.TimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/times")
public class TimesController {

    @Autowired
    TimesService timesService;

    @PostMapping
    public Error GetMessage (@RequestBody TimesModel timesModel){
        return timesService.getMessage(timesModel);
    }
}
