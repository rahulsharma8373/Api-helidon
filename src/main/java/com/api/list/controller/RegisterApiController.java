package com.api.list.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import com.api.list.entity.RegisterApi;
import com.api.list.service.RegisterApiService;
import response.ApiResponse;
import response.Error;



@Path("/")
@RequestScoped
public class RegisterApiController {

	@Inject
	private RegisterApiService registerApiService;

	@Path("/saveRegisterApi")
	@POST
	public Response saveRegisterApi(@RequestBody RegisterApi registerApi)throws Exception {
	
		try {
			String message = registerApiService.saveRegisterApi(registerApi);		
		if(message != null && !message.equalsIgnoreCase("SUCCESS")) {
			Error error = Error.create(message, message);		
			return Response.ok(ApiResponse.error(error)).build();
		}	return Response.ok(ApiResponse.success("")).build();	
	} catch (Exception e) {
		final String errorCode = "Internal Server Error";
		final Error error = Error.create(errorCode, e.getMessage());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ApiResponse.error(error)).build();
		}
	}
}


