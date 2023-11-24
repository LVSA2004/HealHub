package br.com.fiap.healhub.pdf;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.healhub.formulario.FormularioRepository;
import br.com.fiap.healhub.formulario.FormularioService;

@Service
public class PdfService {

    @Autowired
    FormularioRepository formularioRepository;
    
    public void createPdf(Long id) throws IOException{
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        var formulario = formularioRepository.findById(id).get();

        LocalDateTime data = LocalDateTime.now();

        String formatedData = data.format(DateTimeFormatter.ofPattern("HH-mm-ss"));

       

        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
        contentStream.beginText();
        contentStream.newLineAtOffset(10, 700);
        contentStream.showText("Seguro:" + formulario.getNum_seg_saude());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Companhia: " + formulario.getCompanhia_seg_saude());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Alergia: " + formulario.getAlergias());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Condições Médicas: " + formulario.getCondicoes_medicas());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Cirurgias: " + formulario.getCirurgias());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Medicamentos: " + formulario.getMedicamentos());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Razão da Visita: " + formulario.getRazao_visita());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Horario dos Sintomas: " + formulario.getHorario_sintomas());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Historico de Problemas: " + formulario.getHistorico_problemas());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Historico Familiar: " + formulario.getHist_familiar());
        contentStream.newLineAtOffset(0, -50);
        contentStream.showText("Doenças geneticas: " + formulario.getDoencas_geneticas());
        contentStream.endText();
        contentStream.close();

        document.save("C:\\Users\\Administrator\\Downloads\\formulario-" + formulario.getId() + "-" + formatedData + ".pdf");
        document.close();
    }
    
    }
