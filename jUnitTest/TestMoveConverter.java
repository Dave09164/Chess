package jUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Board;
import game.Colour;

class TestMoveConverter {

	@BeforeEach
	void setUp() throws Exception {
		Board myClass = new Board();
	}
	
	@AfterEach
	void tearDown() throws Exception{
		
	}

	@Test
	void test() {
		Board myClass = new Board();
		assertEquals(7464, myClass.convertMove("7d 6d", Colour.WHITE));
		
		//fail("Not yet implemented");
	}

}
