import java.util.Random;
/**
 * Write a description of class Die here.
 * 
 * @author (Joseph Chica) 
 * @version (7-27-2016)
 * Lab 9
 */
public class Die
{
    private int face;
	private Random rng;
	/**
	 * The default constructor method
	 */
	public Die()
	{
	  rng = new Random( );
	  face = rng.nextInt(6) + 1;
	}
	
	/**
	 * 
	 */
	public void roll( )
	{
	    face = rng.nextInt(6) + 1;
	 }
	 
	 /**The get method that returns the face field
	  * @return
	  * 
	  */
	 public int getFace( )
	 {
	     return face;
	  }
	   
	  /**The toString method that sets up a switch statement for the six different results the dice give
	   * @return
	   */
	 public String toString( )
	 {
	     String result= "";
	     switch(face)
	     {
	         case 1: result = "* *";
	                 break;
	         case 2: result = "* *";
	                 break;

             case 3:  result = "*";
                     // result +="  *\n";
                     // result +="    *\n\n";
	                   break;
	         case 4: result = "* *";
	                 //result += "\n* *\n\n";
	                  break;
	         case 5: result = "*   *";
	                 //result += "\n  * ";
	                 //esult += "\n*   *\n\n";
	                 break;
	         case 6: result = "*  *";
	                 //result += "\n*  *";
	                 //result += "\n*  *\n\n";
	       } 
	     return result;
	   }  
	   
	   /**
	    * The compareTo method that compares 2 dice fields 
	    * @param
	    * @return
	    */
	   public int compareTo(Die inDie)
	   { 
	      return face - inDie.face;
	   }
	   
	   /**
	    * The equals method that tells if the rolls are equal
	    * @return
	    * @param
	    */
	   public boolean equals(Die inDie)
	   {
	     return face == inDie.face;
	   }
	   
}
