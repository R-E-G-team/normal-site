package com.example.reg.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Authorities {

    @Id
    private Long userNo;
    private String authority;
}
