package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenMoveWithoutEx() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
        int number = logic.findBy(Cell.H6);
        assertEquals(0, number);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveWithFigureNotFoundEx() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C2, Cell.D3);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveWithOccupiedCellEx() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.E3));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveWithImpossibleMoveEx() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.E4);
    }
}