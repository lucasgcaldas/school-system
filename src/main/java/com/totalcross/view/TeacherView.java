package com.totalcross.view;

import com.totalcross.model.Subject;
import com.totalcross.model.Teacher;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

import java.util.ArrayList;

public class TeacherView extends Window {

    private final int gap = UnitsConverter.toPixels(10 + DP);
    public String[] labels;
    public Edit[] edits;
    public Button btnApply = new Button("apply");
    public Button btnManager = new Button("choose manager");
    public AlignedLabelsContainer alc;

    private ArrayList<Teacher> teacherList = new ArrayList<>();

    SubjectView subjectView;
    StudentView studentView;

    public TeacherView(SubjectView subjectView, StudentView studentView) {
        super("", BORDER_NONE);
        this.subjectView = subjectView;
        this.studentView = studentView;

        Settings.uiAdjustmentsBasedOnFontHeight = true;
        setBackForeColors(Color.WHITE, Color.BLACK);

        Bar h1 = new Bar("  TEACHER");
        h1.canSelectTitle = false;
        h1.setFont(Font.getFont("Lato Bold", true, h1.getFont().size + 5));
        h1.setBackForeColors(0XF8F8F8, Color.BLACK);
        add(h1, LEFT, TOP, FILL, PREFERRED - 50);
    }

    public void onPopup() {
        uiAdjustmentsBasedOnFontHeightIsSupported = false;
        setBackForeColors(0xF7F7F7, 0x000000);

        labels = GetStringArray(subjectView.getSubjects());
        edits = new Edit[subjectView.getSubjects().size()];
        for (int i = 0; i < edits.length; i++) {
            edits[i] = new Edit();
        }

        alc = new AlignedLabelsContainer();
        alc.uiAdjustmentsBasedOnFontHeightIsSupported = false;
        alc.labelAlign = RIGHT;

        alc.setInsets(gap, gap, 0, 0);
        alc.setLabels(labels, edits[0].getPreferredHeight());
        add(alc, LEFT, AFTER, FILL - 400, PREFERRED);
        for (int i = 0; i < edits.length; i++) {
            alc.add(edits[i], LEFT + gap, alc.getLineY(i), FILL - gap, PREFERRED);
        }

        btnApply.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnApply, LEFT + 10, BOTTOM - 10);

        btnManager.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnManager, RIGHT - 10, BOTTOM - 10);
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnApply) {
                for (int i = 0; i < edits.length; i++) {
                    teacherList.add(new Teacher(edits[i].getText(), subjectView.getSubjects().get(i)));
                }

                int i = 0;
                for (Teacher teacher : teacherList) {
                    Label numberCode = new Label(teacher.toString());
                    numberCode.setFont(Font.getFont("Lato Regular", false, 18));
                    numberCode.setForeColor(Color.GREEN);
                    add(numberCode, LEFT + 385, alc.getLineY(i), FILL - gap, PREFERRED);
                    i++;
                }
            }
        }

        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnManager) {
                ManagerView managerWindow = new ManagerView(this.teacherList, subjectView, studentView);
                managerWindow.popup();
            }
        }
    }

    public static String[] GetStringArray(ArrayList<Subject> arr) {
        String[] str = new String[arr.size()];

        int i = 0;
        for (Subject obj : arr) {
            str[i++] = obj.getName().toString();
        }
        return str;
    }
}
