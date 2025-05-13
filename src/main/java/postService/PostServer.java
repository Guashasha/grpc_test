package postService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class PostServer {
    public static void main(String[] args) {
        int port = 6868;

        Server server = ServerBuilder.forPort(port).addService(new PostServiceImpl()).build();
        
        try {
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
