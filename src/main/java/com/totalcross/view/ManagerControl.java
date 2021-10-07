package com.totalcross.view;

import com.totalcross.model.Student;
import com.totalcross.model.Teacher;
import totalcross.sys.Settings;
import totalcross.ui.Bar;
import totalcross.ui.Check;
import totalcross.ui.Window;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

import java.util.ArrayList;

public class ManagerControl extends Window {

    private Check checkStudents;
    public Check checkTeachers;

    ManagerView managerView;
    ArrayList<Teacher> teacherView;
    SubjectView subjectView;
    StudentView studentView;

    public ManagerControl(ManagerView managerView, ArrayList<Teacher> teacherView, SubjectView subjectView, StudentView studentView) {
        super("", BORDER_NONE);
        this.managerView = managerView;
        this.teacherView = teacherView;
        this.subjectView = subjectView;
        this.studentView = studentView;

        Settings.uiAdjustmentsBasedOnFontHeight = true;
        setBackForeColors(Color.WHITE, Color.BLACK);

        Bar h1 = new Bar("  MANAGER");
        h1.canSelectTitle = false;
        h1.setFont(Font.getFont("Lato Bold", true, h1.getFont().size + 5));
        h1.setBackForeColors(0XF8F8F8, Color.BLACK);
        add(h1, LEFT, TOP, FILL, PREFERRED - 50);

    }

    public void onPopup() {
        setBackForeColors(0xF7F7F7, 0x000000);

        try {
            for (int i = 0; i < teacherView.size(); i++) {
                checkTeachers = new Check(teacherView.get(i).toString());
                add(checkTeachers, LEFT + 100, TOP + 400 + (200 * i));
            }

            int i = 0;
            for (String key : subjectView.getMap().keySet()) {
                Student value = subjectView.getMap().get(key);
                checkStudents = new Check(value.toString());
                add(checkStudents, RIGHT - 100, TOP + 400 + (200 * i));
                i++;
            }
        } catch (Exception exception) {
            // Handle exception
        }
    }
}
