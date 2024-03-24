import javax.swing.*;
import java.awt.*;

/**
 * Classe per il frame del server di chat.
 */
public class ChatServer extends JFrame {
    
    /**
     * Costruttore della classe ChatServer.
     */
    public ChatServer() {
        super("Chat Server");
        this.setSize(new Dimension(500, 300));
        this.setLocationRelativeTo(null);
        this.setEnabled(true);
        this.setBackground(Color.blue);
        
        // Creazione e aggiunta del pannello della chat al frame
        PannelloChatServer pan = new PannelloChatServer();
        this.getContentPane().add(pan);
        
        this.setVisible(true);
    }
}
