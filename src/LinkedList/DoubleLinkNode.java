
package LinkedList;

/**
 *
 * @author Lygnite
 */
public class DoubleLinkNode extends Node{
    
    DoubleLinkNode next;
    DoubleLinkNode prev;
    
   public DoubleLinkNode(int r, int s)
   {
       super(r,s);
       this.next = null;
       this.prev = null;
   }
   public void setNext(DoubleLinkNode n)
    {
        this.next = n;
    }
    public DoubleLinkNode getNext()
    {
        return this.next;
    }
    
    public void setPrev(DoubleLinkNode p)
    {
        this.prev = p;
    }
    public DoubleLinkNode getPrev()
    {
        return this.prev;
    }
}
