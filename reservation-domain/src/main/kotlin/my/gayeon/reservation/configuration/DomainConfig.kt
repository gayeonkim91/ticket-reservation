package my.gayeon.reservation.configuration

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(value = [ JpaConfig::class ])
@Configuration
@ComponentScan(basePackages = [ "my.gayeon.reservation.domain" ])
class DomainConfig {
}