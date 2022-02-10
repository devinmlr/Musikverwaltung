public class Musiktitel{
   private String titel;
   private String interpret;
   private String dateiname;

    /**
     * Konstruktor für Objekte der Klasse Musiktitel
     */
    public Musiktitel(String pTitel,String pInterpret, String pDateiname){
        titel=pTitel;
        interpret=pInterpret;
        dateiname=pDateiname;
    }
    
    public String getTitel(){
        return titel;
    }
    
    public String getInterpret(){
        return interpret;
    }
    
    public String getDateiname(){
        return dateiname;
    }
    
    public String toString(){
        return titel+" - "+interpret;
    }

}
