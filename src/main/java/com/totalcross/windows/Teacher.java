package com.totalcross.windows;

import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

import java.util.ArrayList;
import java.util.Random;

public class Teacher extends Window {

    private final int gap = UnitsConverter.toPixels(10 + DP);
    public String[] labels;
    public Edit[] edits;
    public Button btnName = new Button("apply");
    public Button btnManager = new Button("choose manager");
    public AlignedLabelsContainer alc;
    Subject subject;

    public Teacher(Subject subject) {
        super("", BORDER_NONE);
        this.subject = subject;

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

        labels = GetStringArray(subject.getSubjects());
        edits = new Edit[5];
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

        btnName.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnName, LEFT + 10, BOTTOM - 10);

        btnManager.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnManager, RIGHT - 10, BOTTOM - 10);
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnName) {
                for (int i = 1; i <= labels.length; i++) {
                    Label numberCode = new Label("Teacher " + edits[i - 1].getText() + " code number is " + generateCode());
                    numberCode.setFont(Font.getFont("Lato Regular", false, 18));
                    numberCode.setForeColor(Color.GREEN);
                    add(numberCode, LEFT + 385, alc.getLineY(i), FILL - gap, PREFERRED);
                }
            }
        }

        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnManager) {
                Manager managerWindow = new Manager();
                managerWindow.popup();
            }
        }
    }

    public static String[] GetStringArray(ArrayList<String> arr) {
        String[] str = new String[arr.size()];
        Object[] objArr = arr.toArray();

        int i = 0;
        for (Object obj : objArr) {
            str[i++] = (String) obj;
        }
        return str;
    }

    public String generateCode() {
        Random random = new Random();
        String characters = "0123456789";
        char[] code = new char[9];
        for (int i = 0; i < 9; i++) {
            code[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(code);
    }
}
