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
import mx.utng.ultima.model.entity.Departamento;
import mx.utng.ultima.model.service.IDepartamentoService;



@Controller
@SessionAttributes("departamento")
public class DepartamentoController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IDepartamentoService departamentoService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/departamento/list","/departamento","/departamento/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Departamentos");
    model.addAttribute("departamentos", departamentoService.list());
    return "dlist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/departamento/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Departamentos");
        model.addAttribute("departamento", new Departamento());
        return "dform";
    }

    @GetMapping("/departamento/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Departamento departamento = null;
        if (id>0) {
            departamento = departamentoService.getById(id);
        }else{
            return "redirect:dlist";
        }

        model.addAttribute("title", "Editar Departamento");
        model.addAttribute("departamento", departamento);
        return "dform";
    }

    @PostMapping ("/departamento/form")
    public String save(@Valid Departamento departamento, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Departamentos");
            return "dform";
        }

        departamentoService.save(departamento);
        return "redirect:/departamento/list";
    }

    @GetMapping("/departamento/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            departamentoService.delete(id);
        }
        return "redirect:/departamento/list";
    }
}



