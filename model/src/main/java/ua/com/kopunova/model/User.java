package ua.com.kopunova.model;

public class User {
    int id;
    String name = "";
    String email= "";
    String password = "";
    String mediaFile = "";

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setMediaFile(String mediaFile) {this.mediaFile = mediaFile;}

    public int getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getMediaFile() {return mediaFile;}

    @Override
    public String toString() {
        return "id=" + id + " name=" + name + " email=" + email + " password=" + password + " mediaFile=" + mediaFile;
    }

}
