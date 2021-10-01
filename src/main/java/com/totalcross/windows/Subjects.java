package com.totalcross.windows;

import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

public class Subjects extends Window {

    private Button btnTeacher;
    private Teacher teacherWindow;

    public Subjects() {
        super("", BORDER_NONE);
        Settings.uiAdjustmentsBasedOnFontHeight = true;
        setBackForeColors(Color.WHITE, Color.BLACK);

        Bar h1 = new Bar("  SUBJECTS");
        h1.canSelectTitle = false;
        h1.setFont(Font.getFont("Lato Bold", true, h1.getFont().size + 5));
        h1.setBackForeColors(0XF8F8F8, Color.BLACK);
        add(h1, LEFT, TOP, FILL, PREFERRED - 50);
    }

    public void onPopup() {
        ScrollContainer sc = new ScrollContainer(false, true);
        add(sc, LEFT, AFTER, FILL, FILL);

        Radio mathematics = new Radio("Mathematics");
        mathematics.setFont(Font.getFont("Lato Regular", false,  24));
        sc.add(mathematics, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        Radio chemical = new Radio("Chemical");
        chemical.setFont(Font.getFont("Lato Regular", false,  24));
        sc.add(chemical, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        Radio biology = new Radio("Biology");
        biology.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(biology, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        Radio physical = new Radio("Physical");
        physical.setFont(Font.getFont("Lato Regular", false,  24));
        sc.add(physical, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        Radio english = new Radio("English");
        english.setFont(Font.getFont("Lato Regular", false,  24));
        sc.add(english, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        btnTeacher = new Button("Choose Teacher");
        btnTeacher.setFont(Font.getFont(Font.DEFAULT, false, 24));
        add(btnTeacher, RIGHT, BOTTOM);
        swapTeacher();
    }

    public void swapTeacher() {
        btnTeacher.addPressListener((event) -> {
            teacherWindow = new Teacher();
            teacherWindow.popup();
        });
    }
}
