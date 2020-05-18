package com.javatraining.designpattern.corExample;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       CEO ceo =new CEO();
       Director director =new Director();
       Manager manager =new Manager();
       
       ceo.setAccessLevel(director);
       director.setAccessLevel(ceo);
       manager.setAccessLevel(director);
       
       AccessRequest accessRequest=new AccessRequest(200000, "fund");
       manager.processRequest(accessRequest);
       
       AccessRequest accessRequest1=new AccessRequest(20, "fund");
       manager.processRequest(accessRequest1);
       
       
       AccessRequest accessRequest2=new AccessRequest(10000, "fund");
       manager.processRequest(accessRequest2);
       
    }
}
