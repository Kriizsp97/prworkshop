package com.ist.prworkshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matakuliah")
@Data
public class Mtkuliah {

    @Id
    private Integer id_mtkuliah;
    private String nama;

    @ManyToOne()
    @JoinColumn(name = "id_dosen")
    private Dosen dosen;

}
