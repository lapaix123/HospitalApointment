package dev.lapaix.HospitalApointiment.Controller;

import dev.lapaix.HospitalApointiment.model.Nurse;
import dev.lapaix.HospitalApointiment.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nurse")
public class NurseController {
    @Autowired
    private NurseService nurseService;
    @GetMapping("/total")
    public long getTotalNurses() {
        return nurseService.getTotalNurses();
    }
    @PostMapping("/create")
    public ResponseEntity<Nurse> registerNurse(@RequestBody Nurse nurse){
        Nurse creatNurse=nurseService.saveNurse(nurse);
        return new ResponseEntity<>(creatNurse, HttpStatus.CREATED);

    }
@GetMapping("/all")
    public ResponseEntity<List<Nurse>> getAllNurse(){
        List<Nurse> nurses= nurseService.getAllNurses();
        return new ResponseEntity<>(nurses,HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable("id") Long id,@RequestBody Nurse nurse){
        Nurse updateNurse=nurseService.updateNurse(id,nurse);
        if(updateNurse != null){
            return new ResponseEntity<>(updateNurse,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Nurse> deleteNurse(@PathVariable("id") Long id){
        if(nurseService.deleteNurse(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
