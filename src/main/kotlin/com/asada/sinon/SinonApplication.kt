package com.asada.sinon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SinonApplication

fun main(args: Array<String>) {
	runApplication<SinonApplication>(*args)
}