package br.com.fiap.healhub.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long>{
    List<Chat> findChatByDialogId(Long id);
}
