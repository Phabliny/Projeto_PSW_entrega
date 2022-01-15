package br.edu.iftm.adoteumpet.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.adoteumpet.model.Animal;
import br.edu.iftm.adoteumpet.repository.AnimalRepository;
import br.edu.iftm.adoteumpet.security.MyUserDetails;

@Controller
public class AdocaoController {

    @Autowired
    AnimalRepository repo;

    @GetMapping("/adote")
    public String adote(Model modelo) {
        List<Animal> lista = repo.buscaAnimaisEmAdocao();
        if (lista.size() == 0)
            return "aviso";
        modelo.addAttribute("listaDeAnimais", lista);
        return "adote";
    }

    @GetMapping("/solicita-adocao/{id}")
    public String solicitaAdocao(@PathVariable Integer id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer usuarioID = ((MyUserDetails) principal).getUsuarioId();

        System.out.println("------------------> id usuario: " + usuarioID);
        System.out.println("------------------> id animal: " + id);
        repo.atualizaAdocao(id, usuarioID);
        return "redirect:/adote";
    }

    @GetMapping("/confirmar-adocao")
    public String confirmaAdocao(@RequestParam(name = "id", required = true) Integer id) {
        repo.confirmaAdocao(id);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/cancelar-adocao")
    public String camcelaAdocao(@RequestParam(name = "id", required = true) Integer id) {
        repo.cancelaAdocao(id);
        return "redirect:/usuarios";
    }

}
