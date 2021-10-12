package com.totalcross.view;

import com.totalcross.model.Manager;
import com.totalcross.model.Student;
import com.totalcross.model.Teacher;
import totalcross.sys.Settings;
import totalcross.ui.Bar;
import totalcross.ui.Button;
import totalcross.ui.Check;
import totalcross.ui.Window;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

import java.util.ArrayList;
import java.util.List;

public class ManagerControl extends Window {

    private Check[] checkTeachers = new Check[5];
    private Check[] checkStudents;
    private Button btnApply = new Button("apply");
    private List<String> teacherList = new ArrayList<>();
    private List<String> studentList = new ArrayList<>();

    ArrayList<Teacher> teacherView;
    SubjectView subjectView;
    Manager manager;

    public ManagerControl(ArrayList<Teacher> teacherView, SubjectView subjectView, Manager manager) {
        super("", BORDER_NONE);
        this.teacherView = teacherView;
        this.subjectView = subjectView;
        this.manager = manager;

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
                checkTeachers[i] = new Check(teacherView.get(i).toString() + ", Teach = " + subjectView.getSubjects().get(i));
                add(checkTeachers[i], LEFT + 100, TOP + 400 + (200 * i));
            }

            checkStudents = new Check[subjectView.getMap().size()];
            int i = 0;
            for (String key : subjectView.getMap().keySet()) {
                Student value = subjectView.getMap().get(key);
                checkStudents[i] = new Check(value.toString());
                add(checkStudents[i], RIGHT - 100, TOP + 400 + (200 * i));
                i++;
            }

            btnApply.setFont(Font.getFont(Font.DEFAULT, false, 18));
            add(btnApply, LEFT + 10, BOTTOM - 10);

        } catch (Exception exception) {
            // Handle exception
        }
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            for (int i = 0; i < teacherView.size(); i++) {
                if (event.target == checkTeachers[i]) {
                    teacherList.add(checkTeachers[i].getText());
                }
            }

            for (int i = 0; i < subjectView.getMap().size(); i++) {
                if (event.target == checkStudents[i]) {
                    studentList.add(checkStudents[i].getText());
                }
            }
        }

        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnApply) {
                MessageBox mb;
                mb = new MessageBox("Manager description!", toString(), new String[]{"Nice!"});
                mb.setRect(CENTER, CENTER, SCREENSIZE + 50, SCREENSIZE + 30);
                mb.popup();
            }
        }
    }

    @Override
    public String toString() {
        return "The Manager " + manager.getName() + " is responsible for " +
                studentList.size() + " students and " +
                teacherList.size() + " teachers";
    }
}
