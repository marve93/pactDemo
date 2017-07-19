package za.co.bsg.africa.characters.service

import org.springframework.stereotype.Service
import za.co.bsg.africa.characters.dto.MovieCharacter

@Service
class CharacterService {

    fun getCharacter (alterEgo: String): MovieCharacter {
        return when (alterEgo) {
            "Batman" -> MovieCharacter("Bruce", "Wayne", alterEgo)
            "Superman" -> MovieCharacter("Clark", "Kent", alterEgo)
            "Green Arrow" -> MovieCharacter("Oliver", "Queen", alterEgo)
            "Wonder woman" -> MovieCharacter("Diana", "Prince", alterEgo)
            "Black Widow" -> MovieCharacter("Natasha", "Romanoff", alterEgo)
            "Spiderman" -> MovieCharacter("Peter", "Parker", alterEgo)
            "The Hulk" -> MovieCharacter("Bruce", "Banner", alterEgo)
            else -> MovieCharacter("Unknown", "Unknown", "Unknown")
        }
    }

    fun getAllHeroes(): Array<String> {
        return arrayOf("Batman", "Superman", "Green Arrow", "Wonder woman", "Black Widow", "Spiderman", "The Hulk")
    }
}
