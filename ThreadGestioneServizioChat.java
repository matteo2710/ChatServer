import javax.swing.JOptionPane;


public class ThreadGestioneServizioChat implements Runnable {
    private int nrMaxconnessioni;
    private List lista; 
    private ThreadChatConnessioni[] listaConnessioni;
    Thread ae;
    private ServerSocket serverChat;

    public ThreadGestioneServizioChat(int numeroMaxConnessioni, list lista){
        this.nMaxConnessioni = nrMaxConnessioni-1;
        this.lista = lista;
        this.listaConnessioni = new ThreadChatConnessioni[this.ntMaxConnessioni];
        ae = new Thread(this);
        ae.start();

    }

    public void run(){
        boolean continuo = true;
        try{
            serverChat = new ServerSocket(6789);

        }
        catch(Exception e){
            JOptionPane.showMessaggeDialog(null,"No intanziare");
            continua = false;

        }
    if(continua){
        try{
            for(int xx = 0;xx<ntMaxConnessioni;xx++){
                Socket tempo = null;
                tempo = serverChat.accept();
                listaConnessioni[xx]=new ThreadChatConnessioni(this.tempo);

            }
            serverChat.close();

        }
        catch(Exeption e){
            JOptionPane.showMessageDialog(null, "NO instanziare");
        }
    }
    }
  public void spedisciMessaggio(String mex){
    lista.add(mex);
    lista.select(lista.getItemCount()-1);
    for(int xx = 0;xx<ntMaxConnessioni;xx++){
      if(listaConnessioni[xx]!=null){
        listaConnessioni[xx].spedisciMessaggioChat(mex);
      }
    }
  }