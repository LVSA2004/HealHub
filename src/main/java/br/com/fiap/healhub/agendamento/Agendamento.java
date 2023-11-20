package br.com.fiap.healhub.agendamento;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Entity
@Data
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Data_Desejada;
    private String Unidade;
    private String Horario;
    
}
