package com.totalcross.view;

import com.totalcross.model.Student;
import totalcross.sys.Settings;
import totalcross.ui.Bar;
import totalcross.ui.Button;
import totalcross.ui.Label;
import totalcross.ui.Window;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

import java.util.HashMap;

public class DescriptionStudents extends Window {

    private Button btnApply;
    public Label numberCode;

    StudentView studentMap;

    public DescriptionStudents(StudentView studentMap) {
        super("", BORDER_NONE);
        this.studentMap = studentMap;

        Settings.uiAdjustmentsBasedOnFontHeight = true;
        setBackForeColors(Color.WHITE, Color.BLACK);

        Bar h1 = new Bar("  STUDENT DESCRIPTION");
        h1.canSelectTitle = false;
        h1.setFont(Font.getFont("Lato Bold", true, h1.getFont().size + 5));
        h1.setBackForeColors(0XF8F8F8, Color.BLACK);
        add(h1, LEFT, TOP, FILL, PREFERRED - 50);
    }

    public void onPopup() {
        setBackForeColors(0xF7F7F7, 0x000000);

        btnApply = new Button("next");
        btnApply.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnApply, RIGHT - 10, BOTTOM - 10);

        int i = 1;
        for (String key : studentMap.getMap().keySet()) {
            Student value = studentMap.getMap().get(key);
            numberCode = new Label(value.toString());
            numberCode.setFont(Font.getFont("Lato Regular", false, 24));
            numberCode.setForeColor(Color.BLACK);
            add(numberCode, CENTER, TOP + (200 * i));
            i++;
        }
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnApply) {
                SubjectView subjectWindow = new SubjectView(this);
                subjectWindow.popup();
            }
        }
    }

    public HashMap<String, Student> getMap() {
        return this.studentMap.map;
    }

}
