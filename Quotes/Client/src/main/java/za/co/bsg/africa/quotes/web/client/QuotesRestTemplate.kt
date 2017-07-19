package za.co.bsg.africa.quotes.web.client

import org.springframework.web.client.RestTemplate
import za.co.bsg.africa.quotes.dto.MovieQuotes

class QuotesRestTemplate(val wsUrl: String) {
    val restTemplate: RestTemplate = RestTemplate()

    fun getQuotes(alterEgo: String): MovieQuotes {
        val url: String = wsUrl +"/quotes/retrieve/" + alterEgo
        return restTemplate.getForObject(url, MovieQuotes::class.java)
    }
}