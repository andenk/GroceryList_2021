
package se.iths.grocerylist.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @ManyToMany
    private Set<GroceryListEntity> grocerylists = new HashSet<>();

    @ManyToOne
    private RoleEntity role;


    public UserEntity() {
    }

    public UserEntity(String username, String email, String firstName, String lastName, String password) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    @JsonIgnore
    public Set<GroceryListEntity> getGrocerylists() {
        return grocerylists;
    }

    public void setGrocerylists(Set<GroceryListEntity> groceryLists) {
        this.grocerylists = this.grocerylists;
    }


    public RoleEntity getRole() {
        return role;
    }

    public void addGroceryList(GroceryListEntity grocerylist){
        grocerylists.add(grocerylist);
    }

    public void setRole(RoleEntity role) {
        this.role = role;
        role.addUser(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
