package com.example.relation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.relation.model.RegisterModel;
import com.example.relation.service.RegisterService;

@RestController
public class RegisterController {
    

    @Autowired
    private RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/reg/post")
     public ResponseEntity<RegisterModel>postProduct(@RequestBody RegisterModel registerModel)
    {
        if(registerService.saveRegister(registerModel)==true)
        {
            return new ResponseEntity<>(registerModel,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(registerModel,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    @GetMapping("/register/{id}")
    public ResponseEntity<RegisterModel> getProduct(@PathVariable("id") int id)
    {
        RegisterModel p=registerService.getRegister(id);
        if(p==null)
        {
            return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
       
        
    }



    @GetMapping("/reg/get")
    public List<RegisterModel> getAll()
    {
        return registerService.getAllDetails();
    }

     @PutMapping("register/{id}")
    public ResponseEntity<RegisterModel> putMethodName(@PathVariable("id") int id, @RequestBody  RegisterModel registerModel)
    {
        if(registerService.updateRegister(id,registerModel)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     @DeleteMapping("register/{id}")
    public ResponseEntity<RegisterModel>delete(@PathVariable int id)
    {
        if(registerService.deleteRegister(id)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     @GetMapping("/reg/{userName}")
    public RegisterModel getByName(@PathVariable("userName") String userName)
    {
        return registerService.getRegisterByName(userName); 
    }


    @GetMapping("/reg/sortBy/{field}")
    public List<RegisterModel> sortByRate(@PathVariable("field") String field) {
        return registerService.getSortedList(field);
    }

    @GetMapping("/reg/pagination/{offset}/{pagesize}")
    public List<RegisterModel> getMethodName1(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) {
        return registerService.getPageList(offset,pagesize);
    }


}
