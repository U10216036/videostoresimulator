/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Customer;
import Videos.Video;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/**
 *
 * @author owner
 */
public abstract class Customer {
    protected String customerName;
    protected Random rand;
    protected int maxRentNumber;
    private int remainvideoNum;
    protected  List<Video> rentedVideos;
    public Customer(String name,int maxRentNum){
        this.customerName = name;
        this.maxRentNumber = maxRentNum;
        remainvideoNum = 3;
        rand = new Random();
        rentedVideos = new ArrayList<>();
    }

    public abstract int getRentDay();
    public abstract int getRentVideoNum();
    public abstract void printInformation();
    public String getCustomerName(){
        return customerName;
    }
	//get the rented video
    public void getRentedVideo(Video rentedVideo){
       this.rentedVideos.add(rentedVideo);
    }
	//update the number customer can rent
    public void changeRemainVideoNum(int num) {
	remainvideoNum -= num;
    }
	//Check the customer can rent videos or not
    public boolean isRentable(int rentNum, int videoNumInStore) {
		if (remainvideoNum >= rentNum && videoNumInStore >= rentNum ) {
            return true;
		}
        return false;
    }
    
	//return the video
    public List<Video> returnVideo(List<String> returnVideoName){
        List<Video> returnedVideos = new ArrayList<>();
        System.out.println(getCustomerName()+"還了這些影片:");

        for(int i =0;i<returnVideoName.size();i++){
            Iterator<Video> rentedVideosIt = rentedVideos.iterator();
            while(rentedVideosIt.hasNext()){
                Video rentedVideo = rentedVideosIt.next();
                if(rentedVideo.getVideoName().equals(returnVideoName.get(i))){
                    System.out.println(returnVideoName.get(i));
                    returnedVideos.add(rentedVideo);
                    rentedVideosIt.remove();
                }
            }  
        }
        //give back the customer rent video number
        changeRemainVideoNum((returnedVideos.size()*-1));
        return returnedVideos;
    }
   
}
