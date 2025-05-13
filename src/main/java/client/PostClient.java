package client;

import com.proto.post.GetPostsRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.proto.post.PostResponse;
import com.proto.post.PostServiceGrpc;
import com.proto.post.AddPostRequest;

import java.security.Timestamp;
import java.util.Date;

public class PostClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6868).usePlaintext().build();

        AddPostRequest(channel);
        GetAllPostRequest(channel);

        System.out.println("Done");
        channel.shutdownNow();
    }

    public static void AddPostRequest(ManagedChannel channel) {
        PostServiceGrpc.PostServiceBlockingStub stub = PostServiceGrpc.newBlockingStub(channel);
        PostResponse response = stub.add(AddPostRequest
                .newBuilder()
                .setHeader("Maleficios del yoga volumen 2")
                .setContent("Lorem ipsum dolor sit amet adipiscing elit")
                .setUserId(1)
                .setDate(new Date().toString())
                .setToken("1235456789")
                .setUsername("Fulanito Perengano")
                .build());
        System.out.println("Post response: \n" + response.getHeader() + "\n" + response.getContent());
    }

    public static void GetAllPostRequest(ManagedChannel channel) {
        PostServiceGrpc.PostServiceBlockingStub stub = PostServiceGrpc.newBlockingStub(channel);
        stub.getAll(GetPostsRequest.newBuilder().setPageSize("10").setTimeStamp("").build())
                .forEachRemaining( response -> {
                    System.out.println("-------------------------------------------------");
                    System.out.println("Post response: \n" + response.getHeader() + "\n" + response.getContent());
                    System.out.println("-------------------------------------------------");
                });
    }
}
