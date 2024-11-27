package view.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewsList {
    private final List<News> newsItems = new ArrayList<>();

    public void addNewsItem(News item) {
        newsItems.add(item);
    }

    public List<News> getNewsItems() {
        return newsItems;
    }

    public News getNewsItemById(int id) {
        for (News item : newsItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<News> filterNewsByTitle(String title) {
        return newsItems.stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}
