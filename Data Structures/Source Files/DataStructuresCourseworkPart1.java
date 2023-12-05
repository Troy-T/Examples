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
public class DataStructuresCourseworkPart1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        String ID = "1";
        String name = "TROY";
        
        Supporter supporter = new Supporter(name, ID);
        
        //FOR HASHTABLES UNCOMMENT "HT" AND COMMENT "BST"
        //ISupporterDatabase db = new SupporterDatabaseBST(supporter);
        ISupporterDatabase db = new SupporterDatabaseHT(2);
        
        db.put(supporter);
        ISupporter test = db.get(name);
        System.out.println(" ");
        System.out.println(test.getID() + " " + test.getName() + " added to table / tree.");
        System.out.println(" ");
        

        ID = "2";
        name = "THOMAS";
        supporter = new Supporter(name, ID);
        db.put(supporter);
        test = db.get(name);
        System.out.println(" ");
        System.out.println(test.getName() + " " + test.getID() + " added to table / tree.");
        System.out.println(" ");
        
        ID = "3";
        name = "BOB";
        supporter = new Supporter(name, ID);
        db.put(supporter);
        test = db.get(name);
        System.out.println(" ");
        System.out.println(test.getName() + " " + test.getID() + " added to table / tree.");
        System.out.println(" ");
        
        //test = db.remove(name);
        
        ID = "62";
        name = "SUPRISE";
        supporter = new Supporter(name, ID);
        db.put(supporter);
        test = db.get(name);
        System.out.println(" ");
        System.out.println(test.getName() + " " + test.getID() + " added to table / tree.");
        System.out.println(" ");
        
        ID = "4";
        name = "JIM";
        supporter = new Supporter(name, ID);
        db.put(supporter);
        test = db.get(name);
        System.out.println(" ");
        System.out.println(test.getName() + " " + test.getID() + " added to table / tree.");
        System.out.println(" ");
        
        ID = "5";
        name = "PAUL";
        supporter = new Supporter(name, ID);
        db.put(supporter);
        test = db.get(name);
        System.out.println(" ");
        System.out.println(test.getName() + " " + test.getID() + " added to table / tree.");
        System.out.println(" ");
        
        ID = "6";
        name = "ZZZZZ";
        supporter = new Supporter(name, ID);
        db.put(supporter);
        test = db.get(name);
        System.out.println(" ");
        System.out.println(test.getName() + " " + test.getID() + " added to table / tree.");
        System.out.println(" ");
        
        ID = "7";
        name = "ZZZZZZ";
        supporter = new Supporter(name, ID);
        db.put(supporter);
        test = db.get(name);
        System.out.println(" ");
        System.out.println(test.getName() + " " + test.getID() + " added to table / tree.");
        System.out.println(" ");
        
        ID = "8";
        name = "ZZZZZZZ";
        supporter = new Supporter(name, ID);
        db.put(supporter);
        test = db.get(name);
        System.out.println(" ");
        System.out.println(test.getName() + " " + test.getID() + " added to table / tree.");
        System.out.println(" ");
        
        System.out.println(" ");
        System.out.println("--------");
        System.out.println("containsName() test");
        System.out.println("Is TROY (root of tree) contained in the database: " + db.containsName("TROY"));
        System.out.println("Is THOMAS (leaf of tree) contained in the database: " + db.containsName("THOMAS"));
        System.out.println("Is HARRY (Not in the database)  contained in the database: " + db.containsName("HARRY"));
        System.out.println(" ");
        
        System.out.println("--------");
        System.out.println("isEmpty() test: (shouldn't be empty)");
        System.out.println("Is the hash table / binary search tree empty: " + db.isEmpty());
        
        System.out.println("--------");
        System.out.println("clear() test");
        db.clear();
        System.out.println("clear() called!");
        
        System.out.println(" ");
        db.printSupportersOrdered();
        
        System.out.println(" ");
        System.out.println("Is the hash table / binary search tree empty: " + db.isEmpty());
        
    }
    
}
