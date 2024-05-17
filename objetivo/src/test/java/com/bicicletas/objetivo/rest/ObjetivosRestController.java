package com.bicicletas.objetivo.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation. RestController;

import com.bicicletas.objetivo.modelo.Objetivo;


// controlador de solicitudes REST


// recibe solicitudes GET, POST, DELETE desde la web

 @RestController

 @RequestMapping("/api/Objetivo")

public class ObjetivosRestController {

@Autowired

Objetivo objetivo;

//GET/trayectos

// Retornar todos los trayectos




// throw new Exception("Funcion no implementada");

}

//GET/trayectos/{id}

// Retornar el trayecto con el id (id)



//POST/trayectos

//GET/trayectos

// Retornar todos los trayectos

//GET/trayectos/(id)