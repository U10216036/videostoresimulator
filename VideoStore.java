/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videostoresimulator;

import Customer.Customer;
import Customer.Customer;
import Videos.Video;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author owner
 */

public class VideoStore {

    private final Videoshelf videoshelf;
    private final CustomerBase customerBase;
    private final RentalBase rentalBase;
    private Customer customer;
    private final Random rand;
    private int customerNum;
    private int earn;
    private int incoming;
    
    public VideoStore(){
        videoshelf = new Videoshelf();
        customerBase = new CustomerBase();
        rentalBase = new RentalBase();
        rand = new Random();
        
    }
	//start simulate ,each day will open store and close store
	//from day 2-34 will check each rental to know whether the customer should return videos or not
    public void simulateStart(int day){
        System.out.println("開始模擬........");
        for(int i =0; i<day;i++){
            videoshelf.showRemainVideos();
            System.out.println("----------第"+String.valueOf(i+1)+"天------------");
            if(i>0){
                checkReturnVideos();
            }
            openStore(i);
            closeStore();
            
        }
        System.out.println("模擬結束........");
        //when simulate stop show all the information(remainvideos,incomings,all rentals)
		showFinalInformation();
    }
    //open store
    private void openStore(int day){
         System.out.println("開店囉!!!");
         //random get the customer number
         customerNum = rand.nextInt(customerBase.getTotalCustomer());
         //initial one day's earn is zero
		 earn = 0;
		 //initial a list to store the customers in the store
         List<Customer> customersInStore = new ArrayList<>();
         for (int cNum=0;cNum<customerNum;cNum++) {
			//get a random customer from customerBase
            customer =  customerBase.getCustomerInStore(rand.nextInt(customerBase.getTotalCustomer()));
            // decide the number of videos customer will rent
			int numOfRentVideo = customer.getRentVideoNum();
			//if the customer can rent the video 
            if(customer.isRentable(numOfRentVideo, videoshelf.getTotalVideoNum()) == true){
                //initial a list to store videos customer will rent
				List<Video> rentVideos = new ArrayList<>();
				//initial a rentVieosMap to store video name and price, this is a parameter for rental
                Map<String, Integer> rentVieosMap = new HashMap<>();
                //add customer in store
				customersInStore.add(customer);
                System.out.println(customer.getCustomerName() + "來店裡了");
                //decide the number of days customer will rent
				int numOfRentDay = customer.getRentDay();
				//random get videos in the videoshelf
                for(int i =0;i<numOfRentVideo;i++){
                    Video video = videoshelf.getVideo(rand.nextInt(videoshelf.getTotalVideoNum()));
                    rentVieosMap.put(video.getVideoName(), video.getPrice());
                    //give video to customer
					customer.getRentedVideo(video);
                }
				// new a rental for the customer
                Rental activeRental = new Rental(customer.getCustomerName(),rentVieosMap,day,numOfRentDay);
                // show this rental's information
				activeRental.showRentalInformation();
                //calculate earn in a day
				earn += activeRental.payment();
				//add this rental to rentalBase
                rentalBase.addActiveRental(activeRental);
				//update the number of video customer can rent
                customer.changeRemainVideoNum(numOfRentVideo);
            }
            else{
				//if not able to rent ,add back customer to customer base
                customerBase.addBackCustomer(customer);
            }
         }
         
        
        //add back customer in store to customerBase
        for(int i = 0;i<customersInStore.size();i++){
            customerBase.addBackCustomer(customersInStore.get(i));
        }
        customersInStore.clear();
        
        
         
    }
    
    //check the rental to know the customer should return video or not
    private void checkReturnVideos(){
		//from day 2 update all the active rental's remain day
        rentalBase.updateAllActiveRentals();
		//when rental's remain day is 0,customer return the video
        for(int i =0;i<rentalBase.getActiveRentalsSize();i++){
            if(rentalBase.getActiveRental(i).getRemainDays()==0){
                //customer return
                Rental activeRental = rentalBase.getActiveRental(i);
                Customer returnVideoCustomer = customerBase.getReturnVideoCustomer(activeRental.getCustomerName());
                List<Video> returnedVideos = returnVideoCustomer.returnVideo(activeRental.returnVideoName());
                
                for(int j =0;j<returnedVideos.size();j++){
                    videoshelf.returnVideo(returnedVideos.get(j));
                }
                rentalBase.addCompletedRentals(activeRental);
                
            }
        }
		//after customer return the video remove the active rental and add it to completed rental
        rentalBase.removeActiveRentalZeroDays();
    
        
    }
    
    
    private void closeStore(){
        System.out.println("關店囉!!!");
        calculateSumandIncome();
    }
           

    private void calculateSumandIncome() {
        System.out.println("計算營收........");
        System.out.println("營收   : " + earn);
        incoming += earn;
    }
    private void showFinalInformation(){
        videoshelf.showRemainVideos();
        System.out.println("總營業額:"+incoming);
        rentalBase.printAllRentals();
    }
}
