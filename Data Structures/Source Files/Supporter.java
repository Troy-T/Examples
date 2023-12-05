/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structures.coursework.part.pkg1;

/**
 *
 * @author 17075763
 */
public class Supporter implements ISupporter {
    
    private String name;
    private String ID;
    
    public Supporter(String name, String ID) {
        
        this.name = name;
        this.ID = ID;
    }
    
    @Override
    public String getName() {
        return name;
    }    
    
    @Override
    public String getID() {
        return ID;
    }
}