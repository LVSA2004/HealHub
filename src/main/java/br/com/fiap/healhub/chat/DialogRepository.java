package br.com.fiap.healhub.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.healhub.chat.Dialog;

public interface DialogRepository extends JpaRepository<Dialog, Long>{
}
