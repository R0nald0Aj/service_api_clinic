package my.service.com.clinica.api.service.serviceimpl

import my.service.com.clinica.api.dto.request.NewsDto
import my.service.com.clinica.api.entitie.News
import my.service.com.clinica.api.repository.NewsRepository
import my.service.com.clinica.api.service.INewsService
import org.springframework.stereotype.Service

import kotlin.Exception

@Service
class NewsImpl(private val newsRepository: NewsRepository) : INewsService {
    override fun findAllNews(): List<News> {
       return newsRepository.findAll()
    }

    override fun save(news: News): News {
         try { return newsRepository.save(news)
         }catch (exeption:Exception){
             throw Exception("erro ao salva noticia")
         }
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun update(news: News): News {
        TODO("Not yet implemented")
    }
}