package data.structures.coursework.part.pkg1; // or whatever

/**
 *
 * @author D Lightfoot 2018-09
 * DO NOT CHANGE THIS INTERFACE
 * Student must implement this interface
 *
 * objects of classes implementing this interface hold information about a supporter
 */
 
public interface ISupporter {

    /**
     * Retrieves the supporter's ID
     * @pre true
     * @return the supporter's ID
     */
    public String getID();
    
    /**
     * Retrieves the name of the supporter
     * @pre true
     * @return the name of the supporter
     */
    public String getName();
}