/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.Scanner;

public class LinkedL {
    
    protected DoubleLinkNode head;
    protected DoubleLinkNode tail;

    public LinkedL(DoubleLinkNode h)
    {
        this.head = h;
        this.tail = h;
    }
    public void setHead(DoubleLinkNode h)
    {
        this.head = h;
    }
    public DoubleLinkNode getHead()
    {
        return this.head;
    }
    
    public void setTail(DoubleLinkNode h)
    {
        this.tail = h;
    }
    public DoubleLinkNode getTail()
    {
        return this.tail;
    }
    
    //Functions
    public int getSize()
    {
        DoubleLinkNode ptr = this.head;
        int count = 0;
        while(ptr != null)
        {
            count = count+1;
            ptr = ptr.getNext();
        }
        return count;
    }
    public void addNode(DoubleLinkNode in) //takes in list
    {
        
        in.setPrev(this.getTail());
        this.getTail().setNext(in);
        this.setTail(in);
    }
    
    public void sortList()
    {
        int count = 0;
        DoubleLinkNode ptr = this.getHead();
        while(ptr != null)
        {
            count = count+1;
            ptr = ptr.getNext();
        }
        
        boolean boole = true;
        DoubleLinkNode current=this.getHead();
        int a=0;
        while(boole)
        {   boole=false;
            DoubleLinkNode dl=this.getHead();
            for(int b=0;b<count-1;b++)
            {
                if(dl.getRow()>dl.getNext().getRow()){
                    boole=true;
                    break;
                }
                    
                
                dl=dl.getNext();
            }
            ptr = this.getHead();
            for(int i = 0; i < count-a-1; i++)
            {
                
                if(ptr.getRow()>ptr.getNext().getRow())
                {
                    int temp = ptr.getRow();
                    int tempc = ptr.getSeat();
                    
                    ptr.setRow(ptr.getNext().getRow());
                    ptr.setSeat(ptr.getNext().getSeat());
                    
                    ptr.getNext().setRow(temp);
                    ptr.getNext().setSeat(tempc);
                    
                }
                ptr = ptr.getNext();
            }
         
            a++;
        }
    }
    
    public void deleteNode(int row, int seat, int seatNum, LinkedL free)
    {
        DoubleLinkNode ptrf = free.findNode(row, seat);
        for(int i = 0; i < seatNum; i++)
        {
            if(ptrf.getPrev() == null)
            {
                head = ptrf.getNext();
            }
            else
            {
            ptrf.getPrev().setNext(ptrf.getNext());
            ptrf.getNext().setPrev(ptrf.getPrev());
            ptrf = ptrf.getNext();
            }
        }
    }
    public void deleteNode(String[] aarray, String[] sarray, String[] carray, LinkedL free)
    {
        for(int i = 0; i < aarray.length; i++)
        {
            Scanner lsc = new Scanner(aarray[i]);
            
        DoubleLinkNode ptrf = free.findNode(lsc.nextInt(), lsc.nextInt());
       
            if(ptrf.getPrev() == null)
            {
                head = ptrf.getNext();
            }
            else
            {
            ptrf.getPrev().setNext(ptrf.getNext());
            ptrf.getNext().setPrev(ptrf.getPrev());
            ptrf = ptrf.getNext();
            }
        }
        for(int i = 0; i < sarray.length; i++)
        {
            Scanner lsc = new Scanner(sarray[i]);
            
        DoubleLinkNode ptrf = free.findNode(lsc.nextInt(), lsc.nextInt());
       
            if(ptrf.getPrev() == null)
            {
                head = ptrf.getNext();
            }
            else
            {
            ptrf.getPrev().setNext(ptrf.getNext());
            ptrf.getNext().setPrev(ptrf.getPrev());
            ptrf = ptrf.getNext();
            }
        }
        for(int i = 0; i < carray.length; i++)
        {
            Scanner lsc = new Scanner(carray[i]);
            
        DoubleLinkNode ptrf = free.findNode(lsc.nextInt(), lsc.nextInt());
       
            if(ptrf.getPrev() == null)
            {
                head = ptrf.getNext();
            }
            else
            {
            ptrf.getPrev().setNext(ptrf.getNext());
            ptrf.getNext().setPrev(ptrf.getPrev());
            ptrf = ptrf.getNext();
            }
        }
        
    }
    public DoubleLinkNode findNode(int r, int s)
    {
        DoubleLinkNode p = this.getHead();
        while(p!=null)
        {
            if(p.getRow() == r && p.getSeat() == s)
            {
                break;
            }
            p = p.getNext();
        }
        return p;
    }
    
}
  