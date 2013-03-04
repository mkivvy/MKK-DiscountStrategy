package mkk.discountstrategy;

/**
 * DataRetrievalStrategy is the interface specifying what is needed for data 
 * retrieval classes used within the MKK-DiscountStrategy Project.
 * Every class implementing DataRetrievalStrategy must have a method called 
 * getData which accepts a String value representing the data's unique key and 
 * returns the an Object matching that key.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public interface DataRetrievalStrategy {
    /**
     * Gets an object of the type matching the key passed in.
     * 
     * @param key  the unique identifier for the data object to be used
     * @return  an object of the type matching the key passed in
     */
    public abstract Object getData(String key);
}
