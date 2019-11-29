package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Offer;
import org.iiitb.bean.Specialisation;
import org.iiitb.service.DomainService;
import org.iiitb.service.OfferService;
import org.iiitb.service.SpecialisationService;
import org.iiitb.service.impl.DomainServiceImpl;
import org.iiitb.service.impl.OfferServiceImpl;
import org.iiitb.service.impl.SpecialisationServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.print.Book;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
@Path("/offer")
public class OfferController {

    private OfferService offerService = new OfferServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/new")
    public Response addNewOffer() throws URISyntaxException {
        return Response.seeOther(new URI("/addoffer.html")).build();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addoffer")
    public Response addOffer(@FormDataParam("Organisation_name") String organisation,
                                             @FormDataParam("specId") Integer specialisationId,
                                             @FormDataParam("Min_Grade") Character min_grade,
                                             @FormDataParam("Max_intake") Integer max_intake,
                                             @FormDataParam("domainId") Integer domainId) throws URISyntaxException {
        DomainService domainService = new DomainServiceImpl();
        SpecialisationService specsService = new SpecialisationServiceImpl();

        Offer offer = new Offer();
        offer.setMax_intake(max_intake);
        offer.setMin_grade(min_grade);
        offer.setOrganisation(organisation);
        Domain domain = domainService.find(domainId);
        Specialisation specs = specsService.find(specialisationId);
        offer.getSpecialisation().add(specs);
        offer.getDomain().add(domain);
        System.out.println(offer);
        offerService.save(offer);
        System.out.println(offer);
        return Response.seeOther(new URI("../studentlist.html")).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getoffers")
    public Response showAllOffers() {
        List<Offer> offerList = offerService.findAll();
        System.out.println(offerList);
        if (offerList == null)
            return Response.noContent().build();
        List<Offer> edditedList = new ArrayList();
        for(int i = 0; i< offerList.size(); i++){
            Offer offer = new Offer();
            offer.setOrganisation(offerList.get(i).getOrganisation());
            offer.setSpecsName(offerList.get(i).getSpecialisation().get(0).getName());
            offer.setDomainName(offerList.get(i).getDomain().get(0).getName());
            offer.setMin_grade(offerList.get(i).getMin_grade());
            offer.setMax_intake(offerList.get(i).getMax_intake());
            edditedList.add(offer);
        }
        return Response.ok().entity(edditedList).build();
    }

}
