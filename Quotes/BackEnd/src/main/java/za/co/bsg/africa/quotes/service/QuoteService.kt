package za.co.bsg.africa.quotes.service

import org.springframework.stereotype.Service
import za.co.bsg.africa.quotes.dto.MovieQuotes

@Service
class QuoteService {

    fun getQuotes(alterEgo: String): MovieQuotes {
        return when (alterEgo) {
            "Batman" -> MovieQuotes(alterEgo, arrayOf("I’m whatever Gotham needs me to be.",
                    "It’s not who I am underneath, but what I do that defines me.",
                    "Bats frighten me. It’s time my enemies share my dread."))

            "Superman" -> MovieQuotes(alterEgo,
                    arrayOf("I want the means to stop me to be in the hands of a man I can trust with my life.",
                            "It\'s not an \'S.\' On my world it means \'hope."))

            "Wonder woman" -> MovieQuotes(alterEgo, arrayOf("I will fight for those who cannot fight for themselves.",
                    "What one does when faced with the truth is more difficult than you\'d think."))

            "Green Arrow" -> MovieQuotes(alterEgo, arrayOf("I\'m not super! Any talents I have I worked hard for.",
                    "You have failed this city"))

            "Black Widow" ->  MovieQuotes(alterEgo, arrayOf("My past is my own.",
                    "You don\'t have a story, little one. You\'re simply a footnote in mine."))

            "Spiderman" -> MovieQuotes(alterEgo, arrayOf("Never wound what you can’t kill.",
                    "Nice to have a fan…", "I\'m not coming back, chief."))

            "The Hulk" -> MovieQuotes(alterEgo, arrayOf("You won\'t like me when I\'m angry",
                    "Hulk smash"))

            else -> MovieQuotes("Unknown", arrayOf())
        }
    }
}
