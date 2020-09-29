package classes;
/**
 *
 * @author zvr
 */
public class Author {

    private int id;
    private String fristName;
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

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
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
        return fristName+" "+lastName;
    }
}
