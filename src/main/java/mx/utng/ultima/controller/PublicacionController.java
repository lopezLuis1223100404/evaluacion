package mx.utng.ultima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.ultima.model.entity.Publicacion;
import mx.utng.ultima.model.service.IPublicacionService;



@Controller
@SessionAttributes("publicacion")
public class PublicacionController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IPublicacionService publicacionService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/publicacion/list","/publicacion","/publicacion/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Publicaciones de red social");
    model.addAttribute("publicaciones", publicacionService.list());
    return "plist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/publicacion/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Publicaciones");
        model.addAttribute("publicacion", new Publicacion());
        return "pform";
    }

    @GetMapping("/publicacion/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Publicacion publicacion = null;
        if (id>0) {
            publicacion = publicacionService.getById(id);
        }else{
            return "redirect:plist";
        }

        model.addAttribute("title", "Editar Publicacion");
        model.addAttribute("publicacion", publicacion);
        return "pform";
    }

    @PostMapping ("/publicacion/form")
    public String save(@Valid Publicacion publicacion, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Publicaciones");
            return "pform";
        }

        publicacionService.save(publicacion);
        return "redirect:/publicacion/list";
    }

    @GetMapping("/publicacion/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            publicacionService.delete(id);
        }
        return "redirect:/publicacion/list";
    }

}



