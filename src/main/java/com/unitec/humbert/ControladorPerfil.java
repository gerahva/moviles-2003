
package com.unitec.humbert;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author humbe
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControladorPerfil {
    
    //Esta es la inversión de control o inyección de dependencias
    @Autowired RepoPerfil repoPerfil;
    
    @GetMapping("/hola")
    public Saludo saludar (){
        
        Saludo s=new Saludo();
        s.setNombre("Gerardo");
        s.setMensaje("MI PRIMER MENSAJE EN SPRING REST");
        return s;
    }
    
    //El siguiente metodo servira para guardar en el back end nuestros datos
    //Para guardar siempre se debe usar el método POST
    
    @PostMapping("/perfil")
    public Estatus guardar(@RequestBody String json )throws Exception{
        
        //paso 1 para recibir ese objeto json , leerlo y convertirlo en objeto java 
       // a esto se le llama descerializacion 
        
        
        ObjectMapper maper=new ObjectMapper();
        Perfil perfil= maper.readValue(json, Perfil.class);
        
        //por expericnia antes de guardar tenemos que checar que llegue bien el objeto y se leyo bien
        
        
        System.out.println("Perfil leido"+perfil);
        //este objeto perfil despues se guarda con una sola linea en mongo db
       //aqui va a ir la linea para guardar
       
       repoPerfil.save(perfil);
        
        //despues enviamos un mensaje de estatus al cliente para que se informe si se guardo o no el perfil
        
        Estatus e=new Estatus();
        e.setSuccess(true);
        e.setMensaje("perfil guardado con exito");
        return e;
        
        
    }
    
    //vamos a generar un servicio para actualizar un perfil
    
    @PutMapping("/perfil")
    public Estatus actualizar (@RequestBody String json )throws Exception{
        
         
        ObjectMapper maper=new ObjectMapper();
        Perfil perfil= maper.readValue(json, Perfil.class);
    
      //por expericnia antes de guardar tenemos que checar que llegue bien el objeto y se leyo bien
        
        
        System.out.println("Perfil leido"+perfil);
        //este objeto perfil despues se guarda con una sola linea en mongo db
       //aqui va a ir la linea para guardar
       
       repoPerfil.save(perfil);
        
        //despues enviamos un mensaje de estatus al cliente para que se informe si se guardo o no el perfil
        
        Estatus e=new Estatus();
        e.setSuccess(true);
        e.setMensaje("perfil guardado con exito");
        return e;
        
        
    
}
    
    //Método para borrar un perfil
    
    @DeleteMapping("/perfil/{id}")
    public Estatus borrar(@PathVariable String id){
       //invocamos el repositorio
       
       repoPerfil.deleteById(id);
        
       //Generamos el mensaje de estatus para que este infromado el cliente
       Estatus e=new Estatus();
       e.setMensaje("Perfil borrado con éxito");
       e.setSuccess(true);
       return e;
        
    }
    
    //Método para BUSCAR TODOS
    
    @GetMapping("/perfil")
    public List<Perfil> buscarTodos(){
        return repoPerfil.findAll();
        
    }
    
    //Finalmente para buscar por un ID
    
    @GetMapping("perfil/{id}")
    public Perfil buscarPorId(@PathVariable String id){
        return repoPerfil.findById(id).get();
    }
    
}
    
//A este tipo de controlador estilo REST es muy poderoso y se usa en todas las arquitecturas estilo REST y se denomina CONTRUCCION DE APIS

//API=Aplication Programming Interface(la interface en este caso es la unión entre el cliente (Android) y el servidor (java)
