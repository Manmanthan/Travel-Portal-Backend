package com.nagarro.travelportal.model;


import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    /**
     * Set jwt token
     *
     * @param jwttoken
     */
    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    /**
     * Get jwt token
     *
     * @return
     */
    public String getToken() {
        return this.jwttoken;
    }
}