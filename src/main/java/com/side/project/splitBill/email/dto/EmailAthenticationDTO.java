package com.side.project.splitBill.email.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailAthenticationDTO {

    String userEmail;
    Integer athenticationNumber;

}
