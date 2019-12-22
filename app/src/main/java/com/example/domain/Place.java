package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Place {

    public String name;
    public String imageName;
    public String popup;
}