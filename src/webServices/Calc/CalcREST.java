package webServices.Calc;
import javax.ws.rs.GET;


import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
 


	@Path("/calc")
	public class CalcREST {
	 
	  /*  @GET
	    @Path("/add/{a}/{b}")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String addPlainText(@PathParam("a") double a, @PathParam("b") double b) {
	        return (a + b) + "";
	    }
	     
	    @GET
	    @Path("/sub/{a}/{b}")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String subPlainText(@PathParam("a") double a, @PathParam("b") double b) {
	        return "SUB"+(a - b) + "";
	    }
	 *//*
	    @GET
	    @Path("/add/{a}/{b}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public String add(@PathParam("a") double a, @PathParam("b") double b) {
	    	return "SUM:"+(a+b);
	    	
	    
	    }
	    */
		/*
		@GET
	    @Path("/sub/{a}/{b}")
	    @Produces(MediaType.APPLICATION_JSON)
	    	public String sub(@PathParam("a") double a, @PathParam("b") double b) {
	        return "SUB:"+ (a-b)+"";
	    }
		
		*/
	    @GET
	    @Path("/add/{a}/{b}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response add(@PathParam("a") int a, @PathParam("b") int b) {
	    	CalcCore c1 = new CalcCore();
	    	c1.sum(a, b);
	    	Gson g1 = new Gson();
	    	
	    	return Response.status(500).entity(g1.toJson(c1)).build();
	    	
	    	
	    }
	    

		@GET
	    @Path("/sub/{a}/{b}")
	    @Produces(MediaType.APPLICATION_JSON)
	    	public Response sub(@PathParam("a") int a, @PathParam("b") int b) {
	        CalcCore c2 = new CalcCore();
	        c2.sub(a,b);
	        Gson g2 = new Gson();
	        return Response.status(500).entity(g2.toJson(c2)).build();
	    }
		
		
		
	    
	    
	}

