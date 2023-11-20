package br.com.fiap.healhub.chat;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Entity
@Data
@Table(name = "TB_HH_CHAT")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String text;
    private Long dialogId;
    private boolean bot;
    private String time;
}
