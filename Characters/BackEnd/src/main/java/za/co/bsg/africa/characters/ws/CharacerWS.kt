package za.co.bsg.africa.characters.ws

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import za.co.bsg.africa.characters.dto.MovieCharacter
import za.co.bsg.africa.characters.service.CharacterService

@RestController
@RequestMapping("/characters")
class CharacterWS @Autowired constructor(val characterService: CharacterService) {

    @RequestMapping(value = "/find/{alterEgo}"
            , method = arrayOf(RequestMethod.GET)
            , produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun findCharacter(@PathVariable alterEgo: String): ResponseEntity<MovieCharacter> {
        val response: MovieCharacter = characterService.getCharacter(alterEgo)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @RequestMapping(value = "/find/all"
            , method = arrayOf(RequestMethod.GET)
            , produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun findAll(): ResponseEntity<Array<String>> {
        val response: Array<String> = characterService.getAllHeroes()
        return ResponseEntity(response, HttpStatus.OK)
    }

}
