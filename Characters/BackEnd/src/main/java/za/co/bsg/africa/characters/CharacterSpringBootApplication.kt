package za.co.bsg.africa.characters

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = arrayOf("za.co.bsg.africa.characters"))
open class CharacterSpringBootApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(CharacterSpringBootApplication::class.java, *args)
        }
    }
}
