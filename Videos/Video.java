package Videos;

public abstract class Video {
    protected String videoName;
    protected int videoPrice;
    protected boolean isReturned;
    public Video (String videoName, int videoPrice) {
		this.videoName = videoName;
        this.videoPrice = videoPrice;
    }
	//get the video price
    public int getPrice() {
		return videoPrice;
    }
    public abstract void printInformation();
	//get the video name
    public String getVideoName(){
        return videoName;
    }
}
