package ua.com.kopunova;

public class UserNews {
    int id;
    String userId = "";
    int newsId;
    String created = "";
    int likes;

    public void setId(int id) {this.id = id;}
    public void setUserId(String userId) {this.userId = userId;}
    public void setNewsId(int newsId) {this.newsId = newsId;}
    public void setCreated(String created) {this.created = created;}
    public void setLikes(int likes) {this.likes = likes;}

    public int getId() {return id;}
    public String getUserId() {return userId;}
    public int getNewsId() {return newsId;}
    public String getCreated() {return created;}
    public int getLikes() {return likes;}

    @Override
    public String toString() {
        return "id=" + id + " userId=" + userId + " newsId=" + newsId + " created=" + created + " likes=" + likes;
    }
}
