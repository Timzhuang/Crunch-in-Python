package CS239.crunch_in_python;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void testApp() {
    	App app = new App();
    	try {
			app.run(new String[] {"",""});
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
