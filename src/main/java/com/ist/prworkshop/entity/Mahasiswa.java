package com.ist.prworkshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "mhs")
@Data
public class Mahasiswa {

    @Id
    private Integer id_mhs;
    private String nama;
    private Integer sem;

    @OneToOne
    @JoinColumn(name = "id_mtkuliah")
    private Mtkuliah mtkuliah;
}
