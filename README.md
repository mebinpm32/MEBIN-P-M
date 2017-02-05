# MEBIN-P-M
Programming Challenge: Movie Aggregator  
Part A:  Create a console-based application that accepts movie details like Name, Run Time, Language, Lead Actor and Genre and then export these details into one of the 2 formats, depending on user’s choice - “plain text” or “PDF”. 
Part B:  Make the application extensible so that it is easy to “plug in” a new format and the application automatically has the capability to export to the new format without making any changes to the application code.

Here the application is written in java language, which is developed using netbeans ide.
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

For creating pdf file,
function named "pdfmethod" is caleed, which uses an external pdf library called itext.





