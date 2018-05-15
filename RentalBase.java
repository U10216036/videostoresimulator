/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videostoresimulator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author owner
 */

public class RentalBase {
    private final List<Rental> activeRentals;
    private final List<Rental>  completedRentals;
	
    public RentalBase() {
        activeRentals = new ArrayList<>();
        completedRentals = new ArrayList<>();
    }
	//update all active rentals' remain day 
    public void updateAllActiveRentals() {
        for (int i=0;i<activeRentals.size();i++) {
		    activeRentals.get(i).updateRemainDays();
	    }
    }
	//add active rentals to list addActiveRental
    public void addActiveRental(Rental activeRental) {
        activeRentals.add(activeRental);
    }
	//get the size of list addActiveRental
    public int getActiveRentalsSize(){
         return activeRentals.size();
    }
    //get active rental
    public Rental getActiveRental(int whichRental){
         Rental activeRental = activeRentals.get(whichRental);
         return activeRental;
    }
	//remove the active rental which remain day is 0
    public void removeActiveRentalZeroDays(){
        Iterator<Rental> activeRentalIt = activeRentals.iterator();
        while(activeRentalIt.hasNext()){
            Rental activeRental = activeRentalIt.next();
            if(activeRental.getRemainDays()==0){
                 activeRentalIt.remove();
            }
        }
    }
	//add to completed rental
    public void addCompletedRentals(Rental activeRental) {
        completedRentals.add(activeRental);
    }
    //show all information of active rentals and completed rentals
    public void printAllRentals() {
        System.out.println("All Active Rentals");
        for (int i=0;i<activeRentals.size();i++) {
		    activeRentals.get(i).showRentalInformation();
	    }
        System.out.println("All Completed Rentals");
        for (int j=0;j<completedRentals.size();j++) {
		    completedRentals.get(j).showRentalInformation();
	    }
    }
}
