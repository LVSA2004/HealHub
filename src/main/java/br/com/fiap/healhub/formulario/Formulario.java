package br.com.fiap.healhub.formulario;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "TB_HH_FORMULARIO")
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Campo Número do Seguro de Saúde é obrigatório")
    private String num_seg_saude;

    @NotBlank(message = "O Campo Companhia do Seguro de Saúde é obrigatório")
    private String companhia_seg_saude;

    @NotBlank(message = "O Campo Alergias é obrigatório")
    private String alergias;

    @NotBlank(message = "O Campo Condições Médicas Pré-existentes é obrigatório")
    private String condicoes_medicas;

    @NotBlank(message = "O Campo Cirurgias Realizadas é obrigatório")
    private String cirurgias;

    @NotBlank(message = "O Campo Medicamentos Frequentes é obrigatório")
    private String medicamentos;

    @NotBlank(message = "O Campo Razão da Visita é obrigatório")
    private String razao_visita;

    @NotBlank(message = "O Campo Horário de Inicio dos Sintomas é obrigatório")
    private String horario_sintomas;

    @NotBlank(message = "O Campo Histórico de Problemas Médicos é obrigatório")
    private String historico_problemas;

    @NotBlank(message = "O Campo Histórico de Doenças na Família é obrigatório")
    private String hist_familiar;

    @NotBlank(message = "O Campo Doenças Genéticas é obrigatório")
    private String doencas_geneticas;

}
