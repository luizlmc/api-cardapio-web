package br.com.luizlmc.apicardapioweb.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    @NotEmpty(message = "Nome é obrigatório")
    @Size(min = 3, max = 20)
    private String name;
}
