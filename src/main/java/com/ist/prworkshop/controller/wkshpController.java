package com.ist.prworkshop.controller;

import com.ist.prworkshop.entity.Mahasiswa;
import com.ist.prworkshop.repository.MahasiswaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class wkshpController {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello World";
    }

    @GetMapping("/getAllMhs")
    public ResponseEntity<List<Mahasiswa>> getAllMhs(){
        List<Mahasiswa> result = mahasiswaRepository.findAll();
        if(result == null || result.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/saveMhs")
    public ResponseEntity<Mahasiswa> saveMhs(@RequestBody Mahasiswa mahasiswa){
        try{
            Mahasiswa m = mahasiswaRepository.save(mahasiswa);
            return new ResponseEntity<>(m, HttpStatus.CREATED);
        }catch (Exception e) {
            log.error("Error Saving {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteMhs")
    public ResponseEntity<Integer> deleteMhs(@RequestParam Integer mahasiswaId){
        try{
            mahasiswaRepository.deleteById(mahasiswaId);
            return new ResponseEntity("Deleted",HttpStatus.OK);
        }catch (Exception e){
            log.error("Error Deleting Record {}",e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
