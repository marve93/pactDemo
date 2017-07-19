package za.co.bsg.africa.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import za.co.bsg.africa.characters.dto.MovieCharacter
import za.co.bsg.africa.characters.web.client.CharactersRestTemplate
import za.co.bsg.africa.quotes.dto.MovieQuotes
import za.co.bsg.africa.quotes.web.client.QuotesRestTemplate

@Service
class InformationService @Autowired
        constructor(val quotesClient: QuotesRestTemplate, val characterClient: CharactersRestTemplate) {

    fun getAllCharacterNames(): Array<String> {
        return characterClient.getAllCharacters()
    }

    fun getCharacterDetails(alterEgo: String): MovieCharacter {
        return characterClient.getCharacter(alterEgo)
    }

    fun getMovieQuotes(alterEgo: String): MovieQuotes {
        return quotesClient.getQuotes(alterEgo)
    }
}
