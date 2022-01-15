package br.edu.iftm.adoteumpet.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.iftm.adoteumpet.model.Animal;
import br.edu.iftm.adoteumpet.repository.AnimalRepository;

@Controller
public class AnimalControlador {

	@Autowired
	AnimalRepository repo;

	@RequestMapping(value = "/cadAnimais", method = RequestMethod.POST)
	public String gravarAnimal(Animal animal, RedirectAttributes ra) {
		System.out.println("????????????" + animal.getNome());
		repo.gravaAnimal(animal);
		ra.addFlashAttribute("message", "Animal cadastrado com sucesso!");

		return "redirect:/cadAnimais";
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

	@GetMapping("/animais")
	String inicioAnimal(Model model) {
		List<Animal> animais = repo.buscaTodosAnimais();
		model.addAttribute("animais", animais);
		return "animais";
	}

	@GetMapping("/cadAnimais")
	String formAnimal(Model model) {
		model.addAttribute("animal", new Animal());
		return "cadAnimais";
	}

}