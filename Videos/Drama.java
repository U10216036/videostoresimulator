

package Videos;


public class Drama extends Video {

    public Drama(String videoName) {
        super(videoName, 20);
    }

    @Override
    public void printInformation() {
        System.out.println("Video Name:" + videoName);
        System.out.println("Video Type: " + "Drama");
        System.out.println("Video Price:" + videoPrice);
        
    }
}

