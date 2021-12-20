package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C5);
        Cell expected = Cell.C5;
        Cell rsl = bishopBlack.position();
        assertEquals(expected, rsl);
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        BishopBlack newBishopBlack = (BishopBlack) bishopBlack.copy(Cell.A2);
        Cell expected = Cell.A2;
        Cell rsl = newBishopBlack.position();
        assertEquals(expected, rsl);
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWayLong() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F2);
        Cell[] result = bishopBlack.way(Cell.A7);
        Cell[] expected = {Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7};
        assertArrayEquals(expected, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayEx() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        bishopBlack.way(Cell.E7);
    }
}