package DAO;

import Domain.Post;

import java.util.ArrayList;

public class PostDB {
    ArrayList<Post> list = new ArrayList<>();

    public PostDB() {
        list.add(new Post("Maleficios del yoga", "Lorem ipsum dolor sit amet", "2025/05/13", "guashasha", 1));
        list.add(new Post("Beneficios del yoga", "Lorem ipsum dolor sit amet", "2025/05/12", "cuaju", 2));
    }

    public ArrayList<Post> getAll() {
        return this.list;
    }

    public Post addPost(Post post) {
        System.out.println("Post agregado...");
        return post;
    }
}
