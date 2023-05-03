package com.tmk.grpckt

import com.tmk.grpckt.client.NamedGreetingClient
import com.tmk.grpckt.named.greeter.FetchGreetingRequest
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

private val log = mu.KotlinLogging.logger {}

@Component
class FlowTrigger(
    private val namedGreetingClient: NamedGreetingClient
) : ApplicationListener<ApplicationReadyEvent> {
    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        val greeting = namedGreetingClient.getNamedGreeting(FetchGreetingRequest.newBuilder().setName("Tom").build())
        log.info { greeting }
    }

}