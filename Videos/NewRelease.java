

package Videos;


public class NewRelease extends Video {

    public NewRelease(String videoName) {
        super(videoName, 50);
    }

    @Override
    public void printInformation() {
        System.out.println("Video Name:" + videoName);
        System.out.println("Video Type: " + "NewRelease");
        System.out.println("Video Price:" + videoPrice);
        
    }

   
}

    
    

