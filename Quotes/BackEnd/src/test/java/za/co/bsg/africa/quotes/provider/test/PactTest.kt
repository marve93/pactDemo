package za.co.bsg.africa.quotes.provider.test

import au.com.dius.pact.provider.junit.PactRunner
import au.com.dius.pact.provider.junit.Provider
import au.com.dius.pact.provider.junit.State
import au.com.dius.pact.provider.junit.loader.PactUrl
import au.com.dius.pact.provider.junit.target.HttpTarget
import au.com.dius.pact.provider.junit.target.Target
import au.com.dius.pact.provider.junit.target.TestTarget
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import za.co.bsg.africa.quotes.QuotesSpringBootApplication

@RunWith(PactRunner::class)
@Provider("quotesService")
@PactUrl(urls = arrayOf("file:///D:/Dev/PactDemo/Application/target/pacts/application_quote_Service-quotesService.json"))
class PactTest {

    companion object {
        @JvmField var application: ConfigurableApplicationContext? = null

        @TestTarget
        @JvmField val target: Target = HttpTarget(18082)

        @BeforeClass
        @JvmStatic fun startSpring() {
            application = SpringApplication.run(QuotesSpringBootApplication::class.java, "--server.port=18082")
        }

        @AfterClass
        @JvmStatic fun kill() {
            application?.stop()
        }
    }

    @State("Superman quotes exist")
    fun toDefaultState() {
        print("Running in default state")
    }
}
