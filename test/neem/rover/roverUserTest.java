package neem.rover;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class roverUserTest {

	@Mock
	Rover rover;
	
	@Test
	public final void test() {
		
		char value = TestingUtil.getRandomCharacter();
		Mockito.when(rover.getDirection()).thenReturn(value);
		
		RoverUser testObject = new RoverUser();
		
		Character returnVal = testObject.direct(rover);
		
		assertNotNull(returnVal);
		assertEquals((Character)value, returnVal);
		
	}
	

}
