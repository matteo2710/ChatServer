import java.net.*;
import java.io.*;

/**
 * Classe per gestire le connessioni dei client in una chat mediante thread.
 */
public class ThreadChatConnessioni implements Runnable {
    private ThreadGestioServizioChat gestoreChat;
    private Socket client = null;
    private BufferedReader input = null;
    private PrintWriter output = null;
    private Thread me;

    /**
     * Costruttore della classe ThreadChatConnessioni.
     * @param gestoreChat Oggetto ThreadGestioServizioChat che gestisce il servizio di chat.
     * @param client Socket del client connesso.
     */
    public ThreadChatConnessioni(ThreadGestioServizioChat gestoreChat, Socket client) {
        this.gestoreChat = gestoreChat;
        this.client = client;
        try {
            this.input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.output = new PrintWriter(client.getOutputStream(), true);
        } catch (Exception e) {
            output.println("Errore");
        }
        me = new Thread(this);
        me.start();
    }

    /**
     * Metodo che avvia il thread per gestire la comunicazione con il client.
     */
    public void run() {
        while (true) {
            try {
                String mex = null;
                while ((mex = input.readLine()) == null) {

                }
                gestoreChat.spedisciMessaggio(mex);

            } catch (Exception e) {
                output.println("Errore");
            }
        }
    }

    /**
     * Metodo per spedire un messaggio alla chat.
     * @param messaggio Il messaggio da spedire.
     */
    public void spedisciMessaggioChat(String messaggio) {
        try {
            output.println(messaggio);
        } catch (Exception e) {
            output.println("Errore");
        }
    }
}
