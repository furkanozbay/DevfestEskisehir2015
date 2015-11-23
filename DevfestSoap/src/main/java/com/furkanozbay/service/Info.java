/**
 * Created by Furkan on 21.11.2015.
 */
package com.furkanozbay.service;

import com.furkanozbay.models.Person;


/**
 * Created by Furkan on 19.11.2015.
 */
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.mysql.jdbc.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class Info {


    @WebMethod(operationName = "attandee")
    public String getPerson(@WebParam(name = "phoneNumber") String phoneNumber) {
        Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://  localhost:3306/devfest", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();

        }
        if (conn == null) {
            return "connection null";
        }

        Person person = new Person();
        Statement statement = null;
        try {
            statement = (Statement) conn.createStatement();
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
