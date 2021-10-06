package com.totalcross.view;

import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

import java.util.Random;

public class ManagerView extends Window {

    private final int GAP = UnitsConverter.toPixels(DP + 15);
    public Button btnName;
    public Edit managerName;

    public ManagerView() {
        super("", BORDER_NONE);

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

            btnName = new Button("apply");
            btnName.setFont(Font.getFont(Font.DEFAULT, false, 18));
            add(btnName, RIGHT - 1000, CENTER + 50);

        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public void onEvent (Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnName) {
                Label numberCode = new Label("Manager " + managerName.getText() + " code number is " + generateCode());
                numberCode.setFont(Font.getFont("Lato Regular", false, 24));
                numberCode.setForeColor(Color.GREEN);
                add(numberCode, CENTER, CENTER + 200);
            }
        }

//        if (event.type == ControlEvent.PRESSED) {
//            if (event.target == btnSubject) {
//                subjectWindow = new Subject();
//                subjectWindow.popup();
//            }
//        }
    }

    public String generateCode() {
        Random random = new Random();
        String charNumber = "0123456789";
        String charAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] codeNumber = new char[4];
        for (int i = 0; i < 4; i++) {
            codeNumber[i] = charNumber.charAt(random.nextInt(charNumber.length()));
        }

        char[] codeAlpha = new char[1];
        codeAlpha[0] = charAlpha.charAt(random.nextInt(charAlpha.length()));

        return new String(codeNumber) + new String(codeAlpha);
    }
}
