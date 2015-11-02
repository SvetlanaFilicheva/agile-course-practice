package ru.unn.agile.Minesweeper;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BoardTest {

    private Board board;

    @Before
    public void runBeforeEveryTest() {
        board = new Board(new Minesweeper(), 32, 32);
    }

    @Test
    public void openMine() {
        board.setMine(0, 0);
        board.openCell(0, 0);
        assertEquals(true, board.isLost());
    }

    @Test
    public void  whenSetFlagOpenMine() {
        board.setMine(0, 0);
        board.setFlag(0, 0);
        board.openCell(0, 0);
        assertEquals(false, board.isLost());
    }

    @Test
    public void whenSetOneMineInNeighboringCellSetValue1() {
        board.setMine(0, 0);
        assertEquals(1, board.getValue(1, 1));
    }

    @Test
    public void whenNeighboringCellsSetTwoMinesCellSetValue2() {
        board.setMine(0, 0);
        board.setMine(2, 2);
        assertEquals(2, board.getValue(1, 1));
    }

    @Test
    public void whenAroundMinesCellSetValue8() {
        board.setMine(0, 0);
        board.setMine(0, 1);
        board.setMine(0, 2);
        board.setMine(1, 0);
        board.setMine(1, 2);
        board.setMine(2, 0);
        board.setMine(2, 1);
        board.setMine(2, 2);
        assertEquals(8, board.getValue(1, 1));
    }

    @Test
    public void whenClearMineUnset() {
        board.setMine(0, 0);
        board.clear();
        assertEquals(false, board.isMine(0, 0));
    }

    @Test
    public void whenClearLostUnset() {
        board.setMine(0, 0);
        board.openCell(0, 0);
        board.clear();
        assertEquals(false, board.isLost());
    }

    @Test
    public void setRandom100Mines() {
        board.setMinesRandom(100);
        assertEquals(100, board.findMinesCount());
    }

    @Test
    public void unsetFlag(){
        board.setFlag(0, 0);
        board.unsetFlag(0, 0);
        assertFalse(board.getCell(0, 0).isFlag());
    }
}
