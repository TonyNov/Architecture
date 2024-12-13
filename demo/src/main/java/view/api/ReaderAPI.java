package view.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.FacadeController;
import view.api.dto.NewsItemDTO;
import view.api.dto.NewsListDTO;

@Path("/reader")
public class ReaderAPI {
    FacadeController facadeController = new FacadeController();

    @GET // вызовется по GET-запросу http://localhost.../reader/news/all
    @Path("/news/all")
    public Response getAllNews() {
        System.out.println("geAllNews");
        NewsListDTO test = facadeController.getAllNews();
        for (NewsItemDTO elem : test.items) {
            System.out.println(elem.title);
            System.out.println(elem.content);
            System.out.println(elem.author);
        }
        return Response.ok(test).type(MediaType.APPLICATION_JSON).build();
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

}
