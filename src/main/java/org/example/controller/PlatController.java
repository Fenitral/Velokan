package org.example.controller;

import org.example.entity.Employe;
import org.example.entity.Plat;
import org.example.entity.Plat;
import org.example.service.PlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/plats")
public class PlatController {

    @Autowired
    private PlatService platService;

    // @InitBinder
    // public void initBinder(WebDataBinder binder) {
    //     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //     dateFormat.setLenient(false);
    //     binder.registerCustomEditor(java.util.Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, true));
    // }


    @GetMapping
    public String getAllPlats(Model model) {
        List<Plat> plats = platService.getAllPlats();
        model.addAttribute("plats", plats);
        return "plats";  // Ta vue Thymeleaf par exemple : src/main/resources/templates/plats/list.html
    }

    @GetMapping("/{id}")
    public String getPlatById(@PathVariable int id, Model model) {
        Optional<Plat> plat = platService.getPlatById(id);
        plat.ifPresent(value -> model.addAttribute("plat", value));
        return "plats/detail";  // Exemple de vue détail
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("plat", new Plat());
        return "plats/create";  // Formulaire pour créer un plat
    }

    @PostMapping("/save")
    public String savePlat(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam("intitule") String intitule,
            @RequestParam("prix") Integer prix,
            @RequestParam("dateCreation") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateCreation,
            Model model
            ) {
        
        Plat plat = (id != null) ? platService.getPlatById(id).orElse(new Plat()) : new Plat();
        plat.setIntitule(intitule);
        plat.setPrix(prix);
        plat.setDateCreation(dateCreation);

        platService.savePlat(plat);
        // return "redirect:/plats";
        model.addAttribute("plats_montree", platService.getAllPlats());

        return "plats";
    }

    @GetMapping("/delete/{id}")
    public String deletePlat(@PathVariable("id") Integer id, Model model) {
        platService.deletePlat(id);
        model.addAttribute("succes", "Plat supprimé !");
        model.addAttribute("plats_montree", platService.getAllPlats());
        return "plats";
    }


    @GetMapping("/edit")
    public String modifierPlat(@RequestParam("id") Integer id, Model model) {
        Plat plat = platService.getPlatById(id).orElse(new Plat());
        model.addAttribute("succes", "modification de plat  " + plat.getIntitule() + " !");
        model.addAttribute("plat", plat);
        model.addAttribute("employes", platService.getAllPlats());
        // model.addAttribute("plats", platService.getAllPlats());
        return "plats";  // Formulaire pour modifier un plat

    }

    @GetMapping("/creer_plat")
    public String showCreatePlatForm(Model model) {
        model.addAttribute("plat", new Plat());  // Pour préparer le formulaire
        return "plat/creer_plat";  // Cela redirige vers creer_plat.jsp
    }

}
