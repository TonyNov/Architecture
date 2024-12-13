package model.json;

import java.util.List;

import controller.news.NewsItemBO;

public class Test {
        public static void main(String[] args) {
                JsonDAO<NewsItemBO> dao = new JsonDAO<>(NewsItemBO.class);
                NewsItemBO news = new NewsItemBO();
                news.setID(0);
                news.setTitle("Ученые обнаружили новую форму жизни на глубине океана");
                news.setContent(
                                "Группа ученых из разных стран провела исследование глубинного океана и обнаружила неизвестную ранее форму жизни. Эта находка может значительно изменить нашу понимание эволюции жизни на Земле.");
                news.setPublicationDate("2025.08.15");
                news.setImage("https://example.com/science-life-discovery.jpg");
                news.setCategoryID(1);
                news.setAuthor("Иванова А.С.");
                dao.add(news);
                news.setID(1);
                news.setTitle("Валютный курс доллара достиг исторического минимума");
                news.setContent(
                                "Сегодня на международном валютном рынке доллар США достиг исторического минимума по отношению к евро и японской йене. Эксперты связывают это с политическими нестабильностями в некоторых странах.");
                news.setPublicationDate("2025.09.22");
                news.setImage("https://example.com/dollar-rate.jpg");
                news.setCategoryID(2);
                news.setAuthor("Петров М.М.");
                dao.add(news);
                news.setID(2);
                news.setTitle("Новое произведение искусства открывается в музее");
                news.setContent(
                                "Вечером сегодня в столичном музее состоится презентация новой выставки произведений известного художника. Эксперты называют эту работу одним из наиболее значительных событий в современном искусстве.");
                news.setPublicationDate("2025.10.12");
                news.setImage("https://example.com/art-exhibition.jpg");
                news.setCategoryID(3);
                news.setAuthor("Сидорова Е.В.");
                dao.add(news);
                news.setID(3);
                news.setTitle("Финал чемпионата мира по футболу");
                news.setContent(
                                "Сегодня в Лондоне состоится финальный матч чемпионата мира по футболу. Фаворитом считается команда Бразилии, но эксперты не исключают сюрприз от команды Испании.");
                news.setPublicationDate("2025.07.16");
                news.setImage("https://example.com/football-championship.jpg");
                news.setCategoryID(4);
                news.setAuthor("Козлов С.А.");
                dao.add(news);
                news.setID(4);
                news.setTitle("Новая версия операционной системы выпущена");
                news.setContent(
                                "Компания TechCorp сегодня выпустила новую версию своей популярной операционной системы. В новой версии добавлено множество новых функций и улучшений производительности.");
                news.setPublicationDate("2025.11.01");
                news.setImage("https://example.com/new-os-release.jpg");
                news.setCategoryID(5);
                news.setAuthor("Николаев А.М.");
                dao.add(news);
                List<NewsItemBO> newsList = dao.getAll();
                for (NewsItemBO item : newsList) {
                        System.out.println(item.getTitle());
                        System.out.println(item.getContent());
                        System.out.println();
                }
        }
}
