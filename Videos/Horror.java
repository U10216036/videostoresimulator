

package Videos;

public class Horror extends Video {

    public Horror(String videoName) {
        super(videoName, 30);
    }

    @Override
    public void printInformation() {
        System.out.println("Video Name:" + videoName);
        System.out.println("Video Type: " + "Horror");
        System.out.println("Video Price:" + videoPrice);
    }
}


