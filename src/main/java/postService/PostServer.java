package postService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class PostServer {
    public static void main(String[] args) {
        int port = 6868;

        Server server = ServerBuilder.forPort(port).addService(new PostServiceImpl()).build();

        System.out.println("Starting server on port " + port);
        try {
            server.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Runtime.getRuntime().addShutdownHook(new Thread (() -> server.shutdown()));
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
