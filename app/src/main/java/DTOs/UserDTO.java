package DTOs;

public class UserDTO {
    private Long id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String username;
    private String email;
    private String role;
    private String imageURL;
    
    public UserDTO(String email, String firstname, String lastname, String username) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;

    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public Long getId(){return id;}
}