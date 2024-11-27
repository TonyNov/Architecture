package controller.news;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NewsController {
    private List<NewsItemBO> newsList = new ArrayList<>();

    public NewsController() {
        NewsItemBO temp = new NewsItemBO();
        temp.setId(0);
        temp.setTitle("������ ���������� ����� ����� ����� �� ������� ������");
        temp.setContent(
                "������ ������ �� ������ ����� ������� ������������ ���������� ������ � ���������� ����������� ����� ����� �����. ��� ������� ����� ����������� �������� ���� ��������� �������� ����� �� �����.");
        temp.setPublicationDate(LocalDate.of(2025, 8, 15));
        temp.setImage("https://example.com/science-life-discovery.jpg");
        temp.setCategoryID(1); // ���������: �����
        temp.setAuthor("������� �.�.");
        newsList.add(temp);
        temp.setId(1);
        temp.setTitle("�������� ���� ������� ������ ������������� ��������");
        temp.setContent(
                "������� �� ������������� �������� ����� ������ ��� ������ ������������� �������� �� ��������� � ���� � �������� ����. �������� ��������� ��� � ������������� ���������������� � ��������� �������.");
        temp.setPublicationDate(LocalDate.of(2025, 9, 22));
        temp.setImage("https://example.com/dollar-rate.jpg");
        temp.setCategoryID(2); // ���������: ���������
        temp.setAuthor("������ �.�.");
        newsList.add(temp);
        temp.setId(2);
        temp.setTitle("����� ������������ ��������� ����������� � �����");
        temp.setContent(
                "������� ������� � ��������� ����� ��������� ����������� ����� �������� ������������ ���������� ���������. �������� �������� ��� ������ ����� �� �������� ������������ ������� � ����������� ���������.");
        temp.setPublicationDate(LocalDate.of(2025, 10, 12));
        temp.setImage("https://example.com/art-exhibition.jpg");
        temp.setCategoryID(3); // ���������: ��������
        temp.setAuthor("�������� �.�.");
        newsList.add(temp);
        temp.setId(3);
        temp.setTitle("����� ���������� ���� �� �������");
        temp.setContent(
                "������� � ������� ��������� ��������� ���� ���������� ���� �� �������. ��������� ��������� ������� ��������, �� �������� �� ��������� ������� �� ������� �������.");
        temp.setPublicationDate(LocalDate.of(2025, 7, 16));
        temp.setImage("https://example.com/football-championship.jpg");
        temp.setCategoryID(4); // ���������: �����
        temp.setAuthor("������ �.�.");
        newsList.add(temp);
        temp.setId(4);
        temp.setTitle("����� ������ ������������ ������� ��������");
        temp.setContent(
                "�������� TechCorp ������� ��������� ����� ������ ����� ���������� ������������ �������. � ����� ������ ��������� ��������� ����� ������� � ��������� ������������������.");
        temp.setPublicationDate(LocalDate.of(2025, 11, 1));
        temp.setImage("https://example.com/new-os-release.jpg");
        temp.setCategoryID(5); // ���������: ����������
        temp.setAuthor("�������� �.�.");
        newsList.add(temp);
    }

    // ��������� �������� ������� �� id
    public NewsItemBO getNewsById(int id) {
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getId() == id)
                return newsItemBO;
        return null;
    }

    public NewsItemBO getNewsByTitle(String title) {
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getTitle().equals(title))
                return newsItemBO;
        return null;
    }

    public List<NewsItemBO> getNewsKeyWord(String key) {
        List<NewsItemBO> temp = new ArrayList<>();
        for (NewsItemBO news : newsList) {
            if ((news.getTitle().toLowerCase().contains(key.toLowerCase()) ||
                    news.getContent().toLowerCase().contains(key.toLowerCase()))) {
                temp.add(news);
            }
        }
        return temp;
    }

    public List<NewsItemBO> getAllNews() {
        List<NewsItemBO> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            temp.add(newsItemBO);
        return temp;
    }

    // ��������� ������ ������� ���� ��������
    public List<String> getAllAuthors() {
        List<String> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            temp.add(newsItemBO.getAuthor());
        return temp;

    }

    // ��������� ���������� �������� ������������ ���������
    public List<String> getTitlesByCategory(int categoryId) {
        List<String> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getCategoryID() == categoryId)
                temp.add(newsItemBO.getTitle());
        return temp;
    }

    // ���������� �������
    public void addNews(String title, String content, String image, String author, LocalDate publicationDate,
            int categoryID) {
        NewsItemBO temp = new NewsItemBO();
        temp.setTitle(title);
        temp.setContent(content);
        temp.setPublicationDate(publicationDate);
        temp.setImage(image);
        temp.setCategoryID(categoryID);
        temp.setAuthor(author);
        newsList.add(temp);
    }

    // ���������� �������
    public void updateNews(int id, String title, String content, String image, String author, LocalDate publicationDate,
            int categoryID) {
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getId() == id) {
                newsItemBO.setTitle(title);
                newsItemBO.setContent(content);
                newsItemBO.setPublicationDate(publicationDate);
                newsItemBO.setImage(image);
                newsItemBO.setCategoryID(categoryID);
                newsItemBO.setAuthor(author);
            }
    }

    // �������� �������
    public void deleteNews(int id) {
        newsList.removeIf(item -> item.getId() == id);
    }
}
