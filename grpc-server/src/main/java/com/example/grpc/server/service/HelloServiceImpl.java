package com.example.grpc.server.service;

import com.example.grpc.HelloClientToHelloServerGrpc;
import com.example.grpc.HelloReply;
import com.example.grpc.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author quangnd4
 * Date: 6/29/2026
 */

@Slf4j
@GrpcService
public class HelloServiceImpl extends HelloClientToHelloServerGrpc.HelloClientToHelloServerImplBase {

    @Override
    public void sayHello(
            HelloRequest request,
            StreamObserver<HelloReply> responseObserver) {

        log.info("gRPC Server received request: [{}]", request);

        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello " + request.getName())
                .build();

        log.info("gRPC Server sending response to Client: [{}]", reply);

        responseObserver.onNext(reply);
        responseObserver.onCompleted();

        log.info("gRPC Server completed request for name=[{}]", request.getName());
    }
}
