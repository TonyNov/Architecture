package view.api;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/creator")
public class CreatorAPI {

    @PUT
    @Path("/news/create")
    public Response createNews(@QueryParam("title") String title,
            @QueryParam("content") String content) {
        String s = "Название:" + title + "\nКонтент:" + content;
        return Response.ok().entity(s).build();
    }
}