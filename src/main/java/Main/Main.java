package Main;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;

import dev.cho.controller.RequestTicketController;
import dev.cho.controller.UserController;
import dev.cho.repositories.RequestDAO;
import dev.cho.repositories.UserDAO;
import dev.cho.service.RequestService;
import dev.cho.service.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
	public static void main(String[] args) {
		
		UserController uc = new UserController(new UserService(new UserDAO()));
		RequestTicketController rc = new RequestTicketController(new RequestService(new RequestDAO()));
		
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins(); //config.enableCors origin mapping needed
			config.addStaticFiles("/public", Location.CLASSPATH);
		});
		app.start(8081);
		
		app.routes(() -> {
			path("/login", () ->{
				post(uc::login);
			});
			path("/create", () ->{
				post(uc::createUser);
			});
			path("/submitRequest/{id}", () ->{
				post(rc::createRequest);
			});
			path("/requests/{userID}", () ->{
				get(rc::getAllRequests);
				path("/{requestID}", ()-> {
					get(rc::getSingleRequest);
				});
			});
			path("/manager", () ->{
				
			});
		});
		
		
			
}


}
