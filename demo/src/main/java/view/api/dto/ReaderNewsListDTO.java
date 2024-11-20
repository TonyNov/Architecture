package view.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReaderNewsListDTO {
     @JsonProperty("list")
     public List<ReaderNewsItemDTO> newsItems = new ArrayList<>();

}
