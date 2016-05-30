package dk.design.singleton;

public class Singleton {
		private static class SingletonHolder {  
	        static Singleton instance = new Singleton();  
	    }  
	    public static Singleton getInstance() {  
	        return SingletonHolder.instance;  
	    }  
	    private Singleton(){ }  
}
