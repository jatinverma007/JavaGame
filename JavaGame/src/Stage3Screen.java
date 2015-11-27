import com.sun.glass.ui.Size;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

/**
 * Created by JATIN on 26-11-2015.
 */
public class Stage3Screen extends JPanel {

    public static int E=0;
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.fillRect(0,0,800,450);
        g.setColor(Color.CYAN);
        g.drawString("GAME OVER  TUMSE NA HO PAAYEGA" , 200,200);
        //g.drawString("   NUMBER OF BLOCK HITTED " + E, 100, 200);
    }


}
