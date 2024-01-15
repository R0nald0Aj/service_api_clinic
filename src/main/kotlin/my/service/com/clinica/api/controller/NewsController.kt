package my.service.com.clinica.api.controller

import my.service.com.clinica.api.dto.request.NewsDto
import my.service.com.clinica.api.dto.request.toNewsEntity
import my.service.com.clinica.api.entitie.News
import my.service.com.clinica.api.repository.NewsRepository
import my.service.com.clinica.api.service.INewsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/clinic/news")
class NewsController(private  val newsService: INewsService) {

    @GetMapping
    fun findAll():ResponseEntity<List<News>>{
        val news = newsService.findAllNews()
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(news)
    }

    @PostMapping("/save")
    fun saveNews(@RequestBody news: NewsDto):ResponseEntity<NewsDto>{
        val newsCreated  = newsService.save(news.toNewsEntity())
        return  ResponseEntity.status(HttpStatus.CREATED).body(NewsDto(newsCreated))
    }
}