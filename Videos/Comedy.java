

package Videos;

public class Comedy extends Video {

    public Comedy(String videoName) {
        super(videoName, 10);
    }

    @Override
    public void printInformation() {
        System.out.println("Video Name:" + videoName);
        System.out.println("Video Type: " + "Comedy");
        System.out.println("Video Price:" + videoPrice);
    }

   
}
