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
import mx.utng.ultima.model.entity.Estudiante;
import mx.utng.ultima.model.service.IEstudianteService;



@Controller
@SessionAttributes("estudiante")
public class EstudianteController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IEstudianteService estudianteService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/estudiante/list","/estudiante","/estudiante/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Estudiantes");
    model.addAttribute("estudiantes", estudianteService.list());
    return "slist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/estudiante/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Estudiantes");
        model.addAttribute("estudiante", new Estudiante());
        return "sform";
    }

    @GetMapping("/estudiante/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Estudiante estudiante = null;
        if (id>0) {
            estudiante = estudianteService.getById(id);
        }else{
            return "redirect:slist";
        }

        model.addAttribute("title", "Editar Estudiante");
        model.addAttribute("estudiante", estudiante);
        return "sform";
    }

    @PostMapping ("/estudiante/form")
    public String save(@Valid Estudiante estudiante, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Estudiantes");
            return "sform";
        }

        estudianteService.save(estudiante);
        return "redirect:/estudiante/list";
    }

    @GetMapping("/estudiante/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            estudianteService.delete(id);
        }
        return "redirect:/estudiante/list";
    }

}



