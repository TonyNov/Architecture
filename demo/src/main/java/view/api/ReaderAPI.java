package view.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.FacadeController;

@Path("/reader")
public class ReaderAPI {
    FacadeController facadeController = new FacadeController();

    @GET // вызовется по GET-запросу http://localhost.../reader/news/all
    @Path("/news/all")
    public Response getAllNews() {
        return Response.ok(facadeController.getAllNews()).type(MediaType.APPLICATION_JSON).build();
    }

    @GET // вызовется по GET-запросу http://localhost.../reader/news?id=1
    @Path("/news")
    public Response getNewsByID(@QueryParam("id") int id) {
        return Response.ok(facadeController.getNewsByID(id)).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/news")
    public Response getNewsByTitle(@QueryParam("title") String title) {
        return Response.ok(facadeController.getNewsByTitle(title)).type(MediaType.APPLICATION_JSON).build();
    }

    /*
     * @GET
     * 
     * @Path("/categories")
     * public Response getAllCategories() {
     * ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
     * newsItem.author = "Иван Иванов";
     * newsItem.id = 123;
     * newsItem.title = "Новость номер один";
     * newsItem.content = "Это содержание новости";
     * return Response.ok(newsItem).type(MediaType.APPLICATION_JSON).build();
     * }
     */
}
