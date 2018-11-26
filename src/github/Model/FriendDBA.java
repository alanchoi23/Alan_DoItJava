package github.Model;

import java.util.ArrayList;

public interface FriendDBA {
	//추가
	//보기
	//검색
	public void friendInsert(Friend f);
	public ArrayList<Friend> friendView();
	public ArrayList<Friend> friendSearch(String ft1, int idx);
}
