package com.api.list;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.api.list.controller.RegisterApiController;
import com.api.list.entity.RegisterApi;

import io.helidon.microprofile.server.Server;

@ApplicationScoped
@ApplicationPath("/api")
public class MyMainApp extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(RegisterApiController.class);
		return classes;
	}
	
	public static void main(String[] args) {
		Server server = startServer();
		System.out.println("http://localhost:" + server.port());
	}

	static Server startServer() {
		return Server.create().start();
	}
	
}


