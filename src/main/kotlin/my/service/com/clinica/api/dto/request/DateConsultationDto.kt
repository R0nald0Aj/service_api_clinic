package my.service.com.clinica.api.dto.request
import jakarta.validation.constraints.Past
import my.service.com.clinica.api.entitie.DateConsultations
import java.time.LocalDate

data class DateConsultationDto(
    @field:Past(message = "this date is not avalible")
    val date : LocalDate,
    val isAvailableDate :Boolean,
)

fun DateConsultationDto.toDateConsultation() = DateConsultations(
    date = this.date,
    id = null,
    isAvailableDate = this.isAvailableDate,
)
