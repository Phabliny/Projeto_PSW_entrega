package br.edu.iftm.adoteumpet.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.iftm.adoteumpet.model.Usuario;
import br.edu.iftm.adoteumpet.repository.UsuarioRepository;

public class UsuarioControlador {
    
    @Autowired
    UsuarioRepository repo;

	@RequestMapping ("/form-usuario")
    String cadastroAluno(Model model){
        model.addAttribute("usuario", new Usuario());
        return "form-usuario";
    }

	@RequestMapping (value = "/form-usuario", method = RequestMethod.POST)
    public String gravarUsuario(Usuario usuario, RedirectAttributes ra){
        System.out.println(usuario.getCpf().length());
        if(usuario.getCpf().length() != 11){
            ra.addFlashAttribute("dangermensage", "CPF INVALIDO!");
        }else {
            repo.gravaUsuario(usuario);
            ra.addFlashAttribute("sucessmensage", "Usuário cadastrado com sucesso!");
        }
        return "redirect:/form-usuario";
    }

	@RequestMapping (value = "/usuarios", method = RequestMethod.GET)
	public String processaForm(Usuario usuario) {
		if (usuario.getId() == null) {
			repo.gravaUsuario(usuario);
		} else {
			repo.atualizaUsuario(usuario);
		}
		return "redirect:/usuarios";
	}

	
	@GetMapping(value = "/editar-usuario")
	public String editarUsuario(@RequestParam(name = "id", required = true) Integer cod, Model modelo) {
		modelo.addAttribute("usuario", repo.buscaPorId(cod));
		return "usuarios";
	}
}
