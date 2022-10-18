package io.github.liyancode.lixiafdservice.web.controller;

import io.github.liyancode.lixiafdservice.api.dto.response.BaseResponseDTO;
import io.github.liyancode.lixiafdservice.app.service.iprm.PersonHandler;
import io.github.liyancode.lixiafdservice.domain.module.iprm.PersonDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
@RestController
@RequestMapping("/iprm")
public class IPRMController {

    @Autowired
    PersonHandler personHandler;

    @PostMapping("/person")
    public BaseResponseDTO<String> createNewPerson(@RequestBody PersonDO personDO) {
        return personHandler.handlePersonCreate(personDO);
    }

    @DeleteMapping("/person")
    public BaseResponseDTO<String> deletePerson(@RequestBody PersonDO personDO) {
        return personHandler.handlePersonDelete(personDO);
    }

    @PutMapping("/person")
    public BaseResponseDTO<String> updatePerson(@RequestBody PersonDO personDO) {
        return personHandler.handlePersonUpdate(personDO);
    }

    //single
    @GetMapping("/person")
    public BaseResponseDTO<List<PersonDO>> getPersonById(@RequestParam("personId") String personId) {
        return personHandler.handlePersonGetById(personId);
    }

    //list
    @GetMapping("/persons")
    public BaseResponseDTO<List<PersonDO>> getAllPersons(Integer gender) {
        return personHandler.handlePersonGetAll();
    }
}
