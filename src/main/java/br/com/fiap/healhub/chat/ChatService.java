package br.com.fiap.healhub.chat;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

import br.com.fiap.healhub.chat.Chat;
import br.com.fiap.healhub.chat.ChatRepository;

@Service
public class ChatService {
    @Autowired
    ChatRepository repository;

    public Chat save(@Valid Chat chat){
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        // Formatando e exibindo a hora atual
        String formatedTime = time.format(formatter);
        chat.setTime(formatedTime);
        repository.save(chat);
        return chat;
    }

    public List<Chat> findAll(){
        return repository.findAll();
    }

    public List<Chat> findByDialogId(Long id){
        return repository.findChatByDialogId(id);
    }
}
