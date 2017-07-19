package za.co.bsg.africa.application.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import za.co.bsg.africa.application.service.InformationService
import za.co.bsg.africa.quotes.dto.MovieQuotes

@Controller
class ApplicationController @Autowired constructor(val informationService: InformationService) {

    @RequestMapping(value = "/App"
            , method = arrayOf(RequestMethod.GET) )
    fun getHome(model: Model): String {
        return "Home"
    }

    @RequestMapping(value = "/App/Quotes"
            , method = arrayOf(RequestMethod.GET))
    fun getQuotes(model: Model): String {
        val characters: Array<String> = informationService.getAllCharacterNames()
        val quotes: MutableList<MovieQuotes> = mutableListOf()

        characters.forEach { it -> val quote =informationService.getMovieQuotes(it); quotes.add(quote)}
        model.addAttribute("quotes", quotes)

        return "Quotes"
    }

    @RequestMapping(value = "/App/View"
            , method = arrayOf(RequestMethod.GET))
    fun viewCharacter(@RequestParam alterEgo: String, model: Model): String {
        model.addAttribute("characterDetails", informationService.getCharacterDetails(alterEgo))

        return "CharacterInfo"
    }
}
