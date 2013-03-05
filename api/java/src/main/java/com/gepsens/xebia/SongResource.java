package com.gepsens.xebia;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

@Path("/songs/{songId}")
@Produces(MediaType.APPLICATION_JSON)
public class SongResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public SongResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Song getSong(@QueryParam("songId") Optional<String> songId) {
        return new Song();
    }
}

