package com.totalcross.windows;

import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

import java.util.ArrayList;

public class Subject extends Window {

    private Button btnTeacher;

    public ArrayList<String> subjects = new ArrayList<>();

    public Subject() {
        super("", BORDER_NONE);

        Settings.uiAdjustmentsBasedOnFontHeight = true;
        setBackForeColors(Color.WHITE, Color.BLACK);

        Bar h1 = new Bar("  SUBJECTS");
        h1.canSelectTitle = false;
        h1.setFont(Font.getFont("Lato Bold", true, h1.getFont().size + 5));
        h1.setBackForeColors(0XF8F8F8, Color.BLACK);
        add(h1, LEFT, TOP, FILL, PREFERRED - 50);
    }

    public Radio mathematics = new Radio("Mathematics");
    public Radio chemical = new Radio("Chemical");
    public Radio biology = new Radio("Biology");
    public Radio physical = new Radio("Physical");
    public Radio english = new Radio("English");
    public Button btnSubjects = new Button("apply");

    public void onPopup() {
        ScrollContainer sc = new ScrollContainer(false, true);
        add(sc, LEFT, AFTER, FILL, FILL);

        mathematics.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(mathematics, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        chemical.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(chemical, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        biology.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(biology, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        physical.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(physical, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        english.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(english, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        btnSubjects.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnSubjects, LEFT + 130, BOTTOM - 10);

        btnTeacher = new Button("choose teacher");
        btnTeacher.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnTeacher, RIGHT - 10, BOTTOM - 10);
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnSubjects) {
                if (mathematics.isChecked()) {
                    subjects.add("mathematics");
                }
                if (chemical.isChecked()) {
                    subjects.add("chemical");
                }
                if (biology.isChecked()) {
                    subjects.add("biology");
                }
                if (physical.isChecked()) {
                    subjects.add("physical");
                }
                if (english.isChecked()) {
                    subjects.add("english");
                }
            }
        }

        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnTeacher) {
                Teacher teacherWindow = new Teacher(this);
                teacherWindow.popup();
            }
        }
    }

    public ArrayList<String> getSubjects() {
        return this.subjects;
    }
}
