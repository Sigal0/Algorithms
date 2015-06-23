package sort;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Created by Sigal0Lab on 15/6/21.
 */
public class QuickSortPnl extends JPanel implements Presence {

    private int[] datas;

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        QuickSortPnl pn = new QuickSortPnl();
        fr.getContentPane().add(pn);
        fr.setTitle("模拟快速排序");
        fr.setSize(800, 800);
        fr.setLocationRelativeTo(null);


        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
        pn.startSorting();
    }

    public QuickSortPnl() {
        this.datas = genDatas();
        showGraphics();
//        showGraphics(genDatas());
//        startSorting();
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.blue);
        if (datas != null) {
            for (int i = 0; i < 150; i++) {
                Rectangle2D.Float rect = new Rectangle2D.Float(25 + i * 5, 760 - datas[i], 3, datas[i]);
                g2d.fill(rect);
            }
        }
    }

    private int[] genDatas() {
        int[] h = new int[150];
        Random rdm = new Random();
        for (int i = 0; i < 150; i++) {
            h[i] = rdm.nextInt(750);
            System.out.print(h[i] + " ");
        }

        return h;
    }

    public void showGraphics(int[] datas) {
        this.datas = datas;
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        repaint();
    }

    public void showGraphics() {
//        this.datas = h;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    private void startSorting() {
        new QuickSort(this).sort(datas, 0, datas.length - 1);
    }
}
