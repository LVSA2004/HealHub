package br.com.fiap.healhub.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService service;

    @Autowired
    DialogService dialogService;

    @Autowired
    ChatGPTService chatService;

    @GetMapping
    public String index(Model model, Chat chat){

        model.addAttribute("dialogList", dialogService.findAll());
        return "chat/index";
    }

    @PostMapping
    public String create(@Valid Chat chat, BindingResult result, RedirectAttributes redirect) throws Exception{
        if (result.hasErrors()) {
            return "chat/index";
        }
        chat.setBot(false);
        Dialog dialog = dialogService.save(chat.getText());
        chat.setDialogId(dialog.getId());
        // Chame chatGPT e crie a mensagem do bot
        String botResponse = ChatGPTService.chatGPT(chat.getText());
        Chat message = service.save(chat);
        Chat botMessage = new Chat();
        botMessage.setBot(true);
        botMessage.setText(botResponse);
        botMessage.setDialogId(dialog.getId());
        service.save(botMessage);
        return "redirect:/chat/" + message.getDialogId();

    }

    @GetMapping("/{dialogId}")
    public String getDialogMessages(@PathVariable Long dialogId, Model model, Chat chat){

        Long myId = dialogId;
        model.addAttribute("chatList", service.findByDialogId(dialogId));
        model.addAttribute("dialogList", dialogService.findAll());
        model.addAttribute("dialogId", myId);
        return "dialog/index";
    }

    @PostMapping("/{dialogId}")
    public String postDialogMessages(@PathVariable Long dialogId, Chat chat) throws Exception{

        Chat botMessage = new Chat();
        botMessage.setBot(true);
        botMessage.setText(ChatGPTService.chatGPT(chat.getText()));
        chat.setBot(false);
        chat.setDialogId(dialogId);
        botMessage.setDialogId(dialogId);
        service.save(chat);
        service.save(botMessage);
        return "redirect:/chat/" + dialogId;

    }
}
