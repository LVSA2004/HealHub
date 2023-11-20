package br.com.fiap.healhub.chat;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
@Data
@Table(name = "TB_HH_DIALOG")
public class Dialog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;
}
