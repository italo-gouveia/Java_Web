package br.com.italo.springrest.avaliacaodesoftware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.italo.springrest.avaliacaodesoftware.domain.Usuario;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "redirect:/usuario/todos";
		//return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String cadastro() {
		return "/user/index";
	}
}
