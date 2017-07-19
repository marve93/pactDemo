package za.co.bsg.africa.quotes.ws

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import za.co.bsg.africa.quotes.dto.MovieQuotes
import za.co.bsg.africa.quotes.service.QuoteService

@RestController
@RequestMapping("/quotes")
class QuotesWS @Autowired constructor(val quoteService: QuoteService) {

    @RequestMapping(value = "/retrieve/{alterEgo}"
            , method = arrayOf(RequestMethod.GET)
            , produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getQuotes(@PathVariable alterEgo: String): ResponseEntity<MovieQuotes> {
        val response = quoteService.getQuotes(alterEgo)
        return ResponseEntity(response, HttpStatus.OK)
    }
}