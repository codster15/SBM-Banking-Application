package in.sbmbank.FormBinding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class signUpBinding {
    public Integer id;

    public String username;


    public String  password;
}
