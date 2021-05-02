package com.nagarro.travelportal.Service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.nagarro.travelportal.model.Employee;

/**
 * The Class EmailService sends email.
 */
@Service
public class EmailService {
    // Declare the Log
    private Logger log = Logger.getLogger(EmailService.class);

    // Declare mail sender
    @Autowired
    JavaMailSender mailSender;

    // Declare password service
    @Autowired
    PasswordService pswdService;

    // Declare the Employee Service
    @Autowired
    EmployeeService empService;

    /**
     * Method to send mail.
     *
     * @param ToEmail
     * @param text
     */
    @Async
    public void sendEmail(String ToEmail, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String subject = "Nagarro Travel Portal Information";
        simpleMailMessage.setTo(ToEmail);
        simpleMailMessage.setText(text + "");
        simpleMailMessage.setSubject(subject);
        mailSender.send(simpleMailMessage);

    }

    /**
     * Method to create the and send the welcome mail after registration.
     *
     * @param emailAddress
     * @return
     */
    public String welcomeMail(String emailAddress) {

        // generate password
        String password = pswdService.generatePassword();

        StringBuffer text = new StringBuffer();
        text.append("Greetings for the day!").append("\n" + "\n").append("Welcome to Nagarro Travel Portal")
                .append("\n" + "\n" + "\n").append("Login Credentials for your account are:").append("\n" + "\n")
                .append("Username: " + emailAddress).append("\n").append("Password: " + password)
                .append("\n" + "\n" + "\n").append("Regards!").append("\n").append("Nagarro Travel Team");

        sendEmail(emailAddress, text.toString());
        log.info("Welcome Mail Sent Succesfully.");
        return password;
    }

    /**
     * Method to send credentials to the user email.
     *
     * @param email
     * @return
     */
    public boolean getMailWithCredentials(String email) {
        try {
            Employee employee = empService.getEmployeeByUsername(email);

            StringBuffer text = new StringBuffer();
            text.append("Greetings for the day!").append("\n" + "\n" + "\n")
                    .append("You have requested your user name and password for the your access to the Nagarro Travel Portal:").append("\n" + "\n")
                    .append("Username: " + employee.getUsername()).append("\n")
                    .append("Password: " + employee.getPasswordAsString()).append("\n\n").append("Please contact the Travel team if you have any questions.").append("\n" + "\n" + "\n").append("Thank you,")
                    .append("\n").append("Nagarro Travel Team.");

            sendEmail(email, text.toString());
            log.info("Mail with username and password has been sent");
            return true;
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return false;
    }

    /**
     * Method to send admin credentials.
     *
     * @param emailAddress
     * @return
     */
    public boolean getCredentialsforAdmin(String emailAddress) {

        StringBuffer text = new StringBuffer();
        text.append("Greetings for the day!").append("\n" + "\n" + "\n")
                .append("Login Credentials for your account are:").append("\n" + "\n")
                .append("Username: " + emailAddress).append("\n").append("Password: " + "1234")
                .append("\n" + "\n" + "\n").append("Regards!").append("\n").append("Nagarro Travel Team");

        sendEmail("manthanbhardwajsmtp@gmail.com", text.toString());
        log.info("Mail with username and password has been sent");
        return true;
    }

}
