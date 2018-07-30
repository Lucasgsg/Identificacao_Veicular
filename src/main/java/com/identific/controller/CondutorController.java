package com.identific.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.identific.model.Condutor;
import com.identific.model.Localidade;
import com.identific.model.Veiculo;
import com.identific.repository.CondutorRepository;
import com.identific.repository.CrRepository;
import com.identific.repository.LocalidadeRepository;
import com.identific.repository.VeiculoRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = {"/condutor"})
public class CondutorController {

    @Autowired
    private CondutorRepository condutorRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;
    
    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Autowired
    private CrRepository crRepository;

    public CondutorController(CondutorRepository condutorRepository, VeiculoRepository veiculoRepository, LocalidadeRepository localidadeRepository, CrRepository crRepository) {
        this.condutorRepository = condutorRepository;
        this.veiculoRepository = veiculoRepository;
        this.localidadeRepository = localidadeRepository;
        this.crRepository = crRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("condutor", new Condutor());
        model.addAttribute("condutors", condutorRepository.findAll());
        return "condutor/listar";
    }

    @GetMapping("/editar")
    public String edit(Model model, @RequestParam Long cnh) {
        model.addAttribute("condutor", condutorRepository.findOne(cnh));
        model.addAttribute("veiculos", veiculoRepository.findAll());
        model.addAttribute("crs", crRepository.findAll());
        return "condutor/formulario";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("condutor", new Condutor());
        model.addAttribute("veiculos", new Veiculo());
        model.addAttribute("crs", crRepository.findAll());
        return "condutor/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(Condutor condutor, BindingResult bindingResult, RedirectAttributes attributes) {
        if(bindingResult.hasErrors()){
			return "redirect:";
		}
        condutorRepository.save(condutor);
        return "redirect:";
        
    }
    
    @GetMapping("/excluir")
    public String excluir(Model model, @RequestParam Long cnh) {
        condutorRepository.delete(cnh);
        return "redirect:";
    }
        
    @RequestMapping(value = "/{cnh}", method = RequestMethod.GET)
    public ModelAndView listaVeiculos(@PathVariable("cnh") long cnh) {
        Condutor condutor = condutorRepository.findByCnh(cnh);
        ModelAndView mv = new ModelAndView("veiculo/ListaVeiculos");
        mv.addObject("condutor", condutor);

        Iterable<Veiculo> veiculos = veiculoRepository.findByCondutor(condutor);
        mv.addObject("veiculos", veiculos);
        return mv;
    }

    @RequestMapping(value = "/{cnh}", method = RequestMethod.POST)
    public String listaVeiculosPost(@PathVariable("cnh") long cnh, @Valid Condutor condutor,@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "redirect:{cnh}";
        }
        Condutor condutors = condutorRepository.findByCnh(cnh);
        veiculo.setCondutor(condutors);
        veiculoRepository.save(veiculo);
        return "redirect:{cnh}";
    }
    
    @RequestMapping("/deletarVeiculo")
	public String deletarVeiculo(Long id){
		Veiculo veiculo = veiculoRepository.findById(id);
		veiculoRepository.delete(veiculo);
		
		Condutor condutor = veiculo.getCondutor();
		long cnhLong = condutor.getCnh();
		String cnh = "" + cnhLong;
		return "redirect:" + cnh;
	}
}
