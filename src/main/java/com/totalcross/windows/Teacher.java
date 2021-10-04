package com.totalcross.windows;

import totalcross.sys.Settings;
import totalcross.ui.AlignedLabelsContainer;
import totalcross.ui.Bar;
import totalcross.ui.Edit;
import totalcross.ui.Window;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

import java.util.ArrayList;

public class Teacher extends Window {

    private final int gap = UnitsConverter.toPixels(10 + DP);
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

        String[] labels = GetStringArray(subject.getSubjects());
        Edit[] edits = new Edit[5];
        for (int i = 0; i < edits.length; i++) {
            edits[i] = new Edit();
        }

        AlignedLabelsContainer alc = new AlignedLabelsContainer();
        alc.uiAdjustmentsBasedOnFontHeightIsSupported = false;
        alc.labelAlign = RIGHT;

        alc.setInsets(gap, gap, 0, 0);
        alc.setLabels(labels, edits[0].getPreferredHeight());
        add(alc, LEFT, AFTER, FILL, PREFERRED);
        for (int i = 0; i < edits.length; i++) {
            alc.add(edits[i], LEFT + gap, alc.getLineY(i), FILL - gap, PREFERRED);
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
}
