package postService;

import DAO.PostDB;
import Domain.Post;
import com.google.type.DateTime;
import com.proto.post.AddPostRequest;
import com.proto.post.GetPostsRequest;
import com.proto.post.PostResponse;
import com.proto.post.PostServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Date;

public class PostServiceImpl extends PostServiceGrpc.PostServiceImplBase {
    @Override
    public void add(AddPostRequest request, StreamObserver<PostResponse> observer) {
        Post post = new Post(request.getHeader(), request.getContent(), request.getDate(), request.getUsername(), request.getUserId());

        new PostDB().addPost(post);

        observer.onNext(PostResponse.newBuilder()
                .setHeader(request.getHeader())
                .setContent(request.getContent())
                .setDate(new Date().toString())
                .setUsername(request.getUsername())
                .build()
        );

        observer.onCompleted();
    }

    @Override
    public void getAll(GetPostsRequest request, StreamObserver<PostResponse> observer) {
        ArrayList<Post> posts = new PostDB().getAll();

        for (Post post : posts) {
            PostResponse postResponse = PostResponse
                    .newBuilder()
                    .setUsername(post.username)
                    .setDate(post.date)
                    .setContent(post.content)
                    .setHeader(post.header)
                    .build();
            observer.onNext(postResponse);
        }

        observer.onCompleted();
    }
}
