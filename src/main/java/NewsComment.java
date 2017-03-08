package ua.com.kopunova;

public class NewsComment {
    int id;
    String created = "";
    String userNewsId = "";
    String userId= "";
    String content;

    public void setId(int id) {this.id = id;}
    public void setCreated(String created) {this.created = created;}
    public void setUserNewsId(String userNewsId) {this.userNewsId = userNewsId;}
    public void setUserId(String userId) {this.userId = userId;}
    public void setContent(String content) {this.content = content;}

    public int getId() {return id;}
    public String getCreated() {return created;}
    public String getUserNewsId() {return userNewsId;}
    public String getUserId() {return userId;}
    public String getContent() {return content;}

    @Override
    public String toString() {
        return "id=" + id + " created=" + created + " userNewsId=" + userNewsId + " userId=" + userId + " content=" + content;
    }
}
