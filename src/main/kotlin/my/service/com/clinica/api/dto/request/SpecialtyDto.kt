package my.service.com.clinica.api.dto.request
import jakarta.validation.constraints.NotBlank
import my.service.com.clinica.api.entitie.Doctor
import my.service.com.clinica.api.entitie.SpecialtyEntity

data class SpecialtyDto(
    @field:NotBlank(message = "name can´t be empty")
    val name :String,
    val doctorList: List<Doctor>,
    @field:NotBlank(message = "description can´t be empty")
    val description :String
){
    constructor(specialtyEntity: SpecialtyEntity):this(
        name = specialtyEntity.name,
        doctorList =specialtyEntity.doctorList,
        description = specialtyEntity.description
    )
}

fun SpecialtyDto.toSpecialtyEntity()= SpecialtyEntity(
    name = this.name,
    description = this.description,
    id = null,
    doctorList = this.doctorList
)
