package com.gepsens.xebia.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import com.gepsens.xebia.Artist;
import com.gepsens.xebia.cass.AstyanaxPersistor;
import com.yammer.metrics.annotation.Timed;

@Path("/artists")
@Produces(MediaType.APPLICATION_JSON)
public class ArtistResource extends CassandraResource implements CrudResource<Artist, UUID> {

    public ArtistResource(AstyanaxPersistor context) {
        super(context);
    }

    @GET
    @Timed
    @Override
    @Path("/{artistId}")
    public Artist get(@PathParam("artistId") UUID id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @POST
    @Override
    public void save(Artist artist) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @DELETE
    @Override
    @Path("/{artistId}")
    public void delete(@PathParam("artistId") UUID t) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @PUT
    @Override
    public Artist update(Artist artist) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}



