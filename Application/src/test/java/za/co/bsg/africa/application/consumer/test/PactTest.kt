package za.co.bsg.africa.application.consumer.test

import au.com.dius.pact.consumer.Pact
import au.com.dius.pact.consumer.PactProviderRuleMk2
import au.com.dius.pact.consumer.PactVerification
import au.com.dius.pact.consumer.dsl.DslPart
import au.com.dius.pact.consumer.dsl.PactDslJsonBody
import au.com.dius.pact.consumer.dsl.PactDslWithProvider
import au.com.dius.pact.model.PactSpecVersion
import au.com.dius.pact.model.RequestResponsePact
import org.junit.Rule
import org.junit.Test
import za.co.bsg.africa.application.service.InformationService
import za.co.bsg.africa.characters.web.client.CharactersRestTemplate
import za.co.bsg.africa.quotes.web.client.QuotesRestTemplate

class PactTest {

    @get:Rule
    val mockCharacterService: PactProviderRuleMk2 = PactProviderRuleMk2("characterService", "localhost", 8881, PactSpecVersion.V3, this)

    @get:Rule
    val mockQuotesService: PactProviderRuleMk2 = PactProviderRuleMk2("quotesService", "localhost", 8882, PactSpecVersion.V3, this)

    @Pact(provider = "characterService", consumer = "application_character_Service")
    fun createCharacterPact(builder: PactDslWithProvider): RequestResponsePact {
        val headers: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")

        val body: DslPart = PactDslJsonBody()
                .stringValue("firstName", "Clark")
                .stringValue("lastName", "Kent")
                .stringValue("alterEgo", "Superman")

        return builder
                .given("Superman exists")
                .uponReceiving("A request for Superman\'s identity")
                    .path("/characters/find/Superman")
                    .method("GET")
                .willRespondWith()
                    .status(200)
                    .headers(headers)
                    .body(body)
                .toPact()
    }

    @Pact(provider = "quotesService", consumer = "application_quote_Service")
    fun createQuotePact(builder: PactDslWithProvider): RequestResponsePact {
        val headers: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")

        val body: DslPart = PactDslJsonBody()
                .stringValue("alterEgo", "Superman"
                )
                .array("phrases")
                    .string("I want the means to stop me to be in the hands of a man I can trust with my life.")
                    .string("It\'s not an \'S.\' On my world it means \'hope.")
                .closeArray()

        return builder
                .given("Superman quotes exist")
                .uponReceiving("A request for Superman quotes")
                    .path("/quotes/retrieve/Superman")
                    .method("GET")
                .willRespondWith()
                    .status(200)
                    .headers(headers)
                    .body(body)
                .toPact()
    }

    @Test
    @PactVerification("characterService")
    fun testCharactersTemplate() {
        val quotesClient: QuotesRestTemplate = QuotesRestTemplate("http//unusedService")
        val charactersClient: CharactersRestTemplate = CharactersRestTemplate(mockCharacterService.url)

        val informationService: InformationService = InformationService(quotesClient, charactersClient)
        informationService.getCharacterDetails("Superman")
    }

    @Test
    @PactVerification("quotesService")
    fun testQuotes() {
        val quotesClient: QuotesRestTemplate = QuotesRestTemplate(mockQuotesService.url)
        val charactersClient: CharactersRestTemplate = CharactersRestTemplate("http//unusedService")

        val informationService: InformationService = InformationService(quotesClient, charactersClient)
        informationService.getMovieQuotes("Superman")
    }
}
