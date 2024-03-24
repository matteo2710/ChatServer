import java.net.*;
import java.io.*;

public class ThreadChatConnessioni implements Runnable{
  private ThreadGestioServizioChat gestoreChat;
  private Socket client=null;
  private BufferReader input=null;
  private PrintWriter output=null;
  Thread me;
  public ThreadChatConnessioni(ThreadGestioServizioChat gestoreChat, Socket client){
    this.gestoreChat = gestoreChat;
    this.client = client;
    try{
      this.input=new BufferReader(new InputStreamReader(client.getInputStream()));
      this.output=new PrintWriter(client.getOutputStream(),true);
    }catch(Exception e){
      outpout.println("Errore");
    }
    me = new Thread(this);
    me.start();
  }
  public void run(){
    while(true){
      try{
        String mex = null;
        while((mex=input.readLine())==null){

        }
        gestoreChat.spedisciMessaggio(mex);

      }catch(Exception e){
        output.println("Errore");
      }
    }
  }
  public void spedisciMessaggioChat(String messaggio){
    try{
      output.println(messaggio);

    }catch(Exception e){
      output.println("Errore");
    }

  }
}