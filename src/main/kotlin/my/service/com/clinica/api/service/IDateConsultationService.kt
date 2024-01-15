package my.service.com.clinica.api.service

import my.service.com.clinica.api.dto.request.DateConsultationDto
import my.service.com.clinica.api.dto.request.DoctorDto
import my.service.com.clinica.api.entitie.DateConsultations
import my.service.com.clinica.api.entitie.Doctor

interface IDateConsultationService {

    fun findAll():List<DateConsultations>
    fun save(dateConsultations: DateConsultations): DateConsultationDto
    fun delete(dateConsultations: Long)
    fun update(dateConsultations: DateConsultations): DoctorDto
}