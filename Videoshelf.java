/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videostoresimulator;


import Videos.Comedy;
import Videos.Drama;
import Videos.Horror;
import Videos.NewRelease;
import Videos.Romance;
import Videos.Video;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author owner
 */
public class Videoshelf {
    private final List<Video> videos;
    private Video newRelease;
    private Video comedy;
    private Video drama;
    private Video romance;
    private Video horror;
    private final String[] NewReleaseName = {"復仇者聯盟3","一級玩家","毀滅大作戰","死侍2"}; 
    private final String[] ComedyName = {"大獨裁者落難記","王牌天神","麻辣間諜","豆豆秀"}; 
    private final String[] DramaName = {"玩命再劫","寂寞拍賣師","告白","不存在的房間"}; 
    private final String[] RomanceName = {"戀夏500日","P.S我愛你","生命中的美好缺憾 ","我就要你好好的"}; 
    private final String[] HorrorName = {"七夜怪譚","逃出絕命鎮","安娜貝爾","牠"}; 
	//when new a video shelf it will load all the videos and show all the video
    public Videoshelf(){
        videos = new ArrayList<>(); 
        loadvideos();
        showAllVideos();
    }
    //load all videos
    private void loadvideos(){
        for(int i =0;i<4;i++){
            newRelease = new NewRelease(NewReleaseName[i]);
            videos.add(newRelease);
        }
        for(int i =0;i<4;i++){
            comedy = new Comedy(ComedyName[i]);
            videos.add(comedy);

        }
        for(int i =0;i<4;i++){
            drama = new Drama(DramaName[i]);
            videos.add(drama);
        }
        for(int i =0;i<4;i++){
            romance = new Romance(RomanceName[i]);
            videos.add(romance);
        }
        for(int i =0;i<4;i++){
            horror = new Horror(HorrorName[i]);
            videos.add(horror);
        }
    }
	//show all videos
	private void showAllVideos(){
        System.out.println("所有影片");
        for(int i =0;i< videos.size();i++){
            videos.get(i).printInformation();
        }
      
	}    
    //show remain videos in the list videos
    public void showRemainVideos(){
      System.out.println("剩餘影片(共"+getTotalVideoNum()+"部)");
      for(int i =0;i< videos.size();i++){
          System.out.println(videos.get(i).getVideoName());
      }
      
    }
    //get the video
	public Video getVideo(int whichVideo) {
        Video video = videos.get(whichVideo);
        videos.remove(whichVideo);
        return video;
	}
	//add back the video to list videos
	public void returnVideo(Video v){
       videos.add(v);
	}
	//get the number of videos in list videos
	public int getTotalVideoNum(){
       return videos.size();
	}
    
}

