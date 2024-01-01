package my.service.com.clinica.api.controller

import my.service.com.clinica.api.dto.request.DoctorDto
import my.service.com.clinica.api.dto.request.toDoctorEntity
import my.service.com.clinica.api.entitie.Doctor

import my.service.com.clinica.api.repository.DoctorRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/clinic/doctor")
class DoctorController(private val doctorRepository: DoctorRepository) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Doctor>> {
        val doctors = doctorRepository.findAll()
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(doctors)
    }


    @PostMapping("/save")
    fun saveNews(@RequestBody doctor: DoctorDto): ResponseEntity<Doctor> {
        val doctorCreated  = doctorRepository.save(doctor.toDoctorEntity())
        return  ResponseEntity.status(HttpStatus.CREATED).body(doctorCreated)
    }
}