package za.co.bsg.africa.application.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
@EnableWebMvc
@ComponentScan
open class WebConfig : WebMvcConfigurerAdapter() {

    @Bean
    open fun viewResolver(): ViewResolver {
        val resolver: InternalResourceViewResolver = InternalResourceViewResolver()
        resolver.setPrefix("WEB-INF/templates/")
        resolver.setSuffix(".html")
        resolver.setExposeContextBeansAsAttributes(true)
        return resolver
    }


    override fun configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer?) {
        super.configureDefaultServletHandling(configurer)
        configurer?.enable()
    }

}