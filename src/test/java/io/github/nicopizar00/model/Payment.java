package io.github.nicopizar00.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Payment {
    String name;
    String country;
    String city;
    String creditCard;
    String month;
    String year;
}
