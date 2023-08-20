package mate.academy.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mate.academy.quiz.model.Role;

import javax.validation.constraints.Email;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @Email
    private String email;
    private String password;
    private String name;
    private String surname;
    private Date createDate;
    private int block;
    private Role role;
}
