package com.gestaofesta.gestaofesta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gestaofesta.gestaofesta.Models.Convidado;
import com.gestaofesta.gestaofesta.Repository.ConvidadoRepository;

@Controller
public class formController {
	
	@Autowired
	private ConvidadoRepository cr;

	@RequestMapping(value="/cad", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="/cad", method = RequestMethod.POST)
	public String form(Convidado convidado) {
		cr.save(convidado);
		return "redirect:/cad";
	}
	
	@RequestMapping("/lista")
	public ModelAndView Lista() {
		ModelAndView mv = new ModelAndView("/index");
		Iterable<Convidado>convidados = cr.findAll();
		mv.addObject("convidados", convidados);
		return mv;
	}
}
