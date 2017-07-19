package za.co.bsg.africa.characters.web.client

import org.springframework.web.client.RestTemplate
import za.co.bsg.africa.characters.dto.MovieCharacter

class CharactersRestTemplate(val wsUrl: String) {
    val restTemplate: RestTemplate = RestTemplate()

    fun getCharacter(alterEgo: String): MovieCharacter {
        val url: String = wsUrl + "characters/find/" + alterEgo
        return restTemplate.getForObject(url, MovieCharacter::class.java)
    }

    fun getAllCharacters(): Array<String> {
        val url: String = wsUrl + "characters/find/all"
        return restTemplate.getForObject(url, Array<String>::class.java)
    }
}
