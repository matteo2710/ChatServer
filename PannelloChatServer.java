public class PannelloChatServer extends JPanel{
public PannelloChatServer {
  super();
  this.setBackground(new Color(50, 100, 255));
  Jpanel panLista = new Jpanel(new BorderLayout(20, 5));
  panLista.setBackground(new Color(50, 100, 255));
  lista = new List();
  lista.setBackground(Color.lightgray);
  lista.setSize(100, 50);
  lista.setVisible(true);
  Jlabel chat1 = new Jlabel("Chat", Jlabel.CENTER);
  chat1.setForground(new Color(200, 100, 100));
  JLabel chat2 = new JLabel("Chat", JLabel.CENTER)
  chat2.setForground(new Color(200, 100, 100))
  panLista.add(chat1, BorderLayout.WEST);
  panLista.add(chat2, BorderLayout.EAST)
  panLista.add(lista, BorderLayout.CENTER);
  Jpannel nuovoMex = new Jpanel(new BorderLayout(20, 5));
  nuovoMex.setBackground(new Color(50, 100, 255));
  JLabel labNuovo = new JLabel("Nuovo Messaggio", JLabel.CENTER);
  labNuovo.setForeground(new Color(255, 255, 0));
  textNuovo = new JtextField("");
  JButton buttonInvia = new JButton("Invia");
  buttonInvia.addAdActionListener(this);
  nuovoMex.add(labNuovo, BorderLayout.WEST);
  nuovoMex.add(textNuovo, BorderLayout.CENTER);
  nuovoMex.add(buttonInvia, BorderLayout.EAST);
  this.setLaout(new BorderLayout(0, 5));
  add(panLista, BorderLayout.CENTER);
  add(nuovoMex, BorderLayout.SOUTH);
  connetti();
  }

public void connetti(){
  gestioneServizio = new ThreadGestioneServizioChat(10, lista);

}
public void actionPerfomed(ActionEvent e){
  String bottone = e.getActionCommand();
  if(bottone.equals("Invia")){
    gestioneServizio.spedisciMessaggio(textNuovo.getText());
    textNuovo.setText("");
  }

}
}
