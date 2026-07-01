package com.example.grpc.client.service;

import com.example.grpc.HelloReply;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author quangnd4
 * Date: 6/30/2026
 */

@Slf4j
@Service
public class HelloClient {

    @GrpcClient("hello")
    private HelloServiceGrpc.HelloServiceBlockingStub stub;

    public String sayHello(String name) {
        log.info("HelloClient send request with name={}", name);

        HelloReply reply = stub.sayHello(
                HelloRequest.newBuilder()
                        .setName(name)
                        .build());

        return reply.getMessage();
    }
}
