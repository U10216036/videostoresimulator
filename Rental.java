/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videostoresimulator;


import Videos.Video;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author owner
 */


public class Rental {
	
    private final String customerName;
    private Map<String, Integer> rentVieosMap = new HashMap<String, Integer>();
    private final int startDay;
    private final int rentDay;
    private int remainDays;
	
    public Rental(String customerName, Map<String, Integer> rentVieosMap, int startDay,int rentDay) {
        this.customerName = customerName;
        this.rentVieosMap = rentVieosMap;
        this.startDay = startDay;
        this.rentDay = rentDay;
        this.remainDays = rentDay;
    }
    //get rental's customer name
    public String getCustomerName(){
        return customerName;
    }
	//show this rental's information
    public void showRentalInformation() {
        System.out.println("------------Rental--------------");
        System.out.print(customerName);
        System.out.print("租了:\n");
        //iterating over keys only
        for (String key : rentVieosMap.keySet()) {
            System.out.println(key);
        }
        System.out.println("從第"+(startDay+1)+"天"+" 到第"+((startDay+1)+rentDay)+"天");
        System.out.println("付了 "+payment()+" 元");
        System.out.println("---------------------------------");
    }
	//get the payment of video
    public int payment() {
        int total = 0;
        for (Integer value : rentVieosMap.values()) {
            total+=value;
        }
        total *= rentDay;
        return total;
    }
	//update remain days of video
    public void updateRemainDays(){
        remainDays = (remainDays -1);
    }
    
    //get remain days of video
    public int getRemainDays(){
        return remainDays;
    }
    //get all the return video name
    public List<String> returnVideoName(){
        List<String> returnVideoName = new ArrayList<>();
        for (String key : rentVieosMap.keySet()) {
            returnVideoName.add(key);
        }
        return returnVideoName;
    }
}

