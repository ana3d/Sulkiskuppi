package fi.antti.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.antti.spring.bean.Ottelu;
import fi.antti.spring.bean.Pelaaja;
import fi.antti.spring.bean.Piste;
import fi.antti.spring.dao.OttelutDAO;
import fi.antti.spring.dao.PelaajaDAO;
import fi.antti.spring.dao.PisteDAO;


@Controller
@RequestMapping(value = "/secure")
public class SecureController {
	
	final static Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Inject
	private PelaajaDAO pdao;
	
	public PelaajaDAO getDao() {
		return pdao;
	}

	public void setDao(PelaajaDAO pdao) {
		this.pdao = pdao;
	}
	
	@Inject
	private OttelutDAO odao;
	
	public OttelutDAO getODao() {
		return odao;
	}

	public void setODao(OttelutDAO odao) {
		this.odao = odao;
	}
	
	@Inject
	private PisteDAO pidao;
	
	public PisteDAO getpDao() {
		return pidao;
	}

	public void setpDao(PisteDAO pidao) {
		this.pidao = pidao;
	}
	
	
	
	

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String paasivu(@ModelAttribute(value="pelaaja") @Valid Pelaaja pelaaja, BindingResult result, Model model) {
		
		
		
		List<Pelaaja> pelaajat = pdao.haeKaikki();
		List<Ottelu> ottelut = odao.haeKaikki();
		List<Piste> pisteet = pidao.haePisteLista();
		model.addAttribute("pelaajat", pelaajat);
		model.addAttribute("ottelut", ottelut);
		model.addAttribute("pisteet", pisteet);
		logger.info("Haettu kaikki pelaajat & ottelut tietokannasta");
		
		return "secure/main";
	}
	
	@RequestMapping(value = "/lisaaUusiPelaaja", method = RequestMethod.GET)
	public String lisaaPelaajaGET( @ModelAttribute(value="pelaaja") @Valid Pelaaja pelaaja, BindingResult result, Model model) {
		
			return "secure/lisaaUusiPelaaja";

	}	
	
	@RequestMapping(value = "/lisaaUusiPelaaja", method = RequestMethod.POST)
	public String lisaaPelaaja( @ModelAttribute(value="pelaaja") @Valid Pelaaja pelaaja, BindingResult result, Model model) {
		
		
		if (result.hasErrors()) {
			
			logger.info("Joku kentt‰ ei mennyt l‰pi validoinnista");
			return "secure/lisaaUusiPelaaja";
		} else {
			pdao.talleta(pelaaja);
			
			List<Pelaaja> pelaajat = pdao.haeKaikki();
			List<Ottelu> ottelut = odao.haeKaikki();
			List<Piste> pisteet = pidao.haePisteLista();
			model.addAttribute("pelaajat", pelaajat);
			model.addAttribute("ottelut", ottelut);
			model.addAttribute("pisteet", pisteet);
			logger.info("Haettu kaikki pelaajat & ottelut tietokannasta");
			logger.info("Lis‰‰ uusi paino nappia on painettu. Tuupataan tietokantaan");
			return "secure/main";
		}
	}
	
	
	@RequestMapping(value = "/lisaa", method = RequestMethod.GET)
	public String lisaaOttelu(Model model, Ottelu ottelu, BindingResult result) {
		
		List<Pelaaja> pelaajat = pdao.haeKaikki();
		List<Ottelu> ottelut = odao.haeKaikki();
		model.addAttribute("pelaajat", pelaajat);
		model.addAttribute("ottelut", ottelut);
		logger.info("Haettu kaikki pelaajat & ottelut tietokannasta");
		
		return "secure/lisaa";
	}
	
	@RequestMapping(value="/lisaa", method=RequestMethod.POST)
	public String tallennaOttelu( @ModelAttribute(value="ottelu") @Valid Ottelu ottelu, BindingResult result, Model model) {
				
		if (result.hasErrors()) {
			List<Pelaaja> pelaajat = pdao.haeKaikki();
			List<Ottelu> ottelut = odao.haeKaikki();
			model.addAttribute("pelaajat", pelaajat);
			model.addAttribute("ottelut", ottelut);
			logger.info("Haettu kaikki pelaajat & ottelut tietokannasta");
			logger.info("Joku kentt‰ ei mennyt l‰pi validoinnista");
			return "secure/lisaa";
		} else {
			odao.talleta(ottelu);
			List<Pelaaja> pelaajat = pdao.haeKaikki();
			List<Ottelu> ottelut = odao.haeKaikki();
			List<Piste> pisteet = pidao.haePisteLista();
			model.addAttribute("pelaajat", pelaajat);
			model.addAttribute("ottelut", ottelut);
			model.addAttribute("pisteet", pisteet);
			logger.info("Haettu kaikki pelaajat & ottelut tietokannasta");
			logger.info("Lis‰‰ uusi paino nappia on painettu. Tuupataan tietokantaan");
			return "secure/main";
		}
	}
	
	
	

}