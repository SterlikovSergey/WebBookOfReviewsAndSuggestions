package by.sterlikov.webbookofreviewsandsuggestions.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {

    private String login;
    private String eMail;
    private String message;
}
