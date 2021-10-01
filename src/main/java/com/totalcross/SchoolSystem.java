package com.totalcross;

import com.totalcross.windows.Student;
import totalcross.sys.Settings;
import totalcross.ui.Bar;
import totalcross.ui.Button;
import totalcross.ui.MainWindow;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

public class SchoolSystem extends MainWindow {

    private Button btnEnter;
    private Student studentWindow;

    public SchoolSystem() {
        super("", BORDER_NONE);
        setUIStyle(Settings.MATERIAL_UI);
        Settings.uiAdjustmentsBasedOnFontHeight = true;
        setBackForeColors(Color.WHITE, Color.BLACK);

        Bar h1 = new Bar("  SCHOOL SYSTEM");
        h1.canSelectTitle = false;
        h1.setFont(Font.getFont("Lato Bold", true, h1.getFont().size + 5));
        h1.setBackForeColors(0XF8F8F8, Color.BLACK);
        add(h1, LEFT, TOP, FILL, PREFERRED - 50);
    }

    @Override
    public void initUI() {
        btnEnter = new Button("start");
        btnEnter.setFont(Font.getFont(Font.DEFAULT, false, 24));
        add(btnEnter, CENTER, CENTER);
        swapStudents();
    }

    public void swapStudents() {
        btnEnter.addPressListener((event) -> {
            studentWindow = new Student();
            studentWindow.popup();
        });
    }
}

