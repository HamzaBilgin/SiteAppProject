
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author hamza
 */
public class ChannelOperations {
    private String ch;
    private String web;
    private boolean thereIs=false;
    private boolean control=true;
    private Queue<String> queue = new LinkedList<String>();

    @Override
    public String toString() {
        return "ChannelOperations{" + "queue=" + queue + '}';
    }

    public ChannelOperations() {
    }

   

    

    

   
    
    

    public ChannelOperations(String ch, String web) {
        this.ch = ch;
        this.web = web;
    }
    
    public  ChannelOperations(String ch) throws FileNotFoundException{
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("channelList.txt")));
        
        
        
        while (scanner.hasNextLine()) {
             Queue<String> queue = new LinkedList<String>();
             String ch_info = scanner.nextLine();    
                

             String[] array = ch_info.split("-");
             String webb = array[1];
             String chh = array[0];
              System.out.println("4");
             if(chh.equals(ch)){
                 this.control=false;
                 this.web=webb;
                 break;
               
             }
            
        }
        
        
        
        
    }
    
    public static void saveChannel(String ch,String web) throws FileNotFoundException{
       FileWriter veriyazma = null;
        
        
        
        try {
            veriyazma = new FileWriter("channelList.txt",true);
            veriyazma.write(ch+"-"+web+"\n");
            
        } catch (IOException ex) {
            System.out.println("Hata");
        }
        finally {
            
            if (veriyazma != null) {
                try {
                    veriyazma.close();
                } catch (IOException ex) {
                    System.out.println("Dosya Kapatılırken bir hata oluştu...");
                }
                
            }
        }
       
        
    }
    public static void empty(){
        FileWriter veriyazma = null;
        
        
        
        try {
            veriyazma = new FileWriter("channelList.txt",true);
            
            
        } catch (IOException ex) {
            System.out.println("Hata");
        }
        finally {
            
            if (veriyazma != null) {
                try {
                    veriyazma.close();
                } catch (IOException ex) {
                    System.out.println("Dosya Kapatılırken bir hata oluştu...");
                }
                
            }
        }
        
    }
    public static void close(){
        File f = new File("C:\\Users\\hamza\\Desktop\\AtmÇalışması\\00-SiteApplication\\channelList.txt");
        f.delete();
    }
    
    

//    public boolean makeKontrol(){
//        if(control)
//        
//    }
    public void openChannel(String web_name){
        String s = "https://" + web_name +".com/";
      Desktop d = Desktop.getDesktop();
      
        try {
            d.browse(new URI(s));
            
            Class<? extends Desktop> aClass = d.getClass();
            
            System.out.println(aClass);
        } catch (URISyntaxException ex) {
            Logger.getLogger(SiteApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SiteApplication.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    public void openChannel2(String web_name2){
        String s = web_name2;
      Desktop d = Desktop.getDesktop();
      
        try {
            d.browse(new URI(s));
            
            Class<? extends Desktop> aClass = d.getClass();
            
            System.out.println(aClass);
        } catch (URISyntaxException ex) {
            Logger.getLogger(SiteApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SiteApplication.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    public static void deleteFile(File f){
        f.deleteOnExit();
    }
    public static boolean checkIt(String ch){
        String save = ch +"__save_radio";
        String delete = ch + "_delete_radio";
        return false;
       
    }
    

    public boolean isThereIs() {
        return thereIs;
    }

    public void setThereIs(boolean thereIs) {
        this.thereIs = thereIs;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    public boolean isControl() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }

    void deleteFile(String channeListtxt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
     public Queue<String> getQueue() {
        return queue;
    }

    public void setQueue(Queue<String> queue) {
        this.queue = queue;
    }
    

}
