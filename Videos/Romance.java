

package Videos;

public class Romance extends Video {

    public Romance(String videoName) {
        super(videoName, 50);
    }

    @Override
    public void printInformation() {
        System.out.println("Video Name:" + videoName);
        System.out.println("Video Type: " + "Romance");
        System.out.println("Video Price:" + videoPrice);
        
    }

   
}
