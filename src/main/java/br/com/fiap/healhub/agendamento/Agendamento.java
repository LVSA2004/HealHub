package br.com.fiap.healhub.agendamento;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "TB_HH_AGENDAMENTO")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Data_Desejada;
    private String Unidade;
    private String Horario;
    
}
