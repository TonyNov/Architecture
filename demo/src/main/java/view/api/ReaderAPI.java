package view.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import view.api.dto.ReaderNewsItemDTO;
import view.api.dto.ReaderNewsListDTO;

@Path("/reader")
public class ReaderAPI {
    @GET // вызовется по GET-запросу http://localhost.../reader/news/all
    @Path("/news/all")
    public Response getAllNews() {
        ReaderNewsListDTO listDTO = new ReaderNewsListDTO();
        ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
        newsItem.author = "Новиков Антон";
        newsItem.id = 123;
        newsItem.title = "Новость номер 123";
        newsItem.content = "Содержание новости";
        newsItem.category = "Категория новости";
        listDTO.newsItems.add(newsItem);
        return Response.ok(listDTO).type(MediaType.APPLICATION_JSON).build();
    }

    @GET // вызовется по GET-запросу http://localhost.../reader/news?id=1
    @Path("/news")
    public Response getNewsByID(@QueryParam("id") int id) {
        ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
        newsItem.author = "Новиков Антон";
        newsItem.id = id;
        newsItem.title = "Новость номер один";
        newsItem.content = "Содержание новости";
        return Response.ok(newsItem).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/news")
    public Response getNewsByTitle(@QueryParam("title") String title) {
        if (title.equals("krista"))
            return Response.status(Response.Status.NOT_FOUND).entity("Новость не найдена").build();
        ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
        newsItem.author = "Иван Иванов";
        newsItem.id = 123;
        newsItem.title = title;
        newsItem.content = "Это содержание новости";
        return Response.ok(newsItem).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/categories")
    public Response getAllCategories() {
        ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
        newsItem.author = "Иван Иванов";
        newsItem.id = 123;
        newsItem.title = "Новость номер один";
        newsItem.content = "Это содержание новости";
        return Response.ok(newsItem).type(MediaType.APPLICATION_JSON).build();
    }
}
