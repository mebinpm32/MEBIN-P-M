# MEBIN-P-M
Programming Challenge: Movie Aggregator  
Part A:  Create a console-based application that accepts movie details like Name, Run Time, Language, Lead Actor and Genre and then export these details into one of the 2 formats, depending on user’s choice - “plain text” or “PDF”. 
Part B:  Make the application extensible so that it is easy to “plug in” a new format and the application automatically has the capability to export to the new format without making any changes to the application code.

Here the application code is written in java language, which is developed using netbeans ide.
In order run the file you need to download the file named "challange.rar". Extract and open it with a Netbeans IDE.
Click on the run build to build the code and click on run button to run the program.

import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.File;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import java.io.FileOutputStream;
import java.io.OutputStream;

Above code section import the required libraries for the running the program.
In the main user inputs are taken using datainputstream class. Then these user inputs are stored in string variables.

For exporting to required file format. We may ask to the user whether you want text or pdf file.
Program ask the user to type "text" for plain text and "pdf" for PDF file.
Type the required file format.

Then it  compare "text" and "pdf" string to find the match using equals() method

If either of the formats matched it will execute the method for creating the corresponding file format and it is saved in the program folder.

For creating plain text file, 
function named "plaintext" is called, which creates text file using the PrintWriter class.
For creating text file, create an object for the PrintWriter class. Specify the filename with .txt exension.
Using PrintWriter class the userinputs are printed on the ram and then it is closed to finish the creation.

For creating pdf file,
function named "pdfmethod" is called, which uses an external pdf library called itext to create pdf file.


As said in PART B, for future to support more formats, a function for to create that file is added to the existing code along with a else if condition.

The entire code is given below

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
        {          pdfmethod(filmname,timest,lang,actor,genre);
        
        }
        
        else if(filetype.equals(tx))//export to plain text
        {
                   plaintext(filmname,timest,lang,actor,genre);
        }
        
        else
        {
                   System.out.println("Incorrect file format");
        
        }
             
        }
        
        catch (Exception e) 
        {
                 e.printStackTrace();
        }

        
       
    }
    
    public static void pdfmethod(String filmname,String timest,String lang, String actor,String genre)//function for creating pdf file
   
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
               
        doc.close();
        }
        
      catch (Exception e)
      {
                e.printStackTrace();
       }
        
    
    }
    
    public static void plaintext(String filmname,String timest,String lang, String actor,String genre)//function for creating text ile
    {
        try
        {
        
             PrintWriter out= new PrintWriter("text.txt");
        
             
             out.println("Movie NAme: "+filmname);
             out.println("Runtime: "+timest+" minutes");
             out.println("Language: "+lang);
             out.println("Lead Actor: "+actor);
             out.println("Genre: "+genre);
             
             out.close();
             }
             
        catch (Exception e)
        {
                e.printStackTrace();
           }
        
    }
    
}




