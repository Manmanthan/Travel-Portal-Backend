package com.nagarro.travelportal.model;

import java.io.Serializable;

/**
 * The Class JwtRequest.
 */
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    /**
     * @return the username
     */
    public String getUsername() {

        return username;
    }

    /**
     * Set username
     *
     * @param username
     */
    public void setUsername(String username) {

        this.username = username;
    }

    /**
     * Get password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Instantiates a new login credentials.
     *
     * @param username the username
     * @param password the password
     */
    public JwtRequest(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new login credentials.
     */
    public JwtRequest() {

    }

}
