package sk.gravicon.sirius_lib;

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
