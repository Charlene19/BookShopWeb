package model.entity;

/**
 *
 * @author zvr
 */
public class BookStatus {

    private int id;
    private String name;
    private String postIt;
    
    public BookStatus(){
        
    }

    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPostIt(){
        return postIt;
    }

    public void setPostIt(String postIt){
        this.postIt = postIt;
    }

    @Override
    public String toString(){
        return name;
    }

}
