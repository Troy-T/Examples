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
public class SupporterDatabaseHT implements ISupporterDatabase {

    private int itemsInTable;
    private int hashCapacity;
    Supporter[] hashTable;
    private static final double LOAD_FACTOR = 0.75;

    public SupporterDatabaseHT(int hashCapacity) {

        this.itemsInTable = 0;
        this.hashCapacity = hashCapacity;
        hashTable = new Supporter[this.hashCapacity];
    }
    
    private int getHashValue(String surname) {
        
        int totalValue = 0; //each round of the following loop deposits the current characters vaule here
        int hash;  //this will be the final value, the hashed surname
        char[] surnameArray = surname.toCharArray(); //convert surname into an array that holds each character of surname

        for (char character : surnameArray) { //loops through the whole array of characters
            totalValue = totalValue + character; //adds the value of each character to a variable
        }

        hash = totalValue % hashCapacity; //hashing happens here

        //The Quadratic Probing happens here
        while (this.hashTable[hash] != null && !(this.hashTable[hash].getName().equals(surname))) { //while in an empty space in the has table and while the name at 'hash'th position in the hash table is not eqaul to surname
            hash = hash + 1; //so that the posistion can still be sqaured if the hash is 0.
            hash = hash * hash % hashCapacity; //mutipling the hash value by itself for the quadratic part of Quadratic Probing, the modulus is so the resulting value is kept within the bounds of the hash table.
        }
        return hash;
    }
    
    public void loadFactor() {
        double items = itemsInTable;
        double hashCap = hashCapacity;
        double load = items / hashCap;
        System.out.println("Load factor is:" + load + " |(items: " + itemsInTable + " |hashCapacity: " + hashCapacity + ")");
        if (load >= LOAD_FACTOR) {
            //printSupportersOrdered();
            increaseCapacity();
            loadFactor();
        }
    }
    
    public void increaseCapacity() {
        int oldCapacity = hashCapacity;
        hashCapacity = hashCapacity * 2;
        Supporter[] oldHashTable;
        
        String name;
        String ID;
        itemsInTable = 0;
        
        oldHashTable = hashTable;
        hashTable = new Supporter[hashCapacity];
        
        for (int i = 0; i < oldCapacity; i++) {
            if(oldHashTable[i] != null){
                itemsInTable = itemsInTable + 1;
                name = oldHashTable[i].getName();
                ID = oldHashTable[i].getID();
                Supporter supporter = new Supporter(name, ID);
                
                hashTable[getHashValue(name)] = supporter;
            }
        }
        
        System.out.println("Hash Table capacity increased!");
        System.out.println("Old capacity: " + oldCapacity + "| New capacity: " + hashCapacity);
    }
    
    /**
     * Empties the database.
     *
     * @pre true
     *
     * TRY: Get the size of the hash table, save it, then set the hash table
     * size to 0, then set the size back to the old size. ALT: Look for one of
     * those "." (e.g: .length) that does this.
     */
    @Override
    public void clear() {
        hashTable = new Supporter[this.hashCapacity];
        itemsInTable = 0;
    }

    /**
     * Determines whether a Supporter name exists as a key inside the database
     *
     * @pre true
     * @param name the Supporter name (key) to locate
     * @return true iff the name exists as a key in the database
     *
     * This is to check through the associative array to check for whether
     * THOMAS 72 is in the hash table or not.
     */
    @Override
    public boolean containsName(String name) {
        boolean contains;
        
        if (hashTable[getHashValue(name)]!= null) {
            contains = true;
        } else {
            contains = false;
        }
        return contains;
    }

    /**
     * Returns a Supporter object mapped to the supplied name.
     *
     * @pre true
     * @param name The Supporter name (key) to locate
     * @return the Supporter object mapped to the key name if the name exists as
     * key in the database, otherwise null
     */
    @Override
    public Supporter get(String name) {
        System.out.println("Get called! Supporter Name: " + name + " | Supporter ID: " + hashTable[getHashValue(name)].getID() + " | Hash Value: " + getHashValue(name));
        return hashTable[getHashValue(name)];
    }

    /**
     * Returns the number of supporters in the database
     *
     * @pre true
     * @return number of supporters in the database. 0 if empty
     */
    @Override
    public int size() {
        return itemsInTable;
    }

    /**
     * Determines if the database is empty or not.
     *
     * @pre true
     * @return true if the database is empty
     */
    @Override
    public boolean isEmpty() {
        return itemsInTable == 0;
    }

    /**
     * Inserts a supporter object into the database, with the key of the
     * supplied supporter's name. Note: If the name already exists as a key,
     * then then the original entry is overwritten. This method should return
     * the previous associated value if one exists, otherwise null
     *
     * @pre true
     * @param supporter the supporter object being inserted into the database
     * @return "The previous associated value" (whatever that means) or null
     * EDIT: Maybe means the value that was previously in that position in the
     * hash table? Return the old key? Return the whole old supporter??
     */
    @Override
    public Supporter put(Supporter supporter) {
        //increment items in table if adding to a null space, not if replacing already existing item
        //chk load val then change size of table (or not) accordingly
        int hash = getHashValue(supporter.getName());
        
        Supporter oldValue = hashTable[hash];
        hashTable[hash] = supporter;
        
        if(hashTable[hash] != null){
            itemsInTable = itemsInTable + 1;
        }
        System.out.println("Size of hashTable: " + size());
        loadFactor();
        printSupportersOrdered();
        
        return oldValue;
    }

    /**
     * Removes and returns a supporter from the database, with the key the
     * supplied name.
     *
     * @param name The name (key) to remove.
     * @pre true
     * @return the removed supporter object mapped to the name, or null if the
     * name does not exist.
     */
    @Override
    public Supporter remove(String name) {
        int hash = getHashValue(name);
        Supporter removedObject = null;
        Supporter blankObject = new Supporter(" "," ");
        
        if (hashTable[hash]!= null) {
            removedObject = hashTable[hash];
            hashTable[hash] = blankObject;
        }
        
        System.out.println("Removed: " + removedObject.getName() + " " + removedObject.getID()) ;
        return removedObject;
    }

    /**
     * Prints the names and IDs of all the supporters in the database in
     * alphabetic order.
     *
     * @pre true
     */
    @Override
    public void printSupportersOrdered() { //this isnt ordered
        System.out.println("Hash Table Print:");
        for (int i = 0; i < hashCapacity; i++) {
            if (hashTable[i] != null) {
                System.out.println(i + ": " + hashTable[i].getName() + " " + hashTable[i].getID());
            } else {
                System.out.println(i + ": " + hashTable[i]);
            }    
        }
        System.out.println(" ");
    }
       
    
}
