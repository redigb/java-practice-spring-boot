package com.rdred.apirestfull.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Todo en getter y seters
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Greeting {
    private long id;
    private String content;
}
