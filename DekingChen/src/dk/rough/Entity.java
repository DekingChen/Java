package dk.rough;

import java.util.Arrays;

public class Entity implements Comparable<Entity>{
	private int i;//实体记录i
	private int [] list;//实体属性值集合list
	private int [] sort;//用于排序的技术sort
	
	public Entity(int i, int[] list) {
		super();
		this.i = i;
		this.list = list;
		this.sort = null;
	}

	public Entity(int i, int[] list,int[] sort) {
		super();
		this.i = i;
		this.list = list;
		this.sort = sort;
	}

	public int[] getSort() {
		return sort;
	}

	public void setSort(int[] sort) {
		this.sort = sort;
	}

	public int getI() {
		return i;
	}



	public void setI(int i) {
		this.i = i;
	}



	public int[] getList() {
		return list;
	}



	public void setList(int[] list) {
		this.list = list;
	}



	public int compareTo(Entity e){
			for(int j=0;j<this.sort.length;j++){
				if(this.sort[j]>e.getSort()[j])
					return 1;
				else if(this.sort[j]<e.getSort()[j])
					return -1;
				else 
					continue;
				
			}
		return 0;
	}
	
	public String toString(){
		return "index="+this.i+" list="+Arrays.toString(this.list);
	}
	public String toShow(){
		return "sort="+this.i+" sort="+Arrays.toString(this.sort);
	}
	
	
}
