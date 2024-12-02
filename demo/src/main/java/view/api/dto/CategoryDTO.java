package view.api.dto;

import java.util.ArrayList;
import java.util.List;

import controller.news.NewsItemBO;

public class CategoryDTO {
    public int id;
    public String name;
    public String discription;
    public List<NewsItemBO> newsList = new ArrayList<>();
    public CategoryDTO(){}
}
