package controller.news.decor;

import java.util.ArrayList;
import java.util.List;

import controller.news.NewsController;
import controller.news.NewsItemBO;

public class PositiveNewsController extends NewsDecorator {

    public PositiveNewsController(NewsController decoratedNews) {
        super(decoratedNews);
    }

    @Override
    public List<NewsItemBO> getNewsKeyWord(String key) {
        List<NewsItemBO> result = new ArrayList<>(decoratedNews.getNewsKeyWord(key));
        // ����� �� ������ �������� �������������� ���������
        System.out.println("���������: ������ ������� �� ��������� ����� '" + key + "'");
        return result;
    }

    @Override
    public List<NewsItemBO> getAllNews() {
        return decoratedNews.getAllNews();
    }
}