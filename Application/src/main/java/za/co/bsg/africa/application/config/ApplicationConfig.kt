package za.co.bsg.africa.application.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import za.co.bsg.africa.characters.web.client.CharactersRestTemplate
import za.co.bsg.africa.quotes.web.client.QuotesRestTemplate

@Configuration
open class ApplicationConfig {

    @Bean(name = arrayOf("charactersClient"))
    open fun getCharactersClient(): CharactersRestTemplate {
        return CharactersRestTemplate("http://localhost:8081")
    }

    @Bean(name = arrayOf("quotesClient"))
    open fun getQuotesClient(): QuotesRestTemplate {
        return QuotesRestTemplate("http://localhost:8082")
    }

}
