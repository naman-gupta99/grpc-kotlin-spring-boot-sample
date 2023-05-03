package com.tmk.grpckt.controller

import com.tmk.grpckt.named.greeter.FetchGreetingRequest
import com.tmk.grpckt.named.greeter.FetchGreetingResponse
import com.tmk.grpckt.named.greeter.NamedGreetingServiceGrpcKt
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class NamedGreetingGrpcService: NamedGreetingServiceGrpcKt.NamedGreetingServiceCoroutineImplBase() {
    override suspend fun fetchGreeting(request: FetchGreetingRequest): FetchGreetingResponse {
        return FetchGreetingResponse.newBuilder()
            .setGreeting("Hello, ${request.name}!")
            .build()
    }
}