package com.microsoft.hackathon.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/* 
* 
* Create DemoResource class. This class should be mapped to the root path.
* Create a Create a GET operation with path mapped to hello.  This method will return the value of a key passed as query parameter in the request. 
* 
* If the key is not passed, return "key not passed".
* If the key is passed, return "hello <key>".
* 
*/

@Path("/")
public class DemoResource {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("key") String key) {
        if (key == null) {
            return "key not passed";
        }
        return "hello " + key;
    }



  
    /**
        * Calculates the difference in days between two dates.
        *
        * @param date1 The first date in the format "yyyy-MM-dd".
        * @param date2 The second date in the format "yyyy-MM-dd".
        * @return A string representation of the difference between the two dates in days.
        *         If either date is null, returns "date not passed".
        *         If the date format is invalid, returns "Invalid date format. Please use yyyy-MM-dd".
        */
        
    public String diffdate(@QueryParam("date1") String date1, @QueryParam("date2") String date2) {
        if (date1 == null || date2 == null) {
            return "date not passed";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate localDate1 = LocalDate.parse(date1, formatter);
            LocalDate localDate2 = LocalDate.parse(date2, formatter);
            long diff = ChronoUnit.DAYS.between(localDate1, localDate2);
            return "The difference between " + date1 + " and " + date2 + " is " + Math.abs(diff) + " days";
        } catch (Exception e) {
            return "Invalid date format. Please use yyyy-MM-dd";
        }
    }



}









