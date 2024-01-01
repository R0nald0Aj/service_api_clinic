package my.service.com.clinica.api.controller

import my.service.com.clinica.api.entitie.SpecialtyEntity
import my.service.com.clinica.api.repository.SpecialtyReposritory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/clinic/specialty")
class SpecialtyController(private val repositorySpecialty: SpecialtyReposritory) {
    
    @GetMapping
    fun findAllSpecialty():ResponseEntity<List<SpecialtyEntity>>{
           val specialtiesCreated  = repositorySpecialty.findAll()
           
         return  ResponseEntity.status(HttpStatus.CREATED).body(specialtiesCreated)
    }

    @PostMapping("/save")
    fun insertSpecialty(@RequestBody specialtyEntity: SpecialtyEntity):ResponseEntity<SpecialtyEntity>{
            val specialtyCreated   =repositorySpecialty.save(specialtyEntity)
        return ResponseEntity.status(HttpStatus.CREATED).body(specialtyCreated)
    }
}