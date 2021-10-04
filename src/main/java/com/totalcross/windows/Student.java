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

public class Student extends Window {

    private Button btnSubject;
    private Edit studentName;
    private Subject subjectWindow;
    private final int GAP = UnitsConverter.toPixels(DP + 15);

    public Student() {
        super("", BORDER_NONE);
        Settings.uiAdjustmentsBasedOnFontHeight = true;
        setBackForeColors(Color.WHITE, Color.BLACK);

        Bar h1 = new Bar("  STUDENT");
        h1.canSelectTitle = false;
        h1.setFont(Font.getFont("Lato Bold", true, h1.getFont().size + 5));
        h1.setBackForeColors(0XF8F8F8, Color.BLACK);
        add(h1, LEFT, TOP, FILL, PREFERRED - 50);
    }

    public void onPopup() {
        setBackForeColors(0xF7F7F7, 0x000000);

        try {
            studentName = new Edit();
            studentName.caption = "Student Name";
            studentName.transparentBackground = true;
            studentName.captionColor = Color.BLACK;
            studentName.setForeColor(Color.BLACK);
            studentName.setFont(Font.getFont("Lato Regular", false, 24));
            add(studentName, CENTER - GAP, CENTER - GAP);

            Button btnName = new Button("apply");
            btnName.setFont(Font.getFont(Font.DEFAULT, false, 18));
            add(btnName, RIGHT - 1000, CENTER + 50);

            btnName.addPressListener((event) -> {
                studentName.getText();
            });

            btnSubject = new Button("choose subjects");
            btnSubject.setFont(Font.getFont(Font.DEFAULT, false, 24));
            add(btnSubject, RIGHT - 10, BOTTOM - 10);
            swapSubjects();
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public void swapSubjects() {
        btnSubject.addPressListener((event) -> {
            subjectWindow = new Subject();
            subjectWindow.popup();
        });
    }
}
