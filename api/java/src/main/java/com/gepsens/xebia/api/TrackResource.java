package com.gepsens.xebia.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import com.gepsens.xebia.Track;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

@Path("/tracks")
@Produces(MediaType.APPLICATION_JSON)
public class TrackResource implements CrudResource<Track, UUID> {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public TrackResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @Override
    @Path("/{trackId}")
    public Track get(@PathParam("trackId") UUID id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @POST
    @Override
    public void save(Track track) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @DELETE
    @Override
    @Path("/{trackId}")
    public void delete(@PathParam("trackId") UUID t) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @PUT
    @Override
    public Track update(Track track) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

