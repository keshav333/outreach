package org.iiitb.controller;

import org.iiitb.bean.Domain;
import org.iiitb.bean.UserData;
import org.iiitb.service.DomainService;
import org.iiitb.service.UserDataService;
import org.iiitb.service.impl.DomainServiceImpl;
import org.iiitb.service.impl.UserDataServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("/domain")
public class DomainController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getdomain")
    public Response getAllDomains() {
        DomainService domain = new DomainServiceImpl();
        List<Domain> domainList = domain.findAll();
        if (domainList == null)
            return Response.noContent().build();
        return Response.ok().entity(domainList).build();
    }
}
