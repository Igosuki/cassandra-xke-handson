package com.gepsens.xebia.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import com.gepsens.xebia.Track;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

@Path("/songs/{trackId}")
@Produces(MediaType.APPLICATION_JSON)
public class TrackResource {
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
    public Track getSong(@QueryParam("songId") Optional<UUID> trackId) {
        return new Track();
    }
}

