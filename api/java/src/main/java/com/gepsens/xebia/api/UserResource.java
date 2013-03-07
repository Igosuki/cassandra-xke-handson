package com.gepsens.xebia.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.gepsens.xebia.Click;
import com.gepsens.xebia.User;
import com.gepsens.xebia.cass.AstyanaxPersistor;
import com.yammer.metrics.annotation.Timed;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends CassandraResource implements CrudResource<User, UUID> {

    public UserResource(AstyanaxPersistor context) {
        super(context);
    }

    @GET
    @Timed
    @Override
    @Path("/{userId}")
    public User get(@PathParam("userId") UUID id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @POST
    @Override
    public void save(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @DELETE
    @Override
    @Path("/{userId}")
    public void delete(@PathParam("userId") UUID t) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @PUT
    @Override
    public User update(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @GET
    @Path("/{userId}/likes")
    public List<UUID> likes(@PathParam("userId") UUID id, @QueryParam("type")  String type,
                            @QueryParam("since") Date since) {
        return null;
    }

    @GET
    @Path("/{userId}/clicks")
    public List<Click> clickStream(@PathParam("userId") UUID id, @QueryParam("since") Date since) {
        return null;
    }


}


