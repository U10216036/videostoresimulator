/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package videostoresimulator;

/**
 *
 * @author owner
 */

package videostoresimulator;



public class VideoStoreSimulator {

    
    public static void main(String[] args) {
    /**
     * @param args the command line arguments
     */        
        // TODO code application logic here
		//new VideoStore and start simulate 34 days
        VideoStore videoStore = new VideoStore();
        videoStore.simulateStart(34);
    }
    
}
