package my.service.com.clinica.api.service.serviceimpl

import my.service.com.clinica.api.dto.request.DoctorDto
import my.service.com.clinica.api.entitie.Doctor
import my.service.com.clinica.api.repository.DoctorRepository
import my.service.com.clinica.api.service.IDoctorService
import org.springframework.stereotype.Service

@Service
class DoctorService(private val doctorRepository: DoctorRepository) :IDoctorService {
    override fun findAll(): List<Doctor> {
        try {
            return doctorRepository.findAll()
        }catch (exeption:Exception){
            throw exeption
        }
    }

    override fun save(doctorView: Doctor): DoctorDto {
            if (doctorView.specialtyEntity?.id != null) {
                val doctorSaved = doctorRepository.save(doctorView)
                return DoctorDto(doctorSaved)
            }else  throw Exception("Doctor precisa possuir uma especialidade")
    }

    override fun delete(doctor: Long) {
        TODO("Not yet implemented")
    }

    override fun update(doctor: Doctor): DoctorDto {
        TODO("Not yet implemented")
    }
}