package board.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class BroadcastInfo {
	
	private List<String> twitchStreamerList = new ArrayList<String>();
	private List<String> twitchIdList = new ArrayList<String>();
	private List<String> twitchThumbNailList = new ArrayList<String>();
	
	private List<String> youtubeStreamerList = new ArrayList<String>();
	private List<String> youtubeIdList = new ArrayList<String>();
	
	public BroadcastInfo(){
		init();
		init2();
	}
	
	private void init() {
		try {
			URL url = new URL("https://api.twitch.tv/kraken/streams/?game=Kartrider&client_id=sf8es2aikfu59dviy9wfo8wrryppqc&api_version=5");
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.connect();
			
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			JsonArray streams = root.getAsJsonObject().get("streams").getAsJsonArray();
			for (JsonElement stream : streams) {
				JsonElement channel = stream.getAsJsonObject().get("channel");
				String temp1 = String.valueOf(channel.getAsJsonObject().get("display_name"));
				int temp2 = temp1.length()-1;
				temp1 = temp1.substring(1,temp2);
				twitchStreamerList.add(temp1);
				
				String temp3 = String.valueOf(channel.getAsJsonObject().get("url"));
				int temp4 = temp3.length() - 1;
				temp3 = temp3.substring(1, temp4);
				twitchIdList.add(temp3);
				
				String temp5 = String.valueOf(channel.getAsJsonObject().get("logo"));
				// video_banner, profile_banner, logo
				int temp6 = temp5.length() - 1;
				temp5 = temp5.substring(1, temp6);
				twitchThumbNailList.add(temp5);
			}
			request.disconnect();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	private void init2() {
		try {
//			URL url = new URL("https://www.googleapis.com/youtube/v3/search?eventType=live&part=snippet&" + 
//					"key=AIzaSyA7QV6eEIc5MSdGYxPh-3_LPX6IDE_3HvU&q=%EC%B9%B4%ED%8A%B8%EB%9D%BC%EC%9D%B4%EB%8D%94&type=video");
//			HttpURLConnection request = (HttpURLConnection) url.openConnection();
//			request.connect();
//			
//			JsonParser jp = new JsonParser();
//			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//			JsonArray streams = root.getAsJsonObject().get("items").getAsJsonArray();
//			for (JsonElement stream : streams) {
//				JsonElement channel1 = stream.getAsJsonObject().get("snippet");
//				String temp1 = String.valueOf(channel1.getAsJsonObject().get("channelTitle"));
//				int temp2 = temp1.length();
//				temp1 = temp1.substring(1, temp2 - 1);
//				youtubeStreamerList.add(temp1);
//				
//				JsonElement channel2 = stream.getAsJsonObject().get("id");
//				String temp3 = String.valueOf(channel2.getAsJsonObject().get("videoId"));
//				int temp4 = temp3.length();
//				temp3 = temp3.substring(1, temp4 - 1);
//				youtubeIdList.add("https://www.youtube.com/watch?v=" + temp3);
//			}
//			request.disconnect();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public List<String> getTwitchStreamer(){
		return twitchStreamerList;
	}
	
	public List<String> getTwitchId(){
		return twitchIdList;
	}
	
	public List<String> getTwitchThumbNail(){
		return twitchThumbNailList;
	}
	
	public List<String> getYoutubeStreamer(){
		return youtubeStreamerList;
	}
	
	public List<String> getYoutubeId(){
		return youtubeIdList;
	}
}
