package br.com.diefenthaeler.grpc_hello_world.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfiguration {

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext() // Use plaintext if the server is not using TLS
                .build();
    }
}
