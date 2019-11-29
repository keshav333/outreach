package org.iiitb.controller;

import org.iiitb.bean.Domain;
import org.iiitb.bean.Specialisation;
import org.iiitb.service.DomainService;
import org.iiitb.service.SpecialisationService;
import org.iiitb.service.impl.DomainServiceImpl;
import org.iiitb.service.impl.SpecialisationServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("/special")
public class SpecialisationController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getspecial")
    public Response getAllSpecs() {
        SpecialisationService specs = new SpecialisationServiceImpl();
        List<Specialisation> specList = specs.findAll();
        if (specList == null)
            return Response.noContent().build();
        return Response.ok().entity(specList).build();
    }
}
