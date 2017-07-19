package za.co.bsg.africa.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan
@EnableAutoConfiguration
open class App {
    companion object{
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args)
        }
    }
}
