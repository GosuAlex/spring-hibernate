package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();

//            Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            System.out.println("firstname : " + student.getFirstName());
            System.out.println("lastname : " + student.getLastName());

            Address tempAddress = student.getAddress();

            System.out.println("Street : " + tempAddress.getStreet());
            System.out.println("City : " + student.getAddress().getCity());

            for(String lang : student.getLanguages()) {
                System.out.println(lang);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
