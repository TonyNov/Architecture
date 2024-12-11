package controller.news;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.news.decor.NewsListInterface;
import model.json.JsonDAO;

public class NewsController implements NewsListInterface {
    private final List<NewsItemBO> newsList = new ArrayList<>();

    public NewsController() {
        JsonDAO<NewsItemBO> jsonDao = new JsonDAO<NewsItemBO>() ;
        newsList.add(new NewsItemBO());
        newsList.get(newsList.size() - 1).setId(0);
        newsList.get(newsList.size() - 1).setTitle("Ученые обнаружили новую форму жизни на глубине океана");
        newsList.get(newsList.size() - 1).setContent(
                "Группа ученых из разных стран провела исследование глубинного океана и обнаружила неизвестную ранее форму жизни. Эта находка может значительно изменить нашу понимание эволюции жизни на Земле.");
        newsList.get(newsList.size() - 1).setPublicationDate(LocalDate.of(2025, 8, 15));
        newsList.get(newsList.size() - 1).setImage("https://example.com/science-life-discovery.jpg");
        newsList.get(newsList.size() - 1).setCategoryID(1); // Категория: Наука
        newsList.get(newsList.size() - 1).setAuthor("Иванова А.С.");
        newsList.add(new NewsItemBO());
        newsList.get(newsList.size() - 1).setId(1);
        newsList.get(newsList.size() - 1).setTitle("Валютный курс доллара достиг исторического минимума");
        newsList.get(newsList.size() - 1).setContent(
                "Сегодня на международном валютном рынке доллар США достиг исторического минимума по отношению к евро и японской йене. Эксперты связывают это с политическими нестабильностями в некоторых странах.");
        newsList.get(newsList.size() - 1).setPublicationDate(LocalDate.of(2025, 9, 22));
        newsList.get(newsList.size() - 1).setImage("https://example.com/dollar-rate.jpg");
        newsList.get(newsList.size() - 1).setCategoryID(2); // Категория: Экономика
        newsList.get(newsList.size() - 1).setAuthor("Петров М.М.");
        newsList.add(new NewsItemBO());
        newsList.get(newsList.size() - 1).setId(2);
        newsList.get(newsList.size() - 1).setTitle("Новое произведение искусства открывается в музее");
        newsList.get(newsList.size() - 1).setContent(
                "Вечером сегодня в столичном музее состоится презентация новой выставки произведений известного художника. Эксперты называют эту работу одним из наиболее значительных событий в современном искусстве.");
        newsList.get(newsList.size() - 1).setPublicationDate(LocalDate.of(2025, 10, 12));
        newsList.get(newsList.size() - 1).setImage("https://example.com/art-exhibition.jpg");
        newsList.get(newsList.size() - 1).setCategoryID(3); // Категория: Культура
        newsList.get(newsList.size() - 1).setAuthor("Сидорова Е.В.");
        newsList.add(new NewsItemBO());
        newsList.get(newsList.size() - 1).setId(3);
        newsList.get(newsList.size() - 1).setTitle("Финал чемпионата мира по футболу");
        newsList.get(newsList.size() - 1).setContent(
                "Сегодня в Лондоне состоится финальный матч чемпионата мира по футболу. Фаворитом считается команда Бразилии, но эксперты не исключают сюрприз от команды Испании.");
        newsList.get(newsList.size() - 1).setPublicationDate(LocalDate.of(2025, 7, 16));
        newsList.get(newsList.size() - 1).setImage("https://example.com/football-championship.jpg");
        newsList.get(newsList.size() - 1).setCategoryID(4); // Категория: Спорт
        newsList.get(newsList.size() - 1).setAuthor("Козлов С.А.");
        newsList.add(new NewsItemBO());
        newsList.get(newsList.size() - 1).setId(4);
        newsList.get(newsList.size() - 1).setTitle("Новая версия операционной системы выпущена");
        newsList.get(newsList.size() - 1).setContent(
                "Компания TechCorp сегодня выпустила новую версию своей популярной операционной системы. В новой версии добавлено множество новых функций и улучшений производительности.");
        newsList.get(newsList.size() - 1).setPublicationDate(LocalDate.of(2025, 11, 1));
        newsList.get(newsList.size() - 1).setImage("https://example.com/new-os-release.jpg");
        newsList.get(newsList.size() - 1).setCategoryID(5); // Категория: Технологии
        newsList.get(newsList.size() - 1).setAuthor("Николаев А.М.");
    }

    // Получение описания новости по id
    @Override
    public NewsItemBO getNewsById(int id) {
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getId() == id)
                return newsItemBO;
        return null;
    }
    @Override
    public NewsItemBO getNewsByTitle(String title) {
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getTitle().equals(title))
                return newsItemBO;
        return null;
    }

    @Override
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

    @Override
    public List<NewsItemBO> getAllNews() {
        return newsList;
    }

    // Получение списка авторов всех новостей
    @Override
    public List<String> getAllAuthors() {
        List<String> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            temp.add(newsItemBO.getAuthor());
        return temp;
    }

    // Получение заголовков новостей определенной категории
    @Override
    public List<String> getTitlesByCategory(int categoryId) {
        List<String> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getCategoryID() == categoryId)
                temp.add(newsItemBO.getTitle());
        return temp;
    }

    // Добавление новости
    @Override
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

    // Обновление новости
    @Override
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

    // Удаление новости
    @Override
    public void deleteNews(int id) {
        newsList.removeIf(item -> item.getId() == id);
    }
}
