package controller.news;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.news.decor.NewsListInterface;

public class NewsController implements NewsListInterface{
    private final List<NewsItemBO> newsList = new ArrayList<>();

    public NewsController() {
        NewsItemBO temp = new NewsItemBO();
        temp.setId(0);
        temp.setTitle("Ученые обнаружили новую форму жизни на глубине океана");
        temp.setContent(
                "Группа ученых из разных стран провела исследование глубинного океана и обнаружила неизвестную ранее форму жизни. Эта находка может значительно изменить нашу понимание эволюции жизни на Земле.");
        temp.setPublicationDate(LocalDate.of(2025, 8, 15));
        temp.setImage("https://example.com/science-life-discovery.jpg");
        temp.setCategoryID(1); // Категория: Наука
        temp.setAuthor("Иванова А.С.");
        newsList.add(temp);
        temp.setId(1);
        temp.setTitle("Валютный курс доллара достиг исторического минимума");
        temp.setContent(
                "Сегодня на международном валютном рынке доллар США достиг исторического минимума по отношению к евро и японской йене. Эксперты связывают это с политическими нестабильностями в некоторых странах.");
        temp.setPublicationDate(LocalDate.of(2025, 9, 22));
        temp.setImage("https://example.com/dollar-rate.jpg");
        temp.setCategoryID(2); // Категория: Экономика
        temp.setAuthor("Петров М.М.");
        newsList.add(temp);
        temp.setId(2);
        temp.setTitle("Новое произведение искусства открывается в музее");
        temp.setContent(
                "Вечером сегодня в столичном музее состоится презентация новой выставки произведений известного художника. Эксперты называют эту работу одним из наиболее значительных событий в современном искусстве.");
        temp.setPublicationDate(LocalDate.of(2025, 10, 12));
        temp.setImage("https://example.com/art-exhibition.jpg");
        temp.setCategoryID(3); // Категория: Культура
        temp.setAuthor("Сидорова Е.В.");
        newsList.add(temp);
        temp.setId(3);
        temp.setTitle("Финал чемпионата мира по футболу");
        temp.setContent(
                "Сегодня в Лондоне состоится финальный матч чемпионата мира по футболу. Фаворитом считается команда Бразилии, но эксперты не исключают сюрприз от команды Испании.");
        temp.setPublicationDate(LocalDate.of(2025, 7, 16));
        temp.setImage("https://example.com/football-championship.jpg");
        temp.setCategoryID(4); // Категория: Спорт
        temp.setAuthor("Козлов С.А.");
        newsList.add(temp);
        temp.setId(4);
        temp.setTitle("Новая версия операционной системы выпущена");
        temp.setContent(
                "Компания TechCorp сегодня выпустила новую версию своей популярной операционной системы. В новой версии добавлено множество новых функций и улучшений производительности.");
        temp.setPublicationDate(LocalDate.of(2025, 11, 1));
        temp.setImage("https://example.com/new-os-release.jpg");
        temp.setCategoryID(5); // Категория: Технологии
        temp.setAuthor("Николаев А.М.");
        newsList.add(temp);
    }

    // Получение описания новости по id
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
        List<NewsItemBO> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            temp.add(newsItemBO);
        return temp;
    }

    // Получение списка авторов всех новостей
    public List<String> getAllAuthors() {
        List<String> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            temp.add(newsItemBO.getAuthor());
        return temp;
    }

    // Получение заголовков новостей определенной категории
    public List<String> getTitlesByCategory(int categoryId) {
        List<String> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getCategoryID() == categoryId)
                temp.add(newsItemBO.getTitle());
        return temp;
    }

    // Добавление новости
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
    public void deleteNews(int id) {
        newsList.removeIf(item -> item.getId() == id);
    }
}
