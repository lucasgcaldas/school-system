package com.totalcross;

import com.totalcross.windows.MainWindows;
import com.totalcross.windows.Subjects;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.font.Font;

public class SchoolSystem extends MainWindow {

    private Button enroll;
    public Subjects subjects;
    public MainWindows mainContainers;

    public SchoolSystem() {
        setUIStyle(Settings.MATERIAL_UI);
    }

    @Override
    public void initUI() {
        Label schoolSystem = new Label("School System");
        schoolSystem.setFont(Font.getFont(Font.DEFAULT, true, 24));
        add(schoolSystem, CENTER, TOP);

        enroll = new Button("Enter");
        enroll.setFont(Font.getFont(Font.DEFAULT, false, 24));
        add(enroll, CENTER, CENTER);
        swapWindow();
    }

    public void swapWindow() {
        enroll.addPressListener((event) -> {
            mainContainers = new MainWindows();
            mainContainers.popup();
        });
    }
}

