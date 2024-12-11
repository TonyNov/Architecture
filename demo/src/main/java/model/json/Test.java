package model.json;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        NewsDO news = new NewsDO();
        JsonDAO newsDAO = new JsonDAO<NewsDO>();
        NewsDO elem = (NewsDO) newsDAO.getByID(0);
        // news.title = "Ученые обнаружили новую форму жизни на глубине океана";
        // news.content = "Группа ученых из разных стран провела исследование глубинного океана и обнаружила неизвестную ранее форму жизни. Эта находка может значительно изменить нашу понимание эволюции жизни на Земле.";
        // // news.publicationDate = LocalDate.of(2025, 8, 15);
        // news.image = "https://example.com/science-life-discovery.jpg";
        // news.categoryID = 1;
        // news.author = "Иванова А.С.";
        // newsDAO.add(news);
        // news.id = 1;
        // news.title = "Валютный курс доллара достиг исторического минимума";
        // news.content = "Сегодня на международном валютном рынке доллар США достиг исторического минимума по отношению к евро и японской йене. Эксперты связывают это с политическими нестабильностями в некоторых странах.";
        // // news.publicationDate = LocalDate.of(2025, 9, 22);
        // news.image = "https://example.com/dollar-rate.jpg";
        // news.categoryID = 2; // Категория: Экономика
        // news.author = "Петров М.М.";
        // newsDAO.add(news);
        // news.id = 2;
        // news.title = "Новое произведение искусства открывается в музее";
        // news.content = "Вечером сегодня в столичном музее состоится презентация новой выставки произведений известного художника. Эксперты называют эту работу одним из наиболее значительных событий в современном искусстве.";
        // // news.publicationDate = LocalDate.of(2025, 10, 12);
        // news.image = "https://example.com/art-exhibition.jpg";
        // news.categoryID = 3; // Категория: Культура
        // news.author = "Сидорова Е.В.";
        // newsDAO.add(news);
        // news.id = 3;
        // news.title = "Финал чемпионата мира по футболу";
        // news.content = "Сегодня в Лондоне состоится финальный матч чемпионата мира по футболу. Фаворитом считается команда Бразилии, но эксперты не исключают сюрприз от команды Испании.";
        // // news.publicationDate = LocalDate.of(2025, 7, 16);
        // news.image = "https://example.com/football-championship.jpg";
        // news.categoryID = 4; // Категория: Спорт
        // news.author = "Козлов С.А.";
        // newsDAO.add(news);
        // news.id = 4;
        // news.title = "Новая версия операционной системы выпущена";
        // news.content = "Компания TechCorp сегодня выпустила новую версию своей популярной операционной системы. В новой версии добавлено множество новых функций и улучшений производительности.";
        // // news.publicationDate = LocalDate.of(2025, 11, 1);
        // news.image = "https://example.com/new-os-release.jpg";
        // news.categoryID = 5; // Категория: Технологии
        // news.author = "Николаев А.М.";
        // newsDAO.add(news);
    }
}
