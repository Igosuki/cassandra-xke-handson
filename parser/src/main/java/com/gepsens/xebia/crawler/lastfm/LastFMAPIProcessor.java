package com.gepsens.xebia.crawler.lastfm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import com.gepsens.xebia.JacksonWriter;
import de.umass.lastfm.*;
import de.umass.lastfm.Artist;
import de.umass.lastfm.User;

public class LastFMApiProcessor {


    private String user;

    private String key;

    private String secret;

    private JacksonWriter writer;

    public LastFMApiProcessor(String apiDir, String user, String key, String secret) {
        this.user = user;
        this.key = key;
        this.secret = secret;
        this.writer = new JacksonWriter(apiDir);
    }

    public void downloadFromLastFM() {
        Caller.getInstance().setUserAgent("Cassandra HandsOn");
        //getWeeklyChart(user, key);
        Set<de.umass.lastfm.Artist> artists = downloadArtists(this.user, this.key);
        for (de.umass.lastfm.Artist artist : artists) {
            downloadSongs(artist, this.key);
        }
    }

    private void downloadSongs(de.umass.lastfm.Artist artist, String key) {
        try {
            Collection<Track> topTracks = de.umass.lastfm.Artist.getTopTracks(artist.getName(), key);
            saveTracks(artist, topTracks);
        } catch(Exception e) {
            System.out.println("Couldn't get tracks : " + e.getMessage());
        }
    }

    private Set<de.umass.lastfm.Artist> downloadArtists(String user, String key)  {
        Set<de.umass.lastfm.Artist> artists = new HashSet<de.umass.lastfm.Artist>();
        try {
            artists.addAll(Geo.getTopArtists("France", key));
            artists.addAll(User.getTopArtists(user, key));
        } catch(Exception e) {
            System.out.println("Couldn't get tracks : " + e.getMessage());
        }
        Set<de.umass.lastfm.Artist> artistsInfo = getArtistsInfo(key, artists);
        saveArtists(artistsInfo);
        return artists;
    }

    private Set<de.umass.lastfm.Artist> getArtistsInfo(String key, Set<de.umass.lastfm.Artist> artists) {
        Set<de.umass.lastfm.Artist> artistsInfos = new HashSet<>();
        for (de.umass.lastfm.Artist artist : artists) {
            try {
                artistsInfos.add(de.umass.lastfm.Artist.getInfo(artist.getMbid(), key));
            } catch(Exception e) {
                System.out.println("Couldn't get info for artist : " + e.getMessage());
            }
        }
        return artistsInfos;
    }

    private void saveTracks(de.umass.lastfm.Artist artist, Collection<Track> tracks)  {
        for (Track track : tracks) {
            String fileName = track.getMbid().replaceAll("\\s", "");
            File artistDir = new File(LastFMApiParser.apiDir+"/tracks", artist.getMbid());
            if(!artistDir.exists()) {
                try {
                    Files.createDirectory(Paths.get(artistDir.getPath()));
                } catch (IOException e) {
                    System.out.println("Couldn't create directory : " + artistDir);
                }
            }
            writer.saveJsonFile(track, "/tracks/" + artistDir.getName(), fileName);
        }
    }

    private void saveArtists(Collection<de.umass.lastfm.Artist> pojos)  {
        for (Artist artist : pojos) {
            if(artist != null) {
                String fileName = (artist.getName() != null ? artist.getName() : artist.getMbid()).replaceAll("\\s", "");
                writer.saveJsonFile(artist, "/artists", fileName);
            }
        }
    }

}
