package com.ist.prworkshop.controller;

import com.ist.prworkshop.entity.Dosen;
import com.ist.prworkshop.entity.Mahasiswa;
import com.ist.prworkshop.entity.Mtkuliah;
import com.ist.prworkshop.repository.DosenRepository;
import com.ist.prworkshop.repository.MahasiswaRepository;
import com.ist.prworkshop.repository.MtkuliahRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class wkshpController {

    @Autowired private MahasiswaRepository mahasiswaRepository;
    @Autowired private DosenRepository dosenRepository;
    @Autowired private MtkuliahRepository mtkuliahRepository;

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

    @GetMapping("/getAllMtkuliah")
    public ResponseEntity<List<Mtkuliah>> getAllMtkuliah(){
        List<Mtkuliah> result = mtkuliahRepository.findAll();
        if(result == null || result.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAllDosen")
    public ResponseEntity<List<Dosen>> getAllDosen(){
        List<Dosen> result = dosenRepository.findAll();
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

    @PostMapping("/saveDosen")
    public ResponseEntity<Dosen> saveDosen(@RequestBody Dosen dosen){
        try{
            Dosen d = dosenRepository.save(dosen);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        }catch (Exception e) {
            log.error("Error Saving {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveMtkuliah")
    public ResponseEntity<Mtkuliah> saveMtkuliah(@RequestBody Mtkuliah mtkuliah){
        try{
            Mtkuliah mt = mtkuliahRepository.save(mtkuliah);
            return new ResponseEntity<>(mt, HttpStatus.CREATED);
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

    @DeleteMapping("/deleteDosen")
    public ResponseEntity<Integer> deleteDosen(@RequestParam Integer dosenId){
        try{
            dosenRepository.deleteById(dosenId);
            return new ResponseEntity("Deleted",HttpStatus.OK);
        }catch (Exception e){
            log.error("Error Deleting Record {}",e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteMtkuliah")
    public ResponseEntity<Integer> deleteMtkuliah(@RequestParam Integer mtkuliahId){
        try{
            mtkuliahRepository.deleteById(mtkuliahId);
            return new ResponseEntity("Deleted",HttpStatus.OK);
        }catch (Exception e){
            log.error("Error Deleting Record {}",e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
