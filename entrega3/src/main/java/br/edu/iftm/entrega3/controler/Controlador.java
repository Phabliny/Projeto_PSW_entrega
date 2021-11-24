package br.edu.iftm.entrega3.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.entrega3.model.Usuario;
import br.edu.iftm.entrega3.repository.UsuarioRepository;

@Controller
public class Controlador {

    @Autowired  
    UsuarioRepository repo;

    @GetMapping(value="/home")
    public String home() {
        return "home";
    }

    @GetMapping(value="/perfil")
    public String perfil() {
        return "perfil";
    }

    @GetMapping(value="/contato")
    public String contato() {
        return "contato";
    }

    @GetMapping(value="/adote")
    public String adote() {
        return "adote";
    }

    @GetMapping("/sobre")
    public String sobre(){
        return "sobre";
    }

    @GetMapping("/apoio")
    public String apoio(){
        return "apoio";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/cadAnimais")
    public String cadAnimais(){
        return "cadAnimais";
    }

    @RequestMapping("/usuarios")
    String inicio(Model modelo){
        List<Usuario> usuarios = repo.buscaTodosUsuarios();
        modelo.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/form-usuario")
    String formUsuario(Model modelo){
        modelo.addAttribute("usuario", new Usuario());
        return "form-usuario";
    }

    @PostMapping("/form-usuario")
    public String cadastroUsuario(Usuario usuario) {
        repo.gravaUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping(value = "/editar-usuario")
	public String editarProfessor(@RequestParam(name = "id", required = true) Integer cod, Model modelo) {
		modelo.addAttribute("usuario", repo.buscaPorId(cod));
		return "form-usuario";
	}

	@GetMapping(value = "/excluir-usuario")
	public String excluirProfessor(@RequestParam(name = "id", required = true) Integer id) {
		repo.excluirUsuario(id);
		return "redirect:/usuarios";
	}

}
