package com.totalcross.windows;

import totalcross.ui.ComboBox;
import totalcross.ui.Label;
import totalcross.ui.Window;

public class Subjects extends Window {

    private Label subject;
    private ComboBox subBox;
    private String[] subjectsName = {"Mathematics", "Chemical", "Biology", "Physical", "English"};

    public void onPopup() {
        subject = new Label("Subject");
        subBox = new ComboBox(subjectsName);

        subject.setForeColor(0x808080);

        subBox.borderColor = 0x000000;
        subBox.setBorderStyle(BORDER_LOWERED);

        add(subBox, CENTER, CENTER);
    }
}
