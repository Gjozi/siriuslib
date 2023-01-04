package sk.gravicon.siriuslib;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Utils utils = Utils.getInstance();
    	System.out.println( "Hello World!" );
    	System.out.println(utils.toString());
    	System.out.println(utils.getVersion());
    }
}
