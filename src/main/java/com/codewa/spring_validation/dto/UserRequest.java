package com.codewa.spring_validation.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor(staticName = "build")
//staticName="build" a powerful mechanism to create all field constructor and
//a static factory method, this factory method allows you to create instances
//of the class without using new keyword directly
public class UserRequest {
    @NotBlank(message = "name is mandatory")
    private String name;
    @Email @NotNull
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String phone;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
