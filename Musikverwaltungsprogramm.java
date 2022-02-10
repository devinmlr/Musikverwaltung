import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Musikverwaltungsprogramm extends JFrame{
    
    DynArray<Musiktitel> liste=new DynArray<Musiktitel>();   
    MusikPlayer mp=new MusikPlayer();
    
    Musikverwaltungsprogramm(){
        
        loadTitles();
        setTitle("Musicplayer");
        setBounds(100,100,300,400);
        setLayout(null);
        
        JList list=new JList(liste);
        JScrollPane sp=new JScrollPane(list);
        sp.setBounds(10,10,220,180);
        add(sp);       
        
        JButton start=new JButton("Start");
        start.setBounds(10,200,100,25);
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mp.stop();
                mp.starteAbspielen(liste.getItem(list.getSelectedIndex()).getDateiname());
            }
        });
        add(start);
        
        JButton stop=new JButton("Stop");
        stop.setBounds(120,200,100,25);
        stop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mp.stop();
            }
        });
        add(stop);
        
        JLabel lTitle=new JLabel("Titel");
        lTitle.setBounds(10,230,60,25);
        add(lTitle);
        JLabel lInterpret=new JLabel("Interpret");
        lInterpret.setBounds(10,260,60,25);
        add(lInterpret);
        
        JTextField tfTitle=new JTextField();
        tfTitle.setBounds(80,230,140,25);
        add(tfTitle);
        
        JTextField tfInterpret=new JTextField();
        tfInterpret.setBounds(80,260,140,25);
        add(tfInterpret);
        
        JButton suchen=new JButton("Suchen");
        suchen.setBounds(10,290,100,25);
        suchen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        add(suchen);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mp.stop();
                System.exit(0);
            }
        });
        
        setVisible(true);
    }
    
    public void loadTitles(){
        liste.append(new Musiktitel("Blurred Lines","Robin Thicke","mp3/Robin Thicke_Blurred Lines.mp3"));
        liste.append(new Musiktitel("David Guetta","Play Hard","mp3/David Guetta_Play Hard.mp3"));
        liste.append(new Musiktitel("Frida Gold","Liebe ist meine Rebellion","mp3/Frida Gold_Liebe ist meine Rebellion.mp3"));
        liste.append(new Musiktitel("Wax","Rosana","mp3/Wax_Rosana.mp3"));
        liste.append(new Musiktitel("Passenger","Let Her Go","mp3/passenger_let her go.mp3"));
        liste.append(new Musiktitel("Icona Pop","I Love It","mp3/icona_pop_-_i_love_it.mp3"));
        
    }
    
    public void show2(){
        System.out.println("Liste("+liste.getLength()+" Einträge):");
        for(int i=0;i<liste.getLength();i++){
            System.out.println(i+": "+liste.getItem(i));
        }
    }
    
    public static void main(String[] args)
    {
        new Musikverwaltungsprogramm();
    }
    
    public boolean titelVorhanden (String titel, String interpret) {
        for (int i=0; i<liste.getLength(); i++) {
            if (liste.getItem(i).getTitel() == titel && liste.getItem(i).getInterpret() == interpret){
                return true;
            }
        }
        return false;
    }
    
    public DynArray<Musiktitel> methode1 (String dateiname) {
        DynArray<Musiktitel> liste2 = new DynArray<Musiktitel>();
        for (int i=0; i<liste.getLength(); i++) {
            Musiktitel mt = liste.getItem(i);
            if (mt.getDateiname().equals(dateiname)) {
                liste2.append(mt);
            }
        }
        return liste2;
    }
}
