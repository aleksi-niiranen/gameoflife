package com.hungrysingle.life;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;

public class LifePainter extends Component {
    public static final int WIDTH = 5;
    public static final int HEIGHT = 5;

    private Collection<List> board;

    public LifePainter(Collection<List> board) {
        this.board = board;
    }

    public void setBoard(Collection<List> board) {
        this.board = board;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Iterator<List> i = this.board.iterator();
        while (i.hasNext()) {
            List<Long> l = i.next();
            g2.fillRect(l.get(0).intValue() * WIDTH, l.get(1).intValue() * HEIGHT, WIDTH, HEIGHT);
        }
    }
}
