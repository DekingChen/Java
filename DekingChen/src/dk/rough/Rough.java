
package dk.rough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class Rough extends Show{


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Entity> U = new ArrayList<Entity>();
		int[] entity01 = {1,1,1,2,0};
		int[] entity02 = {1,1,1,1,0};
		int[] entity03 = {2,1,1,2,1};
		int[] entity04 = {3,2,1,2,1};
		int[] entity05 = {3,3,2,2,1};
		int[] entity06 = {3,3,2,1,0};
		int[] entity07 = {2,3,2,1,1};
		int[] entity08 = {1,2,1,2,0};
		int[] entity09 = {1,3,2,2,1};
		int[] entity010 = {3,2,2,2,1};
		int[] entity011 = {1,2,2,1,1};
		int[] entity012 = {2,2,1,1,1};
		int[] entity013 = {2,1,2,2,1};
		int[] entity014 = {3,2,1,1,0};
		Entity e1 = new Entity(1,entity01);
		Entity e2 = new Entity(2,entity02);
		Entity e3 = new Entity(3,entity03);
		Entity e4 = new Entity(4,entity04);
		Entity e5 = new Entity(5,entity05);
		Entity e6 = new Entity(6,entity06);
		Entity e7 = new Entity(7,entity07);
		Entity e8 = new Entity(8,entity08);
		Entity e9 = new Entity(9,entity09);
		Entity e10 = new Entity(10,entity010);
		Entity e11 = new Entity(11,entity011);
		Entity e12 = new Entity(12,entity012);
		Entity e13 = new Entity(13,entity013);
		Entity e14 = new Entity(14,entity014);
		U.add(e1);U.add(e2);U.add(e3);U.add(e4);U.add(e5);
		U.add(e6);U.add(e7);U.add(e8);U.add(e9);U.add(e10);
		U.add(e11);U.add(e12);U.add(e13);U.add(e14);
		//boolean B[] =  {false,true,true,true,false};
		//boolean B1[] = {false,false,false,false,true};
		//show(getB(B)[B.length-1]);
		//Collections.sort(U);//进行多维排序
		//show(U.get(2).toString());
		/*for(Entity list:U){
			show(list.toString());
		}*/
		//List<ArrayList<Entity>> U_B = getU_B(U,B);
	   /*for(ArrayList<Entity> list:U_B){
		   for(Entity e:list){
			   show(e.toString());
		   }
		   show("==============");
	   }*/
	   show("---------------------------------------------");
	  /* List<Entity> pos = getPos(U,B);
	   show("正区域："+pos.size());*/
	   show("---------------------------------------------");
	   /*List<ArrayList<Entity>> u_b = getU_B(U_B.get(8),getB(B));
	  for(ArrayList<Entity> list:u_b){
		   for(Entity e:list){
			   show(e.toString());
		   }
		   show("==============");
	   }*/
	 //  show(getPosOfValue(U,B));
	//   getCore(U, B);
	  /* float a =6;
	   float b=14;
	   float c=a/b;
	   show(c);*/
		
	   int [] a={1,2,3,4};
	   a[0]=11; a[3]=44;
	   for(int i:a)
		   show(i+"===");
	   
	}
	
	//获取属性集合的核
	public static void getCore(List<Entity> U,boolean[] B){
			Collections.sort(U);//进行多维排序
			int pos = getPosOfValue(U, B);
			int red = 0;
			//show(pos);
			for(int i=0;i<B.length-1;i++){
				B[i] = false;
				 red = getPosOfValue(U, B);
				 show(red);
				 if(red==pos){
					 //show(i);
					 //show("POS=="+red);
				 }
				B[i]=true;
			}
		}
	
	//获取属性集合的约简
	public static void getRed(){
			
		}
	
	//计算正区域的方法
	public static List<Entity> getPos(List<Entity> U,boolean[] B){
		
		List<ArrayList<Entity>> U_B = getU_B(U,B);//获取U/B的划分
		//show("POS=="+U_B.get(1).get(0).toString());
		List<Entity> pos = new ArrayList<Entity>();
		for(ArrayList<Entity> list:U_B){
			List<ArrayList<Entity>> u_b = getU_B((List<Entity>)list,getB(B));
			/*for(ArrayList<Entity>ll:u_b){
				for(Entity e:ll){
					show(e.toString());
				}
				show("------------");
			}
			show("=======================================");*/
			if(u_b.size()==1){
				pos.addAll(list);
			}
		}
		return pos;
	}
	
	//计算正区域的方法
	public static int getPosOfValue(List<Entity> U,boolean[] B){
		int pos = 0;
		pos = getPos(U,B).size();
		return pos;
	}
	
	//依据属性集合B输出对应的分类U/B
	public static List<ArrayList<Entity>> getU_B(List<Entity> U,boolean[] B){
		U = SortU(U,B);//根据B对U进行排序
		//储存U/B的分类结果
		List<ArrayList<Entity>> U_B = new ArrayList<ArrayList<Entity>>();
		int s=0,j=0;
		ArrayList<Entity> B1 = new ArrayList<Entity>();
		B1.add(U.get(j));
		U_B.add(B1);
		for(int i =1;i<U.size();i++){
			Entity e1 = U.get(j);
			Entity e2 = U.get(i);
			if(isEqualsOfC(e2,e1,B)){
				B1 = U_B.get(s);
				B1.add(e2);
				U_B.set(s, B1);
			}else{
				s++;
				j = i;
				ArrayList<Entity> B2 = new ArrayList<Entity>();
				B2.add(e2);
				U_B.add(B2);
			}
		}
		return U_B;
	}
	
	//判断两个实体在条件属性C集合下是否是等价类
	public static boolean isEqualsOfC(Entity e1,Entity e2 ,boolean[] B){
		int[] e1_list = e1.getList();
		int[] e2_list = e2.getList();
		for(int i=0;i<B.length;i++){
			if(B[i]){
				if(e1_list[i]!=e2_list[i])
					return false;
			}
			
		}
		return true;
	}
	
	//获取决策变量
	public static boolean[] getB(boolean[] B){
		int len = B.length;		
		for(int j=0;j<len;j++){
			if(j!=len-1)
				B[j] = false;
			else
				B[j] = true;
		}
		return B;
	}
	
	//根据B对U进行排序
	public static List<Entity> SortU(List<Entity> U,boolean[] B){
		int[] sort;
		int len = B.length;
		for(int j=0;j<U.size();j++){
			Entity e = U.get(j);
			Entity newe = new Entity(j,e.getList());
			//show(e.toShow()+"-+-+-+-+-+");
			//show(e.toString()+"++++++++");
			 sort =  e.getList();
			for(int i=0;i<len;i++){
				if(!B[i])
					sort[i] = 0;
			}
			newe.setSort(sort);
			e.setSort(sort);
			U.set(j, e);
			
			show(newe.toString()+"aaaaaaaa");
			U.set(j, e);
		}
		  show("================================");
		for(Entity e:U){
			show(e.toString()+"----");
		}
		 show("================================");
			for(Entity e:U){
				show(e.toShow()+"----");
			}
		Collections.sort(U);
		 
		return U;
	}

}
