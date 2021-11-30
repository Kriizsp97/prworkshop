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
    @Column(name = "id_dosen")
    private Integer idDosen;
    @Column(name = "nama")
    private String namaDosen;

    @OneToMany(mappedBy = "dosen")
    @JsonBackReference
    private List<Mtkuliah> mtkuliahs;
}
