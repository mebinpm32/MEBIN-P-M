/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package partb;

import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.File;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author HP
 */
public class Partb {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
         DataInputStream in=new DataInputStream(System.in);
        String pd="pdf";
        String tx="text";
        String filmname,genre,actor,filetype,lang;
        int time;
      
                       
        try {
            
        System.out.println("Enter movie name");
        filmname=in.readLine();
        
                  
        System.out.println("Enter runtime in minutes");
        time=Integer.parseInt(in.readLine());
        String timest=Integer.toString(time);
        
        System.out.println("Enter the language");
        lang=in.readLine();
        
          System.out.println("Enter the name of lead actor");
        actor=in.readLine();
        
          System.out.println("Enter the genre of movie");
        genre=in.readLine();
        
          System.out.println("Choose the type of file to export(type pdf for PDF format or text for text format)");
        filetype=in.readLine();
        
        
        if(filetype.equals(pd))//export to pdf file
        {pdfmethod(filmname,timest,lang,actor,genre);
        
        }
        
        else if(filetype.equals(tx))//export to plain text
        {
                   plaintext(filmname,timest,lang,actor,genre);
        }
        
        else{
        System.out.println("Incorrect file format");
        
        }
             
        }
        
        catch (Exception e) {
                e.printStackTrace();
           }

        
        // TODO code application logic here
    }
    
    public static void pdfmethod(String filmname,String timest,String lang, String actor,String genre)
   
    {
      try{
            
        OutputStream file=new FileOutputStream(new File("helloworld.pdf"));
        Document doc=new Document(PageSize.A4);
        PdfWriter.getInstance(doc, file);
        
        doc.open();
        doc.add(new Paragraph("Movie Name: "+filmname));
        doc.add(new Paragraph("Runtime : "+timest+" minutes"));
        doc.add(new Paragraph("Language: "+lang));
        doc.add(new Paragraph("Lead Actor: "+actor));
        doc.add(new Paragraph("Genre: "+genre));
               
        doc.close();}
      catch (Exception e) {
                e.printStackTrace();
           }
        
    
    }
    
    public static void plaintext(String filmname,String timest,String lang, String actor,String genre)
    {
        try  {
    PrintWriter out= new PrintWriter("text.txt");
        
             
             out.println("Movie NAme: "+filmname);
             out.println("Runtime: "+timest+" minutes");
             out.println("Language: "+lang);
             out.println("Lead Actor: "+actor);
             out.println("Genre: "+genre);
             
             out.close();}
        catch (Exception e) {
                e.printStackTrace();
           }
        
    }
    
}
