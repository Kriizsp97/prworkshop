package com.ist.prworkshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "mhs")
@Data
public class Mahasiswa {

    @Id
    @Column(name = "id_mhs")
    private Integer idMhs;
    private String nama;
    private Integer sem;

    @OneToOne
    @JoinColumn(name = "idMtkuliah")
    private Mtkuliah mtkuliah;
}
