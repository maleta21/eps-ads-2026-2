package br.edu.fatecfranca.api.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Digits;

public record CarRequest(
   @NotBlank(message = "A marca é obrigatória.")
   String brand,

   @NotBlank(message = "O modelo é obrigatório.")
   String model,

   @NotBlank(message = "A cor é obrigatória")
   String color,
  
   @NotBlank(message = "Ano Obrigatório.")
   @Positive(message = "O ano deve ser maior que zero.")
   Long yearManufacture,

   @NotBlank(message = "Deve informar true ou false.")
   Boolean imported,

   @NotBlank(message = "A Placa é obrigatória.")
   @Pattern(
       regexp = "[ABC-1234][ABC1D23]",
       message = "A Placa deve conter uma formatação válida."
   )
   String plates,

   @PastOrPresent(
       message = "A data não pode estar no futuro."
   )
   LocalDate sellingDate,

   @Positive(message = "O preço de venda deve ser maior que zero.")
   @Digits(integer = 10, fraction = 2)
   BigDecimal sellingPrice,

   @Positive(message = "O ID do cliente deve ser maior que zero.")
   Long customerId
) {}

