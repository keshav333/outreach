package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.UserData;
import org.iiitb.service.UserDataService;
import org.iiitb.service.impl.UserDataServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@Path("/user")
public class UserDataController {

    private UserDataService userDataService = new UserDataServiceImpl();

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/findusers")
    public Response getUser(@FormDataParam("your_name") String username,
                            @FormDataParam("your_pass") String password) throws URISyntaxException {

        System.out.println("fetch user: "+ username);
        UserData user = userDataService.find(username);
        if(user == null) {
            System.out.println(user);
            return Response.seeOther(new URI("/signin.html")).build();
        }
        else {
            if(user.getPassword().equals(password))
                return Response.seeOther(new URI("/afterlogin.html")).build();
            else
                return Response.seeOther(new URI("/signin.html")).build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getusers")
    public Response showAllStudent() {
        UserDataService userdata = new UserDataServiceImpl();
        List<UserData> userList = userdata.findAll();
        if (userList == null)
            return Response.noContent().build();
        return Response.ok().entity(userList).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/signup")
    public Response signUpPage() throws URISyntaxException {
        return Response.seeOther(new URI("/signup.html")).build();
    }
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/adduser")
    public Response addUser(@FormDataParam("name") String username,
                            @FormDataParam("pass") String password) throws URISyntaxException {

        System.out.println("fetch user: "+ username);
        UserData user = new UserData();
        user.setUsername(username);
        user.setPassword(password);
        userDataService.save(user);
        return Response.seeOther(new URI("../signin.html")).build();
    }

}
