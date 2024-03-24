import java.net.*;
import java.io.*;
import javax.swing.*;

/**
 * Classe per gestire il client di chat mediante thread.
 */
public class ThreadChatClient implements Runnable {
    private List lista;
    private Thread me;
    private Socket client;
    private BufferedReader input = null;
    private PrintWriter output = null;

    /**
     * Costruttore della classe ThreadChatClient.
     * @param lista Una lista per memorizzare i messaggi della chat.
     * @param ipServer L'indirizzo IP del server di chat.
     * @param porta La porta su cui il server di chat è in ascolto.
     */
    public ThreadChatClient(List lista, String ipServer, int porta) {
        this.lista = lista;
        try {
            client = new Socket(ipServer, porta);
            this.input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.output = new PrintWriter(client.getOutputStream(), true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connessione al server non riuscita.");
        }
        me = new Thread(this);
        me.start();
    }

    /**
     * Metodo che avvia il thread per gestire la ricezione dei messaggi dal server.
     */
    public void run() {
        while (true) {
            try {
                String mex = null;
                while ((mex = input.readLine()) == null) {

                }
                lista.add(mex);
                lista.select(lista.getItemCount() - 1);
            } catch (Exception e) {
                // Gestisci eventuali eccezioni
            }
        }
    }

    /**
     * Metodo per spedire un messaggio al server di chat.
     * @param messaggio Il messaggio da spedire.
     */
    public void spedisciMessaggioChat(String messaggio) {
        try {
            output.println(messaggio);
        } catch (Exception e) {
            // Gestisci eventuali eccezioni
        }
    }
}
