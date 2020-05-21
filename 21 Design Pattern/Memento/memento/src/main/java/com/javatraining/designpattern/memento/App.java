package com.javatraining.designpattern.memento;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CareTaker careTaker=new CareTaker();
    	Cart cart=new Cart();
    	cart.addItem(new Item("book1"));
    	careTaker.save(cart);
    	System.out.println(cart);
    	
    	cart.addItem(new Item("book2"));
    	careTaker.save(cart);
    	System.out.println(cart);
    	
    	cart.addItem(new Item("book3"));
    	careTaker.save(cart);
    	System.out.println(cart);
    	
    	cart.addItem(new Item("book4"));
    	careTaker.save(cart);
    	System.out.println(cart);
    	
    	cart.addItem(new Item("book5"));
    	careTaker.save(cart);
    	System.out.println(cart);
    	
    	cart.addItem(new Item("book6"));
    	//careTaker.save(cart);
    	System.out.println(cart);
    	
    	careTaker.revert(cart);
    	System.out.println(cart);
    	
    	cart.addItem(new Item("book7"));
    	//careTaker.save(cart);
    	System.out.println(cart);
    	careTaker.revert(cart);
    	System.out.println(cart);
    	careTaker.revert(cart);
    	System.out.println(cart);
    	careTaker.revert(cart);
    	System.out.println(cart);
    	careTaker.revert(cart);
    	System.out.println(cart);
    	careTaker.revert(cart);
    	System.out.println(cart);
    	careTaker.revert(cart);
    	System.out.println(cart);
//    	
    }
}
