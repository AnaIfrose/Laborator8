/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.dao;

import java.sql.*;

/**
 *
 * @author home-pc
 */
public class AlbumController {
    
    public void create(String name, Integer artistID, Integer releaseYear) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement("insert into albums (name, artist_id,  release_year) values (?, ?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setString(2, String.valueOf(artistID));
            pstmt.setString(3, String.valueOf(releaseYear));
            pstmt.executeUpdate();
        }
    }

    public String findByArtist(Integer artistID) throws SQLException {   //afisez numele albumelor in functie de id-ul artistului
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("select name from albums where artist_id = " + artistID);
        return rs.next() ? rs.getString(1) : null;       
    }
}
