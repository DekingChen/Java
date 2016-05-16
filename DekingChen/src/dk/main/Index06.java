package dk.main;

import java.util.ArrayList;
import java.util.Arrays;

import dk.rough.Entity;

public class Index06 extends Show {

	public static void main(String arg[]){
		
		ArrayList<Entity> U = new ArrayList<Entity>();
		int[] entity01 = {1,1,1,2,0};
		int[] entity02 = {1,1,1,1,0};
		int[] entity03 = {2,1,1,2,1};
		Entity e1 = new Entity(1,entity01);
		Entity e2 = new Entity(2,entity02);
		Entity e3 = new Entity(3,entity03);
		U.add(e1);U.add(e2);U.add(e3);
		boolean B[] =  {false,true,true,true,false};
		int sort[]={1,2,3,4,5};
		int sort_list[];
		//sort = null;
		int test[] = {3,3,3,3,3};
		sort = test;
		show(Arrays.toString(sort));
		for(int i=0;i<B.length;i++){
			if(!B[i])
				sort[i] = 0;
		}
		show(Arrays.toString(sort));
		Entity ee = U.get(0);
		ee.setSort(sort);
		show(ee.toShow());
		show(ee.toString());
		show("fuckyourmother----------");
		int len = B.length;
		//int u_len = U.size();
		/*for(int j=0;j<u_len;j++){
			Entity e = U.get(j);
			//int[] list = e.getList();
			//show(Arrays.toString(list));
			sort_list =  e.getSort();
			// show(e.toString()+"----------------");
			// show(e.toShow()+"+++++++++++++++++++");
			for(int i=0;i<len;i++){
				if(!B[i])
					sort_list[i] = 0;
			}		
			//sort_list = test;
			//e.setList(list);
			e.setSort(sort_list);
			//show(e.toString()+"*************");
			//show(e.toShow()+"+-+-+-+-+-+-+--+-");
			//U.set(j, e);
			//sort_list = null;
		}*/
		
		show("================================");
		for(Entity e3e:U){
			sort_list =  e3e.getList();
			e3e.setSort(sort_list);
			//int[] l = e3e.getList();
 			for(int i=0;i<len;i++){
				if(!B[i])
					sort_list[i] = 0;
			}
			show(e3e.toString()+"----");
			show(e3e.toShow());
		}
	}
	public static void test01(){

	}
}
