package DTOs;

import DataFiles.UserEntity;

public class UserDTO {
    private Long id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String role;
    private String imageurl;

    public UserDTO(String email, String password, String firstname, String middlename, String lastname, String username, String role, String imageurl) {
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.middlename = middlename;
        this.role = role;
        this.imageurl = imageurl;
    }

    public UserDTO(String email, String password, String firstname, String middlename, String lastname, String username) {
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.middlename = middlename;
    }

    public UserEntity toUserEntity() {
        return new UserEntity(this.username,
                this.email,
                this.firstname,
                this.middlename,
                this.lastname,
                this.id,
                this.role,
                this.imageurl);
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getMiddlename() { return middlename; }
    public String getPassword() {return password; }
    public String getRole() { return  role; }
    public String getImageurl() { return  imageurl; }
}