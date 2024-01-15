package my.service.com.clinica.api.service.serviceimpl

import my.service.com.clinica.api.dto.request.SpecialtyDto
import my.service.com.clinica.api.entitie.SpecialtyEntity
import my.service.com.clinica.api.repository.SpecialtyReposritory
import my.service.com.clinica.api.service.ISpecialty
import org.springframework.stereotype.Service

@Service
 class SpecialtyImpl(private val specialityRepository: SpecialtyReposritory):ISpecialty{
    override fun findAll(): List<SpecialtyEntity> {
        try {
            return  specialityRepository.findAll()
        }catch (exeption:Exception){
            throw Exception("erro ao buscar specilidades")
        }
    }

    override fun save(specialty: SpecialtyEntity): SpecialtyDto {
           try {
               val specialtyEntityCreated = specialityRepository.save(specialty)
               return SpecialtyDto( specialtyEntityCreated)
           }catch (exeption:Exception){
               throw exeption;
           }
    }

    override fun delete(idSpecialty: Long) {
        TODO("Not yet implemented")
    }

    override fun update(specialty: SpecialtyEntity): SpecialtyEntity {
        TODO("Not yet implemented")
    }

}
