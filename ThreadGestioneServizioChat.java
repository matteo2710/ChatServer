import javax.swing.JOptionPane;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Classe per gestire il servizio di chat mediante thread.
 */
public class ThreadGestioneServizioChat implements Runnable {
    private int nrMaxConnessioni;
    private List lista;
    private ThreadChatConnessioni[] listaConnessioni;
    private Thread ae;
    private ServerSocket serverChat;

    /**
     * Costruttore della classe ThreadGestioneServizioChat.
     * @param numeroMaxConnessioni Il numero massimo di connessioni consentite.
     * @param lista Una lista per memorizzare i messaggi della chat.
     */
    public ThreadGestioneServizioChat(int numeroMaxConnessioni, List lista) {
        this.nrMaxConnessioni = numeroMaxConnessioni - 1;
        this.lista = lista;
        this.listaConnessioni = new ThreadChatConnessioni[this.nrMaxConnessioni];
        ae = new Thread(this);
        ae.start();
    }

    /**
     * Metodo che avvia il thread per gestire il servizio di chat.
     */
    public void run() {
        boolean continuo = true;
        try {
            serverChat = new ServerSocket(6789);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errore durante l'istanziazione del server.");
            continuo = false;
        }

        if (continuo) {
            try {
                for (int xx = 0; xx < nrMaxConnessioni; xx++) {
                    Socket tempo = null;
                    tempo = serverChat.accept();
                    listaConnessioni[xx] = new ThreadChatConnessioni(this, tempo);
                }
                serverChat.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Errore durante l'istanziazione del server.");
            }
        }
    }

    /**
     * Metodo per spedire un messaggio a tutti i client connessi alla chat.
     * @param mex Il messaggio da spedire.
     */
    public void spedisciMessaggio(String mex) {
        lista.add(mex);
        lista.select(lista.getItemCount() - 1);
        for (int xx = 0; xx < nrMaxConnessioni; xx++) {
            if (listaConnessioni[xx] != null) {
                listaConnessioni[xx].spedisciMessaggioChat(mex);
            }
        }
    }
}
