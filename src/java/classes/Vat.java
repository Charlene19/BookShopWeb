package classes;

/**
 *
 * @author zvr
 */
public class Vat {

    private int id;
    private float rate;
    
    public Vat(){
        
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public float getRate(){
        return rate;
    }

    public void setRate(float rate){
        this.rate = rate;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}