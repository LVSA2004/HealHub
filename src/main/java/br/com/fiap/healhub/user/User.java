package br.com.fiap.healhub.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.oauth2.core.user.OAuth2User;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    String email_id;
    String name;
    String password;
    String telefone;
    String avatarUrl;
    String mail;

    public static User convert(OAuth2User oAuth2User){
        return new UserBuilder()
                .email_id(oAuth2User.getAttribute("mail"))
                .name(oAuth2User.getAttribute("name"))
                .avatarUrl(oAuth2User.getAttribute("avatar_url"))
                .build();

    }
}
