package my.service.com.clinica.api.controller

import jakarta.validation.Valid
import my.service.com.clinica.api.dto.request.DateConsultationDto
import my.service.com.clinica.api.dto.request.toDateConsultation
import my.service.com.clinica.api.entitie.DateConsultations
import my.service.com.clinica.api.repository.DateConsultationsRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/clinic/consultation")
class DateConsultationController (private  val consultationsRepository:DateConsultationsRepository){

      @GetMapping()
      fun finalDateConsultations():ResponseEntity<List<DateConsultations>>{
          val dateConsultations = consultationsRepository.findAll()
           return  ResponseEntity.status(HttpStatus.ACCEPTED).body(dateConsultations)
      }

    @PostMapping("/save")
    fun insertDateConsultation(@RequestBody  @Valid consultations: DateConsultationDto):ResponseEntity<DateConsultations>{
        val consultationsCreated = consultationsRepository.save(consultations.toDateConsultation())
        return  ResponseEntity.status(HttpStatus.CREATED).body(consultationsCreated)
    }


}