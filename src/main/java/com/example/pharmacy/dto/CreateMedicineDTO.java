package com.example.pharmacy.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateMedicineDTO {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String name;

    @Min(value = 0, message = "Min 0")
    @Max(value = 18, message = "Max 18")
    private int ageAppropriateness;
}
