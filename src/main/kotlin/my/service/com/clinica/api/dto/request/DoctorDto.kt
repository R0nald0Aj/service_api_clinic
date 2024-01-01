package my.service.com.clinica.api.dto.request

import jakarta.validation.constraints.NotBlank
import my.service.com.clinica.api.entitie.DateConsultations
import my.service.com.clinica.api.entitie.Doctor

data class DoctorDto(
    @field:NotBlank(message = "Name can´t be empty")
    val name :String,
    @field:NotBlank(message = "crm can´t be empty")
    val crm  :String,
    val imageUrl : String ="",
    val available: Boolean = false,
    val specialtyEntity : Long,
    val dateConsultations : List<DateConsultations>
)

fun DoctorDto.toDoctorEntity() = Doctor(
    name = this.name,
    crm= this.crm,
    imageUrl = this.imageUrl,
    available=this.available,
    dateConsultations = this.dateConsultations,
    specialtyEntity = null,
    id = null,

)