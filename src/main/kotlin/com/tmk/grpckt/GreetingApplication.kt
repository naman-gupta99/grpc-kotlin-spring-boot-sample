package com.tmk.grpckt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.tmk.grpckt"])
@ConfigurationPropertiesScan
class GreetingApplication

fun main(args: Array<String>) {
    runApplication<GreetingApplication>(*args)
}