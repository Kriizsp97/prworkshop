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
    @Column(name = "id_mtkuliah")
    private Integer idMtkuliah;
    @Column(name = "nama")
    private String namaMatkul;

    @ManyToOne()
    @JoinColumn(name = "idDosen")
    private Dosen dosen;

}
