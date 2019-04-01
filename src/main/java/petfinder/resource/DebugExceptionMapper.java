package petfinder.resource;

import javax.ws.rs.core.Response;

public class DebugExceptionMapper {
	
    public Response toResponse(Exception exception) {
        exception.printStackTrace();
        return Response.serverError().entity(exception.getMessage()).build();
    } 
	 
}
