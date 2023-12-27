package kolotovAD.projectjava.discriptions;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import kolotovAD.projectjava.entity.User;

@Data
@ToString
public class registere {

    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 8, max = 24)
    private CharSequence password;


    public User toEntity() {
        var user = new User();
        user.setUsername(username);
//        user.setPassword(password);
        user.setEnabled(true);
        user.setAuthority("USER");
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonExpired(true);
        return user;
    }

}
