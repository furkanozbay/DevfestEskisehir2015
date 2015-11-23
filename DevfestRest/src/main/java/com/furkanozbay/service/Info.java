package com.furkanozbay.service;

/**
 * Created by Furkan on 19.11.2015.
 */

import com.furkanozbay.models.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;

@Path("/Info")
public class Info {


    @GET
    @Path("/attandee/{phoneNumber}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPerson(@PathParam("phoneNumber") String phoneNumber) {
        Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.11.135.130:3306/devfest", "adminDqQ6AI1", "wjp9MbCdfgdfASg3k");
        } catch (SQLException e) {
            e.printStackTrace();

        }
        if (conn == null) {
            return "connection null";
        }

        Person person = new Person();
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM attandee WHERE phoneNumber=" + "\'" + phoneNumber + "\' ";

        try {

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surName"));
                person.setTelephoneNumber(Double.parseDouble(rs.getString("phoneNumber")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person.getName() + " " + person.getSurname();


    }


}
