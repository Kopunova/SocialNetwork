package ua.com.kopunova;

public interface NewsService {

    public News getNewsById(int newsId) throws DBException;

}
