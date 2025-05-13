package postService;

import com.google.type.DateTime;
import com.proto.post.AddPostRequest;
import com.proto.post.PostResponse;
import com.proto.post.PostServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.Date;

public class PostServiceImpl extends PostServiceGrpc.PostServiceImplBase {
    @Override
    public void add(AddPostRequest request, StreamObserver<PostResponse> observer) {
        // agregar a base de datos
        observer.onNext(PostResponse.newBuilder()
                .setHeader(request.getHeader())
                .setContent(request.getContent())
                .setDate(new Date().toString())
                .setUsername(request.getUsername())
                .build()
        );

        observer.onCompleted();
    }


}
