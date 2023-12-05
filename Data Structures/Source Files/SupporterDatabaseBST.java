/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structures.coursework.part.pkg1;

/**
 *
 * @author Troy
 */
class Node {
    Supporter data;
    Node left;
    Node right;

        public Node(Supporter data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
}

public class SupporterDatabaseBST implements ISupporterDatabase {
    
    Node root;
    static int putCounter = 0;

    public SupporterDatabaseBST(Supporter value) {
        this.root = null; 
    } // constructor
    
    
    
    public int getValue(String name) {
        int totalValue = 0;
        char[] surnameArray = name.toCharArray();

        for (char character : surnameArray) {
            totalValue = totalValue + character;
        }
        return totalValue;
    }
    
    public int getDepth() {
        return getDepth(root);
    }
    
    private int getDepth(Node node) {
        int depthLeft = 0;
        int depthRight = 0;
        int depth;
        
        if (node.left != null) {
                depthLeft = size(node.left);    
            }
        if (node.right != null) {
                depthRight = size(node.right);   
            }
        
        if (depthLeft > depthRight) {
            depth = depthLeft;
        } else {
            depth = depthRight;
        }
        return depth;
    }
    /**
    * Empties the database.
    * @pre true
    */
    @Override
    public void clear(){
        root = null;
    } 
    
    
    
    @Override
    public boolean containsName(String name) {
        return containsName(name, root);
    }

    private boolean containsName(String name, Node node) {
        int value = getValue(name);
        boolean found;
        
        if (value == getValue(node.data.getName())) {
            found = true;
        } else if (value < getValue(node.data.getName())) {
            if (node.left == null) {
                found = false;
            } else {
               found = containsName(name, node.left);
            }
        } else {
            if (node.right == null) {
                found = false;
            } else {
                found = containsName(name, node.right);
            }
        }
        
        return found;
    }

    @Override
    public Supporter get(String name) {
        Supporter got;
        
        got = get(name, root);
        
        return got;
    }
    
    private Supporter get(String name, Node node) {
        Supporter got;
        
        if (getValue(name) == getValue(node.data.getName())) {
            got = node.data;
        } else if (getValue(name) < getValue(node.data.getName())) {
                if (node.left == null) {
                    got = null;
                } else {
                    got = get(name , node.left);
                }
                
            } else {
                if (node.right == null) {
                    got = null;
                } else {
                    got = get(name , node.right);
                }
            }
        return got;
    }
    

    @Override
    public Supporter put(Supporter supporter) {
        putCounter = 0;
        
        Node node = new Node(supporter);
        
        if (root == null) {
            root = node;
        } else {
            supporter = put(supporter, root);
        }
        
        System.out.println("Size: " + size() + "|Depth: " + getDepth() + "|Nodes Visted: " + putCounter);
        printSupportersOrdered();
        return supporter;
    }
    
    private Supporter put(Supporter supporter, Node node) {
        
        
        if (getValue(supporter.getName()) < getValue(node.data.getName())) {
            if (node.left != null) {
                putCounter = putCounter + 1;
                supporter = put(supporter, node.left);
            } else {
                node.left = new Node(supporter);
            }
        } else if (getValue(supporter.getName()) > getValue(node.data.getName())) {
            if (node.right != null) {
                putCounter = putCounter + 1;
                supporter = put(supporter, node.right);
            } else {
                node.right = new Node(supporter);
            }
        }
        
        return supporter;
    }

    @Override
    public Supporter remove(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //   ...
    /**
     * Returns the number of supporters in the database
     *
     * @pre true
     * @return number of supporters in the database. 0 if empty
     */
    @Override
    public int size() {
        
        return size(root);
    }
    
    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }
    

    /**
     * Determines if the database is empty or not.
     *
     * @pre true
     * @return true iff the database is empty
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }


    /**
     * Prints the names and IDs of all the supporters in the database in
     * alphabetic order.
     *
     * @pre true
     */
    @Override
    public void printSupportersOrdered() {
        System.out.println("Binary Search Tree Ordered Print");
        if (root == null) {
            System.out.println("The Tree is empty.");
        } else {
            printSupportersOrdered(root);
        }
    }
    
    private void printSupportersOrdered(Node node) {
        
        if (node.left != null) {
                printSupportersOrdered(node.left);
            }
        System.out.println(node.data.getName() + " " + node.data.getID());
        if (node.right != null) {
               printSupportersOrdered(node.right);
            }
    }
}
