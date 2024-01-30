import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class MainClass {
	public static void main(String[] args) throws IOException{
		
		int k;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for splitting pages as a range and enter 2 for splitting pages one by one");
		k=sc.nextInt();
		switch(k) {
		case 1:
		File oldFile = new File("C:\\abc.pdf");
		PDDocument document = PDDocument.load(oldFile);
		
		File newFileDestination = new File("C:\\pdf\\extract");
		newFileDestination.mkdirs();
		
		Splitter splitter = new Splitter();
		splitter.setStartPage(2);
		splitter.setEndPage(9);
		
		List <PDDocument> splitPages = splitter.split(document);
		
		PDDocument newDoc = new PDDocument();
		for(PDDocument mydoc : splitPages)
		{
			newDoc.addPage(mydoc.getPage(0));
		}
		newDoc.save(newFileDestination+"//split.pdf");
		newDoc.close();
		System.out.println("PDF created");
		break;
		
		case 2:
		File oldFile1 = new File("C:\\abc.pdf");
		PDDocument document1 = PDDocument.load(oldFile1);
		
		Splitter splitter1 = new Splitter();
		
		List <PDDocument> splitPages1 = splitter1.split(document1);
		
		int num=1;
		for(PDDocument mydoc1 : splitPages1)
		{
			mydoc1.save("C:\\pdf\\extract\\split_0"+num+".pdf");
			num++;
			mydoc1.close();
		}
		System.out.println("Split done");
		break;
	}
}
}
