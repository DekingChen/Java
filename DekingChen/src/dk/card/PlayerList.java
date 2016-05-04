package dk.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * 储存玩家列表
 */
public class PlayerList {
	
	public static List<Player> playerlist = new ArrayList<Player>();//储存扑玩家列表
	public static int sum;
	public static List<String> rules = new ArrayList<String>();
	public PlayerList(){
		
	}
	
	public static void setRule(String rule){
		rules.add(rule);
	}
	
	public static String getRules(){
		String str="";
		for(String s:rules){
			str+=s+"\t\n";
		}
		return str;
	}
	
	public static void printRules(){
		show(getRules());
	}
	
	//添加玩家
	public static boolean addplayer(Player player){
		show("添加玩家："+player.toString());
		show("----------------------------------------");
		sum++;
		return playerlist.add(player);
	}
	
	//给所有玩家发牌
	public static void shuffleCardToPlayer(){
			for(Player player:playerlist){
				player.setPoker(CardList.getPoker());
			}
	}
	//玩家要跟一张牌
	public static boolean  getOneCard(int i){
		Player p = playerlist.get(i);
		return p.getPoker().add(CardList.getCard());
	}
	
	//显示发牌结果
	public static void showCard(){
		for(Player player:playerlist){
			show(player.showCard());
			show("----------------------------------------");
		}
	}
	
	//比较牌点大小并且显示赢家信息
	public static void showWinner(){
		Collections.sort(playerlist,new RuleOfComparateCard());
		Player p = playerlist.get(0);
		show(p.showCard());
		show("本局赢家是："+p.getName());
	}
	//比较21点的大小
	public static void showWinnerOf21(){
		Collections.sort(playerlist,new RuleOf21());
		Player p = playerlist.get(0);
		show(p.showCard());
		show("本局赢家是："+p.getName());
	}
	
	//玩家人数
	public static int size(){
		return sum;
	}
	
	public static void show(Object obj){
		System.out.println(obj.toString());
	}
	
	public static void clear(){
		playerlist.clear();
		sum = 0 ;
	}
	
	
}
