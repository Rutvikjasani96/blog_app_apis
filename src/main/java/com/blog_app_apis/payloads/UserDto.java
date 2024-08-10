package com.blog_app_apis.payloads;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    @NotEmpty
    @Size(min = 4, message = "Minimum 4 Characters are required!")
    private String name;
    @NotEmpty(message = "E-mail is Empty, Please fill it!")
    @Email(message = "invalid E-mail!")
    private String email;
    @NotEmpty
    @Size(min = 4, max = 12, message = "Password must be contains 4 to 12 Characters")
    private String password;
    @NotEmpty(message = "about is Empty, it's invalid!")
    private String about;

    private List<CommentDto> comments = new ArrayList<>();

}
