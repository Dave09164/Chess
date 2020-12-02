package jUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Colour;
import pieces.Pawn;
import pieces.Piece;

class testingPromoteTo {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		ArrayList<Piece> pie =  new ArrayList<Piece>();
		Piece p = new Pawn(Colour.WHITE);
		Piece newP = p.promoteTo(pie);
		assertEquals("QUEEN", newP.getType());
		
	}

}
