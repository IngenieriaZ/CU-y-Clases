package com.bicicletas.objetivo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bicicletas.objetivo.modelo.Objetivo;
import org.springframework.web.bind.annotation.RequestParam;




@RestController


public class Ejemplo {

    @GetMapping("/api/ejemplo")

    List<Objetivo> objetivos = new ArrayList<Objetivo>();

    public List<Objetivo> todos(
        return objetivos;
    )

    @PostMapping("/api/ejemplo")

    public Integer grabar(@RequestBody Objetivo nuevo){
        objetivos.add(nuevo);
        return objetivos.size()-1;
    }
        

    @GetMapping("/api/ejemplo/{id}")
   
    public Objetivo objetivoxindice(@PathVariable Integer id){
        return objetivos.get((id));
    }

    @PutMapping("/api/ejemplo/{id}")

    public Integer modificarObjetivoxindice(@PathVariable Integer id,@RequestBody Objetivo nuevo ){
        objetivos.set(id, nuevo);
    }

    @DeleteMapping("/api/ejemplo/{id}")
    
    public Integer eliminarToo(@PathVariable Integer id){
        objetivos.remove(objetivos.get(id));
        return 0;
    }
}



