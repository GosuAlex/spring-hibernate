package com.rad.springdemo.mvc;

import com.rad.springdemo.mvc.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message="is required")
    @Size(min=3, message="is required")
    private String lastName;
    @Min(value=0, message="must be greater or equal to 0")
    @Max(value=10, message="must be less or equal to 10")
    @NotNull(message="is required")
    private Integer freePasses;
//    private int freePasses;
    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="Must be 5 chars/digits")
    private String postalCode;
    @CourseCode(value = "CO", message = "must start with CO")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
