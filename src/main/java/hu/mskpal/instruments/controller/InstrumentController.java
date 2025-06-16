package hu.mskpal.instruments.controller;

import hu.mskpal.instruments.model.Instrument;
import hu.mskpal.instruments.service.InstrumentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instruments")
public class InstrumentController {

    private final InstrumentService service;

    public InstrumentController(InstrumentService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("instruments", service.findAll());
        return "instrument/list";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("instrument", new Instrument());
        return "instrument/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Instrument instrument, BindingResult result) {
        if (result.hasErrors()) return "instrument/form";
        service.save(instrument);
        return "redirect:/instruments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/instruments";
    }
}