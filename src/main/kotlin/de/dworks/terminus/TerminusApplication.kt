package de.dworks.terminus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TerminusApplication

fun main(args: Array<String>) {
	runApplication<TerminusApplication>(*args)
}
