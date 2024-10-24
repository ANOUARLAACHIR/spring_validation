package com.codewa.spring_validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor(staticName = "build")
//staticName="build" a powerful mechanism to create all field constructor and
//a static factory method, this factory method allows you to create instances
//of the class without using new keyword directly
public class UserRequest {
    private String name;
    private String email;
    private String phone;
    private String gender;
    private int age;
    private String nationality;
}
