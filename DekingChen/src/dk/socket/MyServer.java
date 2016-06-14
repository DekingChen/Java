package dk.socket;

import java.io.*;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.logging.Level;  
import java.util.logging.Logger;  
  
public class MyServer {  
  
    private final static Logger logger = Logger.getLogger(MyServer.class.getName());  
      
    public static void main(String[] args) throws IOException {  
        @SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(10000);  
		System.out.println("****服务器即将启动，等待客户端连接****");
        while (true) {  
            Socket socket = server.accept();  
            invoke(socket);  
        }  
    }  
  
    private static void invoke(final Socket socket) throws IOException {  
        new Thread(new Runnable() {  
            public void run() {  
                ObjectInputStream is = null;  
                ObjectOutputStream os = null;  
                try {  
                    is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
                    os = new ObjectOutputStream(socket.getOutputStream());  
  
                    Object obj = is.readObject();  
                    User user = (User)obj;  
                    System.out.println("user: " + user.getName() + ":" + user.getPassword());  
  
                    user.setName(user.getName() + "_new");  
                    user.setPassword(user.getPassword() + "_new");  
                    //User new_user = new User("DekingChen01","Java");
                    os.writeObject(user);  
                   // os.writeObject(new_user);  
                    os.flush();  
                } catch (IOException ex) {  
                    logger.log(Level.SEVERE, null, ex);  
                } catch(ClassNotFoundException ex) {  
                    logger.log(Level.SEVERE, null, ex);  
                } finally {  
                    try {  
                        is.close();  
                    } catch(Exception ex) {}  
                    try {  
                        os.close();  
                    } catch(Exception ex) {}  
                    try {  
                        socket.close();  
                    } catch(Exception ex) {}  
                }  
            }  
        }).start();  
    }  
}  