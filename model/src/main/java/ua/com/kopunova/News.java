package ua.com.kopunova;

public class News {
    int id;
    String created = "";
    int userId;
    String content = "";
    String mediaFile = "";

    public void setId(int id) {this.id = id;}
    public void setCreated(String created) {this.created = created;}
    public void setUserId(int userId) {this.userId = userId;}
    public void setContent(String content) {this.content = content;}
    public void setMediaFile(String mediaFile) {this.mediaFile = mediaFile;}

    public int getId() {return id;}
    public String getCreated() {return created;}
    public int getUserId() {return userId;}
    public String getContent() {return content;}
    public String getMediaFile() {return mediaFile;}

    @Override
    public String toString() {
        return "id=" + id + " created=" + created + " userId=" + userId + " content=" + content + " mediaFile=" + mediaFile;
    }
}
