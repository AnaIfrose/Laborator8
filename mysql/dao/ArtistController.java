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
public class ArtistController {
    
    public void create(String name, String country) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement("insert into artists (name, country) values (?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {  //returnez id- ul in functie de numele artistului
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select id, name from artists where name='" + name + "'");
        return rs.next() ? rs.getInt(1) : null;
    }
}
