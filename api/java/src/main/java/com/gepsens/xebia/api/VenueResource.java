package com.gepsens.xebia.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import com.gepsens.xebia.Venue;
import com.yammer.metrics.annotation.Timed;

@Path("/venues")
@Produces(MediaType.APPLICATION_JSON)
public class VenueResource implements CrudResource<Venue, UUID> {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public VenueResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @Override
    @Path("/{venueId}")
    public Venue get(@PathParam("venueId") UUID id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @POST
    @Override
    public void save(Venue venue) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @DELETE
    @Override
    @Path("/{venueId}")
    public void delete(@PathParam("venueId") UUID t) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @PUT
    @Override
    public Venue update(Venue venue) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}


