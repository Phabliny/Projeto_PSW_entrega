package br.edu.iftm.adoteumpet.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.iftm.adoteumpet.model.Animal;
import br.edu.iftm.adoteumpet.repository.AnimalRepository;


public class AnimalControlador {
    @Autowired
    AnimalRepository repo;

	@GetMapping(value="/cadAnimais")
    public String cadastrar() {
        return "cadAnimais";
    }

    @RequestMapping("/cadAnimais")
    String cadastroAnimal (Model model) {
        model.addAttribute("animal", new Animal());
        return "/cadAnimais";
    }

    @RequestMapping (value = "/cadAnimais", method = RequestMethod.POST)
    public String gravarAnimal(Animal animal, RedirectAttributes ra){
        System.out.println(animal.getNome());
        repo.gravaAnimal(animal);
        ra.addFlashAttribute("sucessmensage", "Usuário cadastrado com sucesso!");
        
        return "redirect:/cadAnimais";
    }

	@RequestMapping (value = "/animais", method = RequestMethod.GET)
	public String processaAnimal(Animal animal) {
		if (animal.getId() == null) {
			repo.gravaAnimal(animal);
		} else {
			repo.atualizaAnimal(animal);
		}
		return "redirect:/animais";
	}

	
	@GetMapping(value = "/editar-animal")
	public String editarAnimal(@RequestParam(name = "id", required = true) Integer cod, Model modelo) {
		modelo.addAttribute("animal", repo.buscaPorIdAnimal(cod));
		return "animais";
	}

    @GetMapping(value = "/excluir-animal")
	public String excluirAnimal(@RequestParam(name = "id", required = true) Integer cod) {
		repo.excluirAnimal(cod);
		return "redirect:animais";
	}
    
}