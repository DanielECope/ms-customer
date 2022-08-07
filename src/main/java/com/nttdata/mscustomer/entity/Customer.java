package com.nttdata.mscustomer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Document("customerdb") //BASE DE DATOS - ACCESO DE DATOS - DAO
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    @Id
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

    @Valid
    private String typeCustomer;

    @NotNull
    private String document;

    @NotNull
    private String age;

}
