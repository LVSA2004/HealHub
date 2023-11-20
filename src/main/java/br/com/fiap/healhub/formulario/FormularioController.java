package br.com.fiap.healhub.formulario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

    @Autowired
    FormularioService service;

    @Autowired
    MessageSource message;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("username", user.getAttribute("name"));
        model.addAttribute("avatar_url", user.getAttribute("avatar_url"));
        model.addAttribute("formsList", service.findAll());
        return "formulario/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        if (service.delete(id)){
            redirect.addFlashAttribute("success", message.getMessage("forms.delete.success", null, LocaleContextHolder.getLocale()));
        }else{
            redirect.addFlashAttribute("error",  message.getMessage("forms.notfound", null, LocaleContextHolder.getLocale()));
        }
        return "redirect:/formulario";
    }

    @GetMapping("new")
    public String form(Formulario formulario){
        return "formulario/form";
    }

    @PostMapping
    public String create(@Valid Formulario formulario, BindingResult binding, RedirectAttributes redirect){
        if (binding.hasErrors()) return "/formulario/form";
        service.save(formulario);
        redirect.addFlashAttribute("success",  message.getMessage("forms.created.success", null, LocaleContextHolder.getLocale()));
        return "redirect:/formulario";
    }
}
