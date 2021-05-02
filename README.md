Github repo:

Backend: 
>https://github.com/Manmanthan/Travel-Portal-Backend

Frontend:
>https://github.com/Manmanthan/Travel-Portal-Frontend

Base Package: com.nagarro.travelportal
_____________________________________________________________________________________________________________________________________________________________________

### 1. Created model classes Ticket and Employee with @Entity annotation.
>1.1 Created 3 enum in com.nagarro.travelportal.enum package
	
### 2. created dao classes with @Respository annotation.
>2.1 Added mysql connection parameters to properties file.

### 3. created service classes containing basic service methods for controllers, with @Service annotation.
>3.1 Injected the dao class dependency to use its methods.

### 4. Created a email service class with @Service which will be used to send welcome and credentials emails.
>4.1 For credentials email , it will first verify if the user requesting for credentials is already registered 
	in the system.
> 
>4.2 implemented a password service class that uses passay to genrate random passswords.

### 5. created configuration files for JWTAuthentication.added secret key in applications.property

>5.1 JwtTokenutil deals with generating and validationg a jwt token. also sess if token is expired or not.
>
>5.2 JwtRequestFilter extends the Spring Web Filter OncePerRequestFilter class. For any incoming request
		 this Filter class gets executed. It checks if the request has a valid JWT token. If it has a valid JWT 
		 Token then it sets the Authentication in the context, to specify that the current user is authenticated.
>
>5.3 JwtAuthenticationEntryPoint class will extend Spring's AuthenticationEntryPoint class and override its method commence.
 		It rejects every unauthenticated request and send error code 401

### 6. JwtUSerDetails load user name and password from database and is called by ||Sring security|| authentication manager.
>It implements the Spring Security UserDetailsService interface. 

### 7. Also added jwt request and response model classes .

### 8. Created controller classes with @RestController annotations.

>8.1 AdminTicketController is for Admin related functionalities i.e get all tickets and upload document and update a ticket.
		 It returns a download Url for uploaded file to client.
>
>8.2 UserTicketController is for Employees related fucntionalities i.e raise or edit a ticket & get my tickets,
		,download docs uploaded by admin.
>
>8.3 ForgotpasswordController is for sending emails to registered users if user forgots his username or password.
>
>8.4 RegistrationContoller is for registering new Employee with the system.also sends welcome email using emailservice class.
>
>8.5 JWTAuthenticationController exposes a POST API /authenticate.The POST API gets username and password in 
		the body- Using Spring Authentication Manager we authenticate the username and password.
		If the credentials are valid, a JWT token is created using the JWTTokenUtil and provided to the client.
		
### 9. Implemented validation check if user already registered with system he cannot register and a mail with his username password will be sent to his registered email address.
 





_________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________	

- Only one admin is there with 
  >username: admin@nagarro.com and password: 1234.
- Email with username and password will be sent to only registered email adress for the user.
- Username and email address are same.
- If user tries to register again then a mail with his username password will be sent to his registered email address.
- Mail related to Admin will go to 
  >manthanbhardwajsmtp@gmail.com.
- Single document can be uploaded by admin with ticket.



_________________________________________________________________________________________________________________________________________________________________________________________________________________________



## Login Registration Flow : 
________________________


1. User logins.
2. If login successfully then JWTToken is returned.
3. If user is not registered then, he/she can register using the registration controller.

		

_________________________________________________________________________________________________________________________________________________________________________________________________________________________



## Forgot Password Flow :
________________________

1. User clicks forgot password.
2. ForgotPassword controller works.
   > Checks if user exist with this email
   mail is sent with username password, else
   404 response is sent with message "user not found".
   