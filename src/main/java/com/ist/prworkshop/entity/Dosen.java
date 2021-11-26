package com.ist.prworkshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dosen")
@Data
public class Dosen {

    @Id
    private Integer id_dosen;
    private String nama;

    @OneToMany(mappedBy = "dosen")
    @JsonBackReference
    private List<Mtkuliah> mtkuliahs;
}
