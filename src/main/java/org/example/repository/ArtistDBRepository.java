package org.example.repository;

import org.example.models.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDBRepository extends ArtistRepository{

    private DatabaseConnection dbConnection;

    public ArtistDBRepository() {
        this.dbConnection = new DatabaseConnection();
    }

    @Override
    public Iterable<Artist> findAllArtists(){
        String query = "SELECT * FROM artists";
        List<Artist> artists = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query))
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Artist artist = new Artist(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("genres"),
                        rs.getString("albums"));
                artists.add(artist);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find artists",e);
        }
        return artists;
    }
}
