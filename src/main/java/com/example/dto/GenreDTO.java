package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Introspected
@Data
@NoArgsConstructor
public class GenreDTO {
    @NotBlank
    private String name;
}
