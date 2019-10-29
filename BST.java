//Binary Search Tree class--------------------------------------------
public class BST <T> {

//-------------------------------
    private class Node<T> {
        Node leftChild, rightChild; 
        Comparable data; 
    
        public Node(Comparable data){
            this.data = data; 
            leftChild = rightChild = null; 
        }
    }
//end of Node class--------------


//BST class continue...

//constructor
    private Node root = null;

    public BST(Node root){
        this.root = root; 
    }
    public BST(){
        super();
    }
//end of constructor


    public boolean find(Comparable item){
        return find(item, root);
    }

    public boolean find(Comparable item, Node node){
        if(node == null){
            return false; 
        }
        
        if(node.data == item){
            return true; 
        }else if(node.data.compareTo(item) < 0){
            return find(item, node.rightChild); //if node is less than the item then move closer to item by going right
        }else{
            return find(item, node.leftChild);
        }

    }

    public void insert(Comparable item){
        //if we don't have a tree yet then create first value
        Node<T> newNode = new Node(item); //newNode with new data
        if(root == null){
            root = newNode; //set first node to data
        }else{
            Node<T> current = root; //this node is going to be used to itterate through the tree
            Node<T> parent; 
            while(true){
                //move towards left
                parent = current; 
                if(current.data.compareTo(item) > 0){
                    current = current.leftChild; 
                    if(current == null){ //it's parent is the leaf node
                        parent.leftChild = newNode; 
                        return; 
                    }
                }else{
                    //move towards right
                    current = current.rightChild; 
                    if(current == null){
                        parent.rightChild = newNode; 
                        return; 
                    }
                }
            }
        }
    }
    public void print(){
        print(root);
    }

    public void print(Node root){
        if(root != null){
            print(root.leftChild);
            System.out.println(root.data + " ");
            print(root.rightChild);
        }
        
    }

    public Node findMin(){
        Node<T> current = root; 
        Node<T> minValue = null; 
        while(current != null){
            minValue = current; 
            current = current.leftChild; 
    
        }
        return minValue; 
    }


    public Node findMax(){
        Node<T> current = root; 
        Node<T> maxValue = current; 
        while(current != null){
            maxValue = current; 
            current = current.rightChild; 
        }
        return maxValue; 
    }



    public boolean delete(Comparable item){
      
        Node<T> current = root; 
        Node<T> parent = root; 

        boolean isLeftChild = false; //determines whether node we want to delete is left or right child

        //Searching to find node with key to delete...
        while(current.data != item){
            parent = current; 
            if(current.data.compareTo(item) < 0){
                isLeftChild = true; 
                current = current.leftChild; 
            }else{
                current = current.rightChild; 
                isLeftChild = false; 
            }

            if(current == null){
                return false; 
            }
        }//found the node that we want to delete

        Node<T> nodeToDelete = current; 

        //if node is a leaf
        if(nodeToDelete.leftChild == null && nodeToDelete.rightChild == null){
            if(nodeToDelete == root){
                root = null; 
            }else if(isLeftChild){
                parent.leftChild = null; 
            }else{
                parent.rightChild = null; 
            }
            
        }//if node has one child that is on the left
        else if(nodeToDelete.rightChild == null){
            if(nodeToDelete == root){
                root = nodeToDelete.leftChild; 
            }else if(isLeftChild){
                parent.leftChild = nodeToDelete.leftChild; 
            }else{
                parent.rightChild = nodeToDelete.leftChild; 
            }
        }//if node has one child on the right
        else if(nodeToDelete.leftChild == null){
            if(nodeToDelete == root){
                root = nodeToDelete.rightChild; 
            }else if(isLeftChild){
                parent.leftChild = nodeToDelete.rightChild; 
            }else{
                parent.rightChild = nodeToDelete.rightChild; 
            }
        }
        //if node has two children
        return false; 
  }

}


//Main driver class----------------------------------------------------

// public class Driver {
//     public static void main(String[] args){
//         BST tree = new BST();
        
//         tree.insert(8);
//         System.out.println(tree.findMax().data);
//         tree.insert(23);
//         tree.insert(2);
//         tree.insert(19);
//         tree.insert(12);
//         tree.insert(4);
//         System.out.println(tree.find(9));
//         System.out.println(tree.findMax().data);
//         //tree.delete(23);
//         System.out.println(tree.findMax().data);
//         System.out.println("printing tree in order...");
//         tree.print();
        
        
//     }
// }
 












