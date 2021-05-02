package com.nagarro.travelportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelportal.Service.EmailService;
import com.nagarro.travelportal.Service.EmployeeService;
import com.nagarro.travelportal.model.Employee;

// TODO: Auto-generated Javadoc

/**
 * The Class ForgotPasswordController.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ForgotPasswordController {

    /**
     * The emp service.
     */
    @Autowired
    private EmployeeService empService;

    /**
     * The email service.
     */
    @Autowired
    private EmailService emailService;

    /**
     * List.
     *
     * @return the list
     */
    @GetMapping("/employees")
    public List<Employee> list() {
        return empService.getAllEmployee();
    }

    /**
     * Get the credentials if user forgets the password
     *
     * @param emailAddress
     * @return
     */
    @GetMapping("/{emailaddress}/forgotpassword")
    public ResponseEntity<String> getCredentials(@PathVariable(value = "emailaddress") String emailAddress) {

        // For admin
        if (emailAddress.equals("admin@nagarro.com")) {
            emailService.getMailWithCredentials(emailAddress);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        // For Normal User
        if (emailService.getMailWithCredentials(emailAddress))
            return new ResponseEntity<>(HttpStatus.OK);

        // Return not found if no user exists
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
