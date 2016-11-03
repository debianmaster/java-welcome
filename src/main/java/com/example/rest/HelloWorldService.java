package com.example.rest;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.net.InetAddress;
import java.util.Properties;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.UnknownHostException;

@Path("/api")
public class HelloWorldService {



    static boolean healthy=true;
    static String hostname="";
    public HelloWorldService() {
        try {
            hostname = InetAddress.getLocalHost().getHostName().toString();
        } catch (UnknownHostException ex) {
            hostname = "error";
        }
    }

    @Path("/")
    @GET
    public String home(){
        return hostname;
    }

    @Path("/healthz")
    @GET
    public Response healthz(){
        if (healthy)
            return  Response.ok("OK").build();
        else
            return  Response.status(404).build();
    }

    @Path("/cancer")
    @GET
    public String cancer(){
        healthy=false;
        return "Killed "+hostname;
    }

    @Path("/dbtest")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getMsg() {
		List<Customer> c = new ArrayList<Customer>();
		Connection con = null;
		try {
            Properties prop = new Properties();
            prop.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://"+prop.getProperty("app.mysql_host")+":3306/"+prop.getProperty("app.mysql_database"), prop.getProperty("app.mysql_user"),
                    prop.getProperty("app.mysql_password"));
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				Customer cus = new Customer();
				cus.setId(rs.getInt(1) + "");
				cus.setName(rs.getString(2));
				cus.setAge(rs.getInt(3) + "");
				c.add(cus);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Failed to close conn. " + e);
				}	
			}
		}
		GenericEntity<List<Customer>> entity = new GenericEntity<List<Customer>>(c) {};
		return Response.status(Status.OK).entity(entity).build();
	}
 
}
