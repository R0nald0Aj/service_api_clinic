package my.service.com.clinica.api.service.serviceimpl

import my.service.com.clinica.api.dto.request.DateConsultationDto
import my.service.com.clinica.api.dto.request.DoctorDto
import my.service.com.clinica.api.entitie.DateConsultations
import my.service.com.clinica.api.repository.DateConsultationsRepository
import my.service.com.clinica.api.service.IDateConsultationService
import org.springframework.stereotype.Service

@Service
class DateConsultationServiceImpl(private val dateConsultationsRepository: DateConsultationsRepository) :IDateConsultationService{
    override fun findAll(): List<DateConsultations> {
        try {
         return   dateConsultationsRepository.findAll()
        }catch (exception :Exception){
            throw  exception
        }
    }

    override fun save(dateConsultations: DateConsultations): DateConsultationDto {
          try {
              val consultations = dateConsultationsRepository.save(dateConsultations)
              return DateConsultationDto(consultations)

          }catch (exception :Exception){
              throw exception
          }
    }

    override fun delete(dateConsultations: Long) {
        TODO("Not yet implemented")
    }

    override fun update(dateConsultations: DateConsultations): DoctorDto {
        TODO("Not yet implemented")
    }

}