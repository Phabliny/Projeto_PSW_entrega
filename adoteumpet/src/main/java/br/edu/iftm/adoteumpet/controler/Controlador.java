package br.edu.iftm.adoteumpet.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.adoteumpet.model.Usuario;
import br.edu.iftm.adoteumpet.repository.UsuarioRepository;
import br.edu.iftm.adoteumpet.model.Animal;
import br.edu.iftm.adoteumpet.repository.AnimalRepository;

@Controller
public class Controlador {

    @Autowired
    UsuarioRepository repo;

    @Autowired
    AnimalRepository repoAnimal;

    @GetMapping(value = {"/","/home"})
    public String home() {
        return "home";
    }

    @GetMapping(value = "/perfil")
    public String perfil() {
        return "perfil";
    }

    @GetMapping(value = "/contato")
    public String contato() {
        return "contato";
    }

    @GetMapping(value = "/adote")
    public String adote() {
        return "adote";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    @GetMapping("/apoio")
    public String apoio() {
        return "apoio";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // ***************************************** Inicio animais **********************************************/
    
    @GetMapping("/animais")
    String inicioAnimal(Model model){
        List<Animal> animais = repoAnimal.buscaTodosAnimais();
        model.addAttribute("animais", animais);
    return "animais";
    }

    @GetMapping("/cadAnimais")
    String formAnimal(Model model){
        model.addAttribute("animal", new Animal());
        return "cadAnimais";
    }

    /*@PostMapping("/cadAnimais")
    public String cadastroAnimal(Animal animal) {
        repoAnimal.gravaAnimal(animal);
        return "redirect:/animais";
    }*/

    @PostMapping("/cadAnimais")
    public String cadastroAnimail(Animal animal) { System.out.println(">>>>>>>>>>>>>" + animal);
        if (animal.getId() == null)
            repoAnimal.gravaAnimal(animal);
        else
            repoAnimal.atualizaAnimal(animal);
        return "redirect:/animais";
    }

    @GetMapping(value = "/editar-animal")
	public String editarAnimal(@RequestParam(name = "id", required = true) Integer cod, Model model) {
		model.addAttribute("animal", repoAnimal.buscaPorIdAnimal(cod));
		return "cadAnimais";
	}

	@GetMapping(value = "/excluir-animal")
	public String excluirAnimal(@RequestParam(name = "id", required = true) Integer id) {
		repoAnimal.excluirAnimal(id);
		return "redirect:/animais";
    }


    @RequestMapping(value = "/get-adote", method = RequestMethod.GET)
        public String mmensagem(Model model) {
        model.addAttribute("message", "hello");
        return "redirect:/adote";
    }

    // ******************************************* Fim animais ***********************************************

    // ****************************************** Inicio usuario *********************************************
    @RequestMapping("/usuarios")
    String inicio(Model modelo) {
        List<Usuario> usuarios = repo.buscaTodosUsuarios();
        modelo.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/form-usuario")
    String formUsuario(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "form-usuario";
    }

    @PostMapping("/form-usuario")
    public String cadastroUsuario(Usuario usuario) {
        if (usuario.getId() == null)
            repo.gravaUsuario(usuario);
        else
            repo.atualizaUsuario(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping(value = "/editar-usuario")
    public String editarUsuario(@RequestParam(name = "id", required = true) Integer cod, Model modelo) {
        modelo.addAttribute("usuario", repo.buscaPorId(cod));
        return "form-usuario";
    }

    @GetMapping(value = "/excluir-usuario")
    public String excluirUsuario(@RequestParam(name = "id", required = true) Integer id) {
        repo.excluirUsuario(id);
        return "redirect:/usuarios";
    }
    // ***************************************** Fim usuario **********************************************
}
