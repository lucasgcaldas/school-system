package com.totalcross.view;

import com.totalcross.model.Manager;
import com.totalcross.model.Teacher;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class ManagerView extends Window {

    private final int GAP = UnitsConverter.toPixels(DP + 15);
    public Button btnApply;
    public Edit managerName;
    private Set<Manager> managerSet = new LinkedHashSet<>();

    ManagerControl managerControl;
    ArrayList<Teacher> teacherView;
    SubjectView subjectView;
    StudentView studentView;

    public ManagerView(ArrayList<Teacher> teacherView, SubjectView subjectView, StudentView studentView) {
        super("", BORDER_NONE);
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
            managerName = new Edit();
            managerName.caption = "Manager Name";
            managerName.transparentBackground = true;
            managerName.captionColor = Color.BLACK;
            managerName.setForeColor(Color.BLACK);
            managerName.setFont(Font.getFont("Lato Regular", false, 24));
            add(managerName, CENTER - GAP, CENTER - GAP);

            btnApply = new Button("apply");
            btnApply.setFont(Font.getFont(Font.DEFAULT, false, 18));
            add(btnApply, RIGHT - 1000, CENTER + 50);

        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnApply) {
                Manager manager = new Manager(managerName.getText());

                Label numberCode = new Label(manager.toString());
                numberCode.setFont(Font.getFont("Lato Regular", false, 24));
                numberCode.setForeColor(Color.GREEN);
                add(numberCode, CENTER, CENTER + 200);

                managerControl = new ManagerControl(teacherView, subjectView, manager);
                managerControl.popup();
            }
        }
    }
}
