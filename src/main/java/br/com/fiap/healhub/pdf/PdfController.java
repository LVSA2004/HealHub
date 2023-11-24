package br.com.fiap.healhub.pdf;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    PdfService service;


    @GetMapping("/new/{id}")
    public String createPdf(@PathVariable Long id) throws IOException{
        service.createPdf(id);

        return "redirect:/formulario";
    }
}
