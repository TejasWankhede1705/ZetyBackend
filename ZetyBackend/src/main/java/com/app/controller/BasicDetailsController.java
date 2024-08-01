package com.app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.entity.BesicDetails;
import com.app.service.BasicDetailsService;

@RestController
@RequestMapping("users")
public class BasicDetailsController {

    @Autowired
    private BasicDetailsService basicDetailsService;

    @PostMapping("/addDetails")
    public ResponseEntity<?> addUsersDetails(@RequestBody BesicDetails details) {
        System.out.println("Received details: " + details);
        boolean flag = basicDetailsService.addBasicDetails(details);
        if (flag) {
            return new ResponseEntity<>(details, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getDetails/{id}")
    public ResponseEntity<BesicDetails> getDetailsById(@PathVariable Long id) {
        BesicDetails details = basicDetailsService.getBasicDetailsById(id);
        if (details == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }
}
