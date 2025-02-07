//package org.example.repository;
//
//import org.example.models.Artist;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class ArtistDBRepository extends ArtistRepository{
//
//    private DatabaseConnection dbConnection;
//
//    public ArtistDBRepository() {
//        this.dbConnection = new DatabaseConnection();
//    }
//
//    @Override
//    public Iterable<Artist> findAllArtists(){
//        String query = "SELECT * FROM artists";
//        List<Artist> artists = new ArrayList<>();
//
//        try (Connection connection = dbConnection.getConnection();
//             PreparedStatement pstmt = connection.prepareStatement(query))
//        {
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                Array genresArray = rs.getArray("genres");
//                List<String> genres = genresArray != null ? Arrays.asList((String[]) genresArray.getArray()) : null;
//
//                Array albumsArray = rs.getArray("albums");
//                List<String> albums = albumsArray != null ? Arrays.asList((String[]) albumsArray.getArray()) : null;
//
//                Artist artist = new Artist(rs.getInt("id"),
//                        rs.getString("name"),
//                        genres,
//                        albums
//                        );
//                artists.add(artist);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Failed to find artists",e);
//        }
//        return artists;
//    }
//}
