package my.service.com.clinica.api.dto.request

import jakarta.validation.constraints.NotBlank
import my.service.com.clinica.api.entitie.News

data class  NewsDto(
    @field:NotBlank(message = "title can´t be empty")
    val title :String,
    @field:NotBlank(message = "about can´t be empty")
    val about : String,
    @field:NotBlank(message = "text can´t be empty")
    val text : String,
){
    constructor(news: News):this(
        title = news.title,
        about = news.about,
        text = news.text
    )
}

fun NewsDto.toNewsEntity()= News(
    id = null,
    title= this.title,
    about = this.about,
    text = this.text
)
