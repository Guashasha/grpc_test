package Domain;

public class Post {
    public String content;
    public String header;
    public String date;
    public String username;
    public int userId;

    public Post(String header, String content, String date, String username, int userId) {
        this.content = content;
        this.header = header;
        this.date = date;
        this.username = username;
        this.userId = userId;
    }
}
