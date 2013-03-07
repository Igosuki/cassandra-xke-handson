package com.gepsens.xebia.exercices;

import java.util.UUID;
import com.gepsens.xebia.*;
import com.gepsens.xebia.api.*;
import com.gepsens.xebia.cass.AstyanaxPersistor;
import com.gepsens.xebia.crawler.local.LocalDataSet;
import com.gepsens.xebia.crawler.local.LocalLastFMParser;
import com.netflix.astyanax.util.TimeUUIDUtils;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Exercice1 {

    private static AstyanaxPersistor context;

    public static final String API_DIR = "./data/lastfm_api";

    private LocalLastFMParser localLastFMParser;

    @BeforeClass
    public static void setupClass() {
        context = new AstyanaxPersistor("handson", "localPool");
    }

    @Before
    public void setupParser() {
        this.localLastFMParser = new LocalLastFMParser(API_DIR);
    }

    @Test
    public void create_and_read_artists() throws Exception {
        ArtistResource resource = new ArtistResource(context);
        runCrudTests(resource, Artist.class);
    }

    @Test
    public void create_and_read_tracks() throws Exception {
        TrackResource resource = new TrackResource(context);
        runCrudTests(resource, Track.class);
    }

    @Test
    public void create_and_read_venues() throws Exception {
        VenueResource resource = new VenueResource(context);
        runCrudTests(resource, Venue.class);
    }

    @Test
    public void create_and_read_users() throws Exception {
        UserResource resource = new UserResource(context);
        LocalDataSet<User> dataSet = getDataSet(User.class);
        assertNotNull(dataSet.getItems());
        assertTrue(dataSet.getItems().size() > 0);
        for (User user : dataSet.getItems()) {
            UUID timeUUID = TimeUUIDUtils.getTimeUUID(System.nanoTime());
            user.setId(timeUUID);
            resource.save(user);
            User fetched = resource.get(timeUUID);
            Assert.assertNotNull(fetched);
        }
    }

    /**
     *  This method tries to fetch the dataset for a particular model class
     *  and run it against the resource, reading persisted items as it goes
     */
    private <T extends Artefact> void runCrudTests(CrudResource<T, UUID> crudResource, Class<T> modelClass) throws Exception {
        LocalDataSet<T> dataSet = getDataSet(modelClass);
        assertNotNull(dataSet.getItems());
        assertTrue(dataSet.getItems().size() > 0);
        for (T item : dataSet.getItems()) {
            UUID timeUUID = TimeUUIDUtils.getTimeUUID(System.nanoTime());
            item.setId(timeUUID);
            crudResource.save(item);
            T fetched = crudResource.get(timeUUID);
            Assert.assertNotNull(fetched);
        }
    }

    private <T extends Object> LocalDataSet<T> getDataSet(Class<T> mmodelClass) throws Exception {
        return localLastFMParser.getDataSet(mmodelClass);
    }
}
