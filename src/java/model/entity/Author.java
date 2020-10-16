package model.entity;
/**
 *
 * @author zvr
 */
public class Author {

    private int id;
    private String firstName;
    private String lastName;
    private String postIt;
    
    public Author(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPostIt() {
        return postIt;
    }

    public void setPostIt(String postIt) {
        this.postIt = postIt;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
}
