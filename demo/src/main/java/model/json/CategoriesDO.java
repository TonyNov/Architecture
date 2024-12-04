package model.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class CategoriesDO {
    @JsonProperty("id")
    public int id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("description")
    public String discription;

    @JsonProperty("news_list")
    public List<Integer> newsList = new ArrayList<>();
}
