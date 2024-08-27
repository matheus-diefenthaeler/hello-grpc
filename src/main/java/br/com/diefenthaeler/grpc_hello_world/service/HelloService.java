package br.com.diefenthaeler.grpc_hello_world.service;

import br.com.diefenthaeler.proto.HelloRequest;
import br.com.diefenthaeler.proto.HelloResponse;
import br.com.diefenthaeler.proto.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(HelloService.class);

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        log.info("Iniciando chamada {}", request.getGreeting());
        String greeting = request.getGreeting();
        HelloResponse response = HelloResponse.newBuilder()
                .setReply("Hello, " + greeting)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
