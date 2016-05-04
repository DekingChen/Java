/**
 * 
 */
package dk.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import dk.card.Card;
import dk.card.CardList;
import dk.card.Player;
import dk.card.PlayerList;
import dk.card.RuleOf21;

/**
 * @author Administrator
 *
 */
public class Index05 extends Show {
	
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * 调用的主方法
	 * @param args
	 */
	public static void main(String[] args) {
		
		show("是否开始游戏?0/1");
		int isStart = scanner.nextInt();
		if(isStart==1){
			show("请选择游戏?0：扑克牌比较大小游戏/1:21点游戏");
			int gameType = scanner.nextInt();
			switch(gameType){
			case 0:startGame();break;
			case 1:startGameOf21();	break;
			default:
				show("游戏不存在！！！");
				break;
			}
			
		}	
		else{
			show("退出游戏！");
		}
		
		
	}
	
	//启动21点游戏
	public static void startGameOf21(){	
		show("二十一点的游戏比较的基本规则:");
		PlayerList.setRule("1.如果博弈各方只有两张牌：A+X(A,10,J,Q,K)组合最大，");
		PlayerList.setRule("2.所有手牌的点数加起来和等于21的最大，超过21点的最小，以此类推21>20>....1>22>23...50【除去1中的情况，即不存在有1中的组合，如果存在1中情况的比其他博弈方都大，即使对方是21点】");
		PlayerList.setRule("3.如果在2请情况下，当手牌总点数有相等情况，则有5张牌的玩家比不是5张手牌的玩家大");
		PlayerList.setRule("4.总的牌数只有52张，没有大小王");
		PlayerList.setRule("4.牌A可以当做点1、点11来用。");
		PlayerList.setRule("5.博弈各方手上牌数最多为5张。");
		PlayerList.printRules();
			int players = 3;//默认玩家数目
			int cardofplay = 2;//默认每个玩家的手牌数目
			try {
					show("开始输入玩家信息:");
					for(int i=0;i<players;i++){
						show("请输入第"+(i+1)+"个玩家姓名:");
						String name = scanner.next();
						Player p =new Player("00"+i,name);
						PlayerList.addplayer(p);
					}
					show("一副没有洗的牌：");
					CardList.generateCard();//生成一副扑克
					CardList.printCardList();//打印扑克
					show("========================================");
					show("开始洗牌：........洗牌中......洗牌完成");
					CardList.shuffleCard();//洗牌
					show("========================================");
					show("开始发牌：........发牌中......发牌完成");					
					CardList.dealCard(players,cardofplay);//发牌
					PlayerList.shuffleCardToPlayer();//给玩家发牌
					for(int i=0;i<players;i++){
						Player player = PlayerList.playerlist.get(i);
						show("第"+(i+1)+"玩家的发牌结果:\t\n"+player.showCard());
						boolean isContinue = true;
						int count = 2;
						while(isContinue){
							show("是否要牌?0/1");
							int isGo = scanner.nextInt();
							if(isGo==1&&count<=4){
								count++;
								PlayerList.getOneCard(i);
								show("第"+(i+1)+"位玩家的要牌后结果:\t\n"+player.showCard());
							}else{
								isContinue=false;
							}
						}
						show("===============第"+(i+1)+"位玩家要牌结束================");

					}
					show("========================================");
					show("要牌结束：");
					PlayerList.showCard();//显示所有玩家牌信息
					show("========================================");
					show("比较结果并且显示赢家信息");
					PlayerList.showWinnerOf21();//显示本轮赢家
					show("========================================");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	//启动比较扑克大小游戏
	public static void startGame(){
		show("游戏规则如下:");
		PlayerList.setRule("1.至少需要两名玩家");
		PlayerList.setRule("2.所有玩家的牌数加起来不超过52张牌");
		PlayerList.setRule("3.比较所有玩家手中最大的牌点，最大的牌点数的玩家获胜");
		PlayerList.setRule("4.总的牌数只有52张，没有大小王");
		PlayerList.setRule("5.黑桃牌A最大，方块3最小，点数相同时，比较花色，黑桃较大。");
		PlayerList.printRules();
		show("请输入玩家人数：");
		int players = 2;//默认玩家数目
		int cardofplay = 2;//默认每个玩家的手牌数目
		try {
			 players = scanner.nextInt();
				while(players<2){
					show("玩家人数至少是两人");
					show("请重新输入人数：");
					players = scanner.nextInt();
				}
			
				show("请输入每个玩家持有的牌数：");	
				cardofplay = scanner.nextInt();
				while(cardofplay*players>52){
					show("玩家*牌数超出范围！请重新输入牌数");
					cardofplay = scanner.nextInt();
				}
				
				show("开始输入玩家信息:");
				for(int i=0;i<players;i++){
					show("请输入第"+(i+1)+"个玩家姓名:");
					String name = scanner.next();
					Player p =new Player("00"+i,name);
					PlayerList.addplayer(p);
				}
				show("一副没有洗的牌：");
				CardList.generateCard();//生成一副扑克
				CardList.printCardList();//打印扑克
				show("========================================");
				show("开始洗牌：");
				CardList.shuffleCard();//洗牌
				show("========================================");
				show("开始发牌：........发牌中......");
				CardList.dealCard(players,cardofplay);//发牌
				PlayerList.shuffleCardToPlayer();//给玩家发牌
				show("发牌结果：");
				PlayerList.showCard();//显示所有玩家牌信息
				show("========================================");
				show("比较结果：比较牌点大小并且显示赢家信息");
				PlayerList.showWinner();//显示本轮赢家
				show("========================================");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//清空游戏
	public static void clearGame(){
			CardList.clear();
			PlayerList.clear();
	}
	
	//测试比较扑克游戏
	public static void testGame(){
		try {
			show("一副没有洗的牌：");
			CardList.generateCard();
			CardList.printCardList();
			show("========================================");
			show("开始添加玩家：");
			Player p =new Player("001","DekingChen");
			Player p1 =new Player("002","chenzhenquan");
			Player p2 =new Player("003","czq");
			PlayerList.addplayer(p);
			PlayerList.addplayer(p1);
			PlayerList.addplayer(p2);
			show("开始洗牌：");
			CardList.shuffleCard();
			show("========================================");
			show("开始发牌：........发牌中......");
			int players =  PlayerList.size();//玩家数目
			int cardofsum = 3;//每个玩家的手牌数目
			CardList.dealCard(players,cardofsum);
			PlayerList.shuffleCardToPlayer();
			show("发牌结果：");
			PlayerList.showCard();
			show("========================================");
			show("比较结果：比较牌点大小并且显示赢家信息");
			PlayerList.showWinner();
			show("========================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//测试21点游戏
 	public static void testGame21(){
		List<Player> playerlist = new ArrayList<Player>();//储存扑玩家列表	
		List<Card> list = new ArrayList<Card>();
		List<Card> list01 = new ArrayList<Card>();
		List<Card> list02 = new ArrayList<Card>();
		//玩家1牌点
		Card c = new Card(8,1);
		Card cc =new Card(1,2);
		list.add(c);
		list.add(cc);
		//玩家2牌点
		Card a = new Card(4,1);
		Card aa = new Card(4,2);
		Card b = new Card(4,3);
		Card bb = new Card(4,4);
		Card bbb = new Card(5,4);
		list01.add(a);
		list01.add(aa);
		list01.add(b);
		list01.add(bb);
		list01.add(bbb);
		//玩家3牌点
				Card d = new Card(10,2);
				Card dd = new Card(1,3);
				list02.add(d);
				list02.add(dd);
		//创建玩家
		Player p =new Player("001","DekingChen");
		Player p1 =new Player("002","chenzhenquan");
		Player p2 =new Player("003","czq");
		p.setPoker(list);
		p1.setPoker(list01);
		p2.setPoker(list02);
		playerlist.add(p);
		playerlist.add(p1);
		playerlist.add(p2);
		Collections.sort(playerlist,new RuleOf21());
		for(Player pp:playerlist){
			show(pp.showCard());
		}
	
	}
	
}
