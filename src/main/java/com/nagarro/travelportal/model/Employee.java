package com.nagarro.travelportal.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Entity Employee.
 */
@Entity
@Table(name = "Employee")
public class Employee {

    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String passwordAsString;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String businessUnit;

    @NotNull
    private String title;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Not a valid email address")
    @Id
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String address1;

    private String address2;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String zip;

    @NotNull
    private String country;

    /*
    Employee Constructor
     */
    public Employee() {

    }


    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {

        //Logger.getLogger(Employee.class).info("getter");
        return username;
    }


    /**
     * Sets the username.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        //Logger.getLogger(Employee.class).info("setter");
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the passwordAsString
     */
    public String getPasswordAsString() {
        return passwordAsString;
    }


    /**
     * @param passwordAsString the passwordAsString to set
     */
    public void setPasswordAsString(String passwordAsString) {
        this.passwordAsString = passwordAsString;
    }


    /**
     * Gets the first name.
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the business unit.
     *
     * @return the businessUnit
     */
    public String getBusinessUnit() {
        return businessUnit;
    }

    /**
     * Sets the business unit.
     *
     * @param businessUnit the businessUnit to set
     */
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the address 1.
     *
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Sets the address 1.
     *
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * Gets the address 2.
     *
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Sets the address 2.
     *
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip.
     *
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get Employee details as a string.
     * @return
     */
    @Override
    public String toString() {
        return "Employee [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
                + ", businessUnit=" + businessUnit + ", title=" + title + ", email=" + email + ", phone=" + phone
                + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zip="
                + zip + ", country=" + country + "]";
    }


}