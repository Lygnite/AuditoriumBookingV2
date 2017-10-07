/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

public class Node {
    protected int row;
    protected int seat;
    public Node(int r, int s)
    {
        this.row = r;
        this.seat = s;
    }
    public void setRow(int r)
    {
        this.row = r;
    }
    public int getRow()
    {
        return this.row;
    }
    
    public void setSeat(int s)
    {
        this.seat = s;
    }
    public int getSeat()
    {
        return this.seat;
    }
}
