package crunch_in_python.JavaWrapper;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import crunch_in_python.JavaWrapper.App;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    */
    
    @Test
    public void testApp() {
    	try {
			App.main(new String[] {"",""});
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
