package model.entity;

/**
 * 
 */
public class Keyword{

    private int id;
    private String name;

    public Keyword(){
        
    }

    public int getId(){
        return id;
    }

    /**
     * @param newId
     */
    public void setId(int newId){
        id = newId;
    }

    public String getName(){
        return name;
    }

    /**
     * @param newName
     */
    public void setName(String newName){
        name = newName;
    }

    @Override
    public String toString(){
        // TODO: implement
        return null;
    }
}