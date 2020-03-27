package com.eventosapp.controllers;

import com.eventosapp.acessingdatamysql.ConvidadoRepository;
import com.eventosapp.acessingdatamysql.EventoRepository;
import com.eventosapp.models.Convidado;
import com.eventosapp.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoRepository cr;

    @RequestMapping(value="/cadastrarEvento", method= RequestMethod.GET)
    public String form() {
        return "evento/formEvento";
    }

    @RequestMapping(value="/cadastrarEvento", method= RequestMethod.POST)
    public String form(Evento evento) {

        er.save(evento);//salvando evento no banco
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");

        //fazer busca da lista no banco
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    //busca de evento específico utilizando o código do evento
    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);

        Iterable<Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados", convidados);
        return mv;
    }

    //método para salvar o convidado do evento no banco de dados
    @RequestMapping(value="/{codigo}", method=RequestMethod.POST)
    public String detalhesEventoPOST(@PathVariable("codigo") long codigo, Convidado convidado){
        Evento evento = er.findByCodigo(codigo);
        convidado.setEvento(evento); //convidado relacionado com evento
        cr.save(convidado);
        return "redirect:/{codigo}";
    }


}
