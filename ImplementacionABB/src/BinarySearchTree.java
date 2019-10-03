.
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
        
        public BinaryNode(T dato, BinaryNode<T> right, BinaryNode<T> left){
            this.dato = dato;
            this.right = right;
            this.left = left;
        }
    }
    private BinaryNode<T> root;
    
    public void insert(T x){
        this.root = insert(x,root);
    }
    
    public BinaryNode<T> insert(T x, BinaryNode<T> t){
        if(t==null) return new BinaryNode<>(x,null,null);
        
        int compareRes = x.compareTo(t.dato);
        
        if(compareRes < 0) t.left = insert(x,t.left);
        else if(compareRes > 0) t.right = insert(x,t.left);
        
        return t;    
    }
    
    public void remove(T x){
        root = remove(x,root);
    }
    
    public void insert(T x){
        root = insert(x,root);
    }
    
    public T findMin(){
        return findMin(root).dato;
    }
    
    public T findMax(){
        return findMax(root).dato;
    }
    
    public boolean isEmpty(){
        return(root==null);
    }
    
    
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
    
    private BinaryNode<T> findMax(BinaryNode<T> t){
        if (t!=null) {
            while(t.right!=null)
                t=t.right;
        return t;
    }
        
    /**
     *
     * @param x
     * @return
     */
    public boolean contains(T x){
        return contains(x, root);
    }
        
    private boolean contains(T x,BinaryNode<T> t){
        if(t==null)
            return false;
        int compareResult=x.compareTo(t.element);
        if(compareResult<0)
            return contains(x, t.left);
        else if(compareResult>0)
            return contains(x, t.right);
        else
            return true;
    }
        
      public void makeEmpty(){
        root= null;
    }
    
    public boolean isEmpty(){
        return root==null;
    }
    
    public void printTree(BinaryNode x){
        if(x!= null){
            printTree(x.left);
            System.out.print(x.dato);            
            printTree(x.right);
        }
        
    }
    
    public void insert(T x){
        root= insert(x, root);
    }
    
    private BinaryNode<T> insert(T x, BinaryNode<T> t){
        if(t== null)
            return new BinaryNode<>(x, null, null);
            
            int compareResult = x.compareTo(t.dato);
            if(compareResult <0)
                t.left = insert(x, t.left);
            else if(compareResult >0)
                t.right = insert(x, t.right);
            else
                ;
        
        return t;
        
    }
    
    public void remove(T x){
        root= remove(x,root);
    }
    
    private BinaryNode<T> remove(T x, BinaryNode<T> t){
        if(t==null)
            return t;
        int compareResult= x.compareTo(t.dato);
        if(compareResult < 0)
            t.left = remove(x, t.left);
        else if(compareResult >0)
            t.right = remove(x,t.right);
        else if(t.left != null && t.right != null){
            t.dato = findMin(t.right).dato;
            t.right = remove(t.dato, t.right);
        }
        else
            t = (t.left != null) ? t.left : t.right;
        
        return t;
    }
    
    
            
    
}
