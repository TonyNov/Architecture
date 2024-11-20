package view.api;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

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