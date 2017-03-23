package ua.com.kopunova;

public class UserNews {
    int id;
    int userId;
    int newsId;
    String created = "";
    int likes;
    News news;

    public void setId(int id) {this.id = id;}
    public void setUserId(int userId) {this.userId = userId;}
    public void setNewsId(int newsId) {this.newsId = newsId;}
    public void setCreated(String created) {this.created = created;}
    public void setLikes(int likes) {this.likes = likes;}
    public void setNews(News news) {this.news = news;}

    public int getId() {return id;}
    public int getUserId() {return userId;}
    public int getNewsId() {return newsId;}
    public String getCreated() {return created;}
    public int getLikes() {return likes;}
    public News getNews() {return news;}

    @Override
    public String toString() {
        return "id=" + id + " userId=" + userId + " newsId=" + newsId + " created=" + created + " likes=" + likes;
    }
}
