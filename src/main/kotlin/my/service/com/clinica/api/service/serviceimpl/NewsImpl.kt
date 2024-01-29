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

    override fun findNewsById(id: Long) :News{
           val news  = newsRepository.findById(id).orElseThrow {
                  throw Exception("Noticias não encontrada com o id $id")
              }

         return news
    }

    override fun delete(id: Long) {
       try {
           val news = findNewsById(id)
           newsRepository.deleteById(news.id!!)

       }catch (exeption:Exception){
           throw exeption;
       }
    }

    override fun update(news: News,id: Long): News {
        try {
         val newUpdate = findNewsById(id).copy(
                id = id,
                about = news.about,
                text = news.text,
                title =  news.title
            )
          return  newsRepository.save(newUpdate)
        }catch (exe : Exception){
            throw exe
        }
    }
}