package com.totalcross.view;

import com.totalcross.model.SubjectEnum;
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

        btnManager.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnManager, RIGHT - 10, BOTTOM - 10);
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnManager) {
                for (int i = 0; i < edits.length; i++) {
                    teacherList.add(new Teacher(edits[i].getText(), subjectView.getSubjects().get(i)));
                }

                ManagerView managerWindow = new ManagerView(this.teacherList, subjectView, studentView);
                managerWindow.popup();
            }
        }
    }

    public static String[] GetStringArray(ArrayList<SubjectEnum> arr) {
        String[] str = new String[arr.size()];

        int i = 0;
        for (SubjectEnum obj : arr) {
            str[i++] = obj.toString();
        }

        return str;
    }
}
