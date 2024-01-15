package my.service.com.clinica.api.service

import my.service.com.clinica.api.dto.request.DoctorDto
import my.service.com.clinica.api.entitie.Doctor

interface IDoctorService {
    fun findAll():List<Doctor>
    fun save(doctorView: Doctor): DoctorDto
    fun delete(doctor: Long)
    fun update(doctor: Doctor): DoctorDto
}