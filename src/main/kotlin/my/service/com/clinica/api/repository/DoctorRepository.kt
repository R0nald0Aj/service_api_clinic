package my.service.com.clinica.api.repository


import my.service.com.clinica.api.entitie.Doctor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorRepository :JpaRepository<Doctor,Long> {
}
