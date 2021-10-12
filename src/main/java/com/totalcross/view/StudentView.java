package com.totalcross.view;

import com.totalcross.model.Student;
import com.totalcross.model.Subject;
import com.totalcross.model.SubjectEnum;
import totalcross.sys.Settings;
import totalcross.ui.Bar;
import totalcross.ui.Button;
import totalcross.ui.Edit;
import totalcross.ui.Window;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

import java.util.HashMap;
import java.util.Set;

public class StudentView extends Window {

    private final int GAP = UnitsConverter.toPixels(DP + 15);
    private Button btnSubject;
    private Button btnName;
    private Edit studentName;

    SubjectView subjectView;
    Set<SubjectEnum> subjectsSet;

    HashMap<String, Student> map = new HashMap<>();

    public StudentView(SubjectView subjectView, Set<SubjectEnum> subjectsSet) {
        super("", BORDER_NONE);
        this.subjectView = subjectView;
        this.subjectsSet = subjectsSet;

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
            studentName.caption = "Student name";
            studentName.transparentBackground = true;
            studentName.captionColor = Color.BLACK;
            studentName.setForeColor(Color.BLACK);
            studentName.setFont(Font.getFont("Lato Regular", false, 24));
            add(studentName, CENTER - GAP, CENTER - GAP);

            btnName = new Button("apply");
            btnName.setFont(Font.getFont(Font.DEFAULT, false, 18));
            add(btnName, RIGHT - 1000, CENTER + 50);

            btnSubject = new Button("next");
            btnSubject.setFont(Font.getFont(Font.DEFAULT, false, 18));
            add(btnSubject, RIGHT - 10, BOTTOM - 10);
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnName) {
                Student student = new Student(studentName.getText());
                map.put(student.getCode(), student);

                if (subjectView != null) {
                    for (String key : subjectView.getMap().keySet()) {
                        Student value = subjectView.getMap().get(key);
                        map.put(key, value);
                    }
                }

                SubjectView subjectWindow = new SubjectView(this, subjectsSet);
                subjectWindow.popup();
            }
        }
    }

    public HashMap<String, Student> getMap() {
        return this.map;
    }
}
