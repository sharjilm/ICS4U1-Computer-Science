import nu.xom.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scorekeeper {

	public static Element scores = new Element("scores");
	public static Document doc = new Document(scores);
	
	public static void fileMaker(String player1Name, String player2Name, String player1Score, String player2Score){
		
		Element player1 = new Element("player");
		Element player2 = new Element("player");
		Element name1 = new Element("name");
	  	Element score1 = new Element("score");
	  	Element name2 = new Element("name");
	  	Element score2 = new Element("score");
	  	
	  	String[] arrayName = {player1Name, player2Name};
	  	String[] arrayScore = {player1Score, player2Score};
	  	
	  	name1.appendChild(arrayName[0]);
	  	score1.appendChild(arrayScore[0]);
	  	
	  	scores.appendChild(player1);
	  	player1.appendChild(name1);
	  	player1.appendChild(score1);
	  	
	  	name2.appendChild(arrayName[1]);
	  	score2.appendChild(arrayScore[1]);
	  	
	  	scores.appendChild(player2);
	  	player2.appendChild(name2);
	  	player2.appendChild(score2);
	  	
	  	try
	  	  {
	  	   Serializer serializer = new Serializer(System.out);
	  	   serializer.setIndent(4);
	  	   serializer.setMaxLength(64);
	  	   serializer.write(doc);
	  	  }
	  	
	  	catch (IOException ex)
		   {
		   System.err.println(ex);
		   }
	  	
	  	try
		  {
	  	   FileWriter xmlfile = new FileWriter("myfile.xml");
		   BufferedWriter writer = new BufferedWriter(xmlfile);
		   writer.write(doc.toXML());
		   writer.close();
		  }

		catch (IOException e)
		   {

		   }
	}	
}
