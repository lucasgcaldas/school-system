package com.totalcross.windows;

import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

import java.util.Random;

public class Student extends Window {

    private Button btnSubject;
    private Button btnName;
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

            btnName = new Button("apply");
            btnName.setFont(Font.getFont(Font.DEFAULT, false, 18));
            add(btnName, RIGHT - 1000, CENTER + 50);

            btnSubject = new Button("choose subjects");
            btnSubject.setFont(Font.getFont(Font.DEFAULT, false, 24));
            add(btnSubject, RIGHT - 10, BOTTOM - 10);
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public void onEvent(Event event){
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnName) {
                Label numberCode = new Label("Student " + studentName.getText() + " code number: " + generateCode());
                numberCode.setFont(Font.getFont("Lato Regular", false, 24));
                numberCode.setForeColor(Color.GREEN);
                add(numberCode, CENTER, CENTER + 200);
            }
        }

        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnSubject) {
                subjectWindow = new Subject();
                subjectWindow.popup();
            }
        }
    }

    public String generateCode() {
        Random random = new Random();
        String characters = "0123456789";
        char[] code = new char[8];
        for (int i = 0; i < 8; i++) {
            code[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(code);
    }

}
