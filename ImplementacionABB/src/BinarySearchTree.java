
import com.sun.org.apache.xerces.internal.util.FeatureState;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class BinarySearchTree<T extends Comparable<? super T>>{
    private static class BinaryNode<T>{
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
    }
    private BinaryNode<T> root;
    
    public T findMin(){
        if (isEmpty())
            throw new UnderflowException();
        return findMin(root).element;
    }
    
    private BinaryNode<T> findMin(BinaryNode<T> t){
        if(t==null)
            return null;
        else if(t.left==null)
            return t;
        return findMin(t.left);
    }
    
    private int height(BinaryNode<T> t){
        if (t==null) 
            return -1;
        else
            return 1+Math.max(height(t.left), height(t.right));
        
    }
    
            
    
}
