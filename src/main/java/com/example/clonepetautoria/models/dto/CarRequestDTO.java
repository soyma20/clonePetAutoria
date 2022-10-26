package com.example.clonepetautoria.models.dto;

import com.example.clonepetautoria.models.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDTO {
    private String description;
    private int year;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private Currency currency;
}
