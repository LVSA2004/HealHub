package br.com.fiap.healhub.agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.healhub.formulario.Formulario;

import org.springframework.ui.Model;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    MessageSource message;

    @Autowired
    AgendamentoService service;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("username", user.getAttribute("name"));
        model.addAttribute("avatar_url", user.getAttribute("avatar_url"));
        model.addAttribute("agendamentoList", service.findAll());
        return "agendamento/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        if (service.delete(id)){
            redirect.addFlashAttribute("success", message.getMessage("forms.delete.success", null, LocaleContextHolder.getLocale()));
        }else{
            redirect.addFlashAttribute("error",  message.getMessage("forms.notfound", null, LocaleContextHolder.getLocale()));
        }
        return "redirect:/agendamento";
    }

    @GetMapping("new")
    public String form(Agendamento agendamento){
        return "agendamento/form";
    }

    @PostMapping
    public String create(@Valid Agendamento agendamento, BindingResult binding, RedirectAttributes redirect){
        if (binding.hasErrors()) return "/agendamento/form";
        service.save(agendamento);
        redirect.addFlashAttribute("success",  message.getMessage("forms.created.success", null, LocaleContextHolder.getLocale()));
        return "redirect:/agendamento";
    }
    
}
