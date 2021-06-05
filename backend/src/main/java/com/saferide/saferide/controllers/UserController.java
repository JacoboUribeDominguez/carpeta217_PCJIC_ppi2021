package com.saferide.saferide.controllers;

//importamos diferentes anotaciones y funciones a usar

import com.saferide.saferide.models.UserModel;
import com.saferide.saferide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.saferide.saferide.helpers.Error;

@RestController //indica que será una apirest
@CrossOrigin(origins = "*")
/*
    CrossOrigin es nuestro mejor amigo, las restapi por temas de seguridad han recurrido
    a prohibir peticiones desde paginas http, esto se debe a que era la forma de hacer
    ataque ciberneticos más fácil. CrossOrigin(origins = "http://localhost:8080") nos
    acepta las peticiones desde nuestro local host. Esto mientras estamos en desarrollo
    en producción será eliminado en caso de usar un host https. Si usamos cpanel indicarémos
    la dirección ip del cpanel, puesto que cpanel es http, para comprobar pueden ingresar en
    jakouribe.com.co y verán que aparece como url insegura.

    Nuestro proyecto lo configuramos en el http://localhost/8081 para evitar choques con el frontend
    que se ejecuta en http://localhost/8080.

    es decir, crossorigin permite hacer peticiones a esta api desde http://localhost/8080.
 */
public class UserController {

    @Autowired //esta etiqueta es quien nos deja insertar otra clase; En este caso, la interface userService
    UserService userService;

    /*

        ¿Cómo funciona las peticiones a la api rest?
        principalmente con las anotaciones mapping indicarémos que tipo de peticion es y la ruta que se debe seguir
        Anotaciones que usaremos: @GetMapping @PostMapping @PutMapping @DeleteMapping.

        ¿Cómo enrutamos las anotaciones mapping?
        Se pone entre parentesís la ruta, ejemplo:
        @GetMapping("/users")

        Exactamente en la linea inferior a la anotación tiene que ir la función. Ejemplo:

        Por favor ignoren todo lo que hay después de la flecha "<--" en cada linea

        @GetMapping("/users") <-- Esta es la anotación mapping enrutada
        public List<UserModel> getUsers(){ <-- sintaxis general para declarar una función List<UserModel> es el tipo de dato a retornar
            return(userService.getUsers()); <-- retorna los datos
        }

     */
    /*
        TAREA: Inicio de sesión.
        Asignación: Juan David Velasquez Toro
    */

    @PostMapping("/login")
    public Error login(@RequestBody UserModel user){
        return (userService.login(user));
    }

    /*
        Función para el registro de usuarios.
    */

    @PostMapping("/saveUser")
    public Error saveUsers(@RequestBody UserModel userLog) {
        return userService.saveUsers(userLog);
    }


}
