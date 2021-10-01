package com.totalcross.windows;

import totalcross.sys.Settings;
import totalcross.ui.Bar;
import totalcross.ui.Button;
import totalcross.ui.Edit;
import totalcross.ui.Window;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

public class Teacher extends Window {

    private Edit teacherName;
    private int GAP = UnitsConverter.toPixels(DP + 15);

    public Teacher() {
        super("", BORDER_NONE);
        Settings.uiAdjustmentsBasedOnFontHeight = true;
        setBackForeColors(Color.WHITE, Color.BLACK);

        Bar h1 = new Bar("  TEACHER");
        h1.canSelectTitle = false;
        h1.setFont(Font.getFont("Lato Bold", true, h1.getFont().size + 5));
        h1.setBackForeColors(0XF8F8F8, Color.BLACK);
        add(h1, LEFT, TOP, FILL, PREFERRED - 50);
    }

    public void onPopup() {
        try {
            teacherName = new Edit();
            teacherName.caption = "Teacher Name";
            teacherName.transparentBackground = true;
            teacherName.captionColor = Color.BLACK;
            teacherName.setForeColor(Color.BLACK);
            teacherName.setFont(Font.getFont("Lato Regular", false,  24));
            add(teacherName, CENTER - GAP, CENTER - GAP);

            Button btnName = new Button("apply");
            btnName.setFont(Font.getFont(Font.DEFAULT, false, 18));
            add(btnName, RIGHT - 1000, CENTER + 50);
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
}
