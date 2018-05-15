/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videostoresimulator;


import Customer.Breezy;
import Customer.Customer;
import Customer.Hoarders;
import Customer.Regular;
import Videos.Video;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author owner
 */

public class CustomerBase {
    private final List<Customer> customers;
    private Customer Breezy;
    private Customer Hoarders;
    private Customer Regular;
    private final String[] CustomerName = {"阿明","阿華","阿花","阿惠","阿瑞","阿瑋","阿凡","阿雲","阿星","阿水"}; 
    public CustomerBase(){
        customers = new ArrayList<>();
        loadCustomers();
        showAllCustomers();
    }
	//load all the customers
    private void loadCustomers() {
        for(int i =0;i<CustomerName.length;i++){
            if(i<3){
                Breezy = new Breezy(CustomerName[i]);
                customers.add(Breezy);
            }else if(i >= 3 && i <6){
                Hoarders = new Hoarders(CustomerName[i]);
                customers.add(Hoarders);
            }else{
                Regular = new Regular(CustomerName[i]);
                customers.add(Regular);
            }
            
        }
        
    }
	//show all customers
	private void showAllCustomers(){
        System.out.println("所有顧客");
        for(int i =0;i< customers.size();i++){
            customers.get(i).printInformation();
        }
      
	}
	//get the customer will in the store
	public Customer getCustomerInStore(int index) {
		Customer customer = customers.get(index);
		customers.remove(index);
		return customer;
	}
   //add back customer to lsit customers
	public void addBackCustomer(Customer customer){
		customers.add(customer);
	}
	//get total number of customer in lsit customers
    public int getTotalCustomer(){
        return customers.size();
    }
    //get which customer should return videos
    public Customer getReturnVideoCustomer(String name){
        int whichCustomer = 0;
        for(int i =0;i< customers.size();i++){
            if(customers.get(i).getCustomerName().equals(name) ==true){
                whichCustomer = i;
            }
        }
        Customer returnCustomer = customers.get(whichCustomer);
        return returnCustomer;
    }
}
