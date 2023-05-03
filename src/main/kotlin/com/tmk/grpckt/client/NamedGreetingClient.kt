package com.tmk.grpckt.client

import com.tmk.grpckt.named.greeter.FetchGreetingRequest
import com.tmk.grpckt.named.greeter.NamedGreetingServiceGrpc
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class NamedGreetingClient(
    @Value("\${named-greeting.host}")
    private val host: String
) {

    private var channel: ManagedChannel = ManagedChannelBuilder.forTarget(host)
        .usePlaintext()
        .build()

    fun getNamedGreeting(namedGreetingRequest: FetchGreetingRequest): String {
        NamedGreetingServiceGrpc.newBlockingStub(channel).fetchGreeting(namedGreetingRequest).let {
            return it.greeting
        }
    }
}