/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import mysql.dao.*;
import java.sql.SQLException;

/**
 *
 * @author home-pc
 */
public class MySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            ArtistController artists = new ArtistController();
            AlbumController albums = new AlbumController();
            artists.create("Adele", "United Kingdom");
            artists.create("Indila", "France");

            int adeleId = artists.findByName("Adele");
            int indilaId = artists.findByName("Indila");
            System.out.println(adeleId + " " + indilaId + "\n");

            albums.create("Rumour", adeleId, 2011);
            albums.create("Live at the Royal", adeleId, 2011);
            albums.create("Skyfall", adeleId, 2012);
            albums.create("Mini World", indilaId, 2014);
            String albumName = albums.findByArtist(indilaId);
            System.out.println(albumName);
            
            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            //Database.rollback();
        }
    }
}
