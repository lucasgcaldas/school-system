package com.totalcross.windows;

import totalcross.ui.Window;

public class MainWindows extends Window {

    private Subjects subjects;

    public void onPopup() {
        setBackForeColors(0xF7F7F7, 0x000000);

        subjects = new Subjects();
        subjects.popup();
    }
}
