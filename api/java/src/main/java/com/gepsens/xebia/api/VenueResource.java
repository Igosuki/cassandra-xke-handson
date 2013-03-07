package com.gepsens.xebia.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import com.gepsens.xebia.Venue;
import com.gepsens.xebia.cass.AstyanaxPersistor;
import com.yammer.metrics.annotation.Timed;

@Path("/venues")
@Produces(MediaType.APPLICATION_JSON)
public class VenueResource extends CassandraResource implements CrudResource<Venue, UUID> {

    public VenueResource(AstyanaxPersistor context) {
        super(context);
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

    @Override
    public Collection<Venue> paginate(UUID startToken, int max) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @GET
    public List<Venue> latestVenuesByType(@QueryParam("type") String type, String search) {
        return null;
    }
}


