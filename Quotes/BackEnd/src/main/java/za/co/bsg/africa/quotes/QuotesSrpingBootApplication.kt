package za.co.bsg.africa.quotes

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = arrayOf("za.co.bsg.africa.quotes"))
open class QuotesSpringBootApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(QuotesSpringBootApplication::class.java, *args)
        }
    }
}