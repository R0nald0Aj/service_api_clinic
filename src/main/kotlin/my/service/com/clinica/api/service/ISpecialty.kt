package my.service.com.clinica.api.service

import my.service.com.clinica.api.dto.request.SpecialtyDto
import my.service.com.clinica.api.entitie.SpecialtyEntity

interface ISpecialty {

    fun findAll():List<SpecialtyEntity>
    fun save(specialty: SpecialtyEntity):SpecialtyDto
    fun delete(idSpecialty: Long)
    fun update(specialty: SpecialtyEntity):SpecialtyEntity
}