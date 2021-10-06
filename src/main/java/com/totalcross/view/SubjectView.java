package com.totalcross.view;

import com.totalcross.model.Student;
import com.totalcross.model.Subject;
import com.totalcross.model.SubjectEnum;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

import java.util.ArrayList;

public class SubjectView extends Window {

    private Button btnTeacher;
    public ArrayList<Subject> subjects = new ArrayList<>();

    DescriptionStudents studentMap;

    public SubjectView(DescriptionStudents studentMap) {
        super("", BORDER_NONE);
        this.studentMap = studentMap;

        Settings.uiAdjustmentsBasedOnFontHeight = true;
        setBackForeColors(Color.WHITE, Color.BLACK);

        Bar h1 = new Bar("  SUBJECTS");
        h1.canSelectTitle = false;
        h1.setFont(Font.getFont("Lato Bold", true, h1.getFont().size + 5));
        h1.setBackForeColors(0XF8F8F8, Color.BLACK);
        add(h1, LEFT, TOP, FILL, PREFERRED - 50);
    }

    private Subject matSubject = new Subject(SubjectEnum.MATHEMATICS);
    private Subject cheSubject = new Subject(SubjectEnum.CHEMICAL);
    private Subject bioSubject = new Subject(SubjectEnum.BIOLOGY);
    private Subject phySubject = new Subject(SubjectEnum.PHYSICAL);
    private Subject engSubject = new Subject(SubjectEnum.ENGLISH);

    public Radio mathematics = new Radio(matSubject.getName().toString());
    public Radio chemical = new Radio(cheSubject.getName().toString());
    public Radio biology = new Radio(bioSubject.getName().toString());
    public Radio physical = new Radio(phySubject.getName().toString());
    public Radio english = new Radio(engSubject.getName().toString());
    public Button btnApply = new Button("apply");

    public void onPopup() {
        ScrollContainer sc = new ScrollContainer(false, true);
        add(sc, LEFT, AFTER, FILL, FILL);

        mathematics.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(mathematics, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        chemical.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(chemical, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        biology.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(biology, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        physical.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(physical, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        english.setFont(Font.getFont("Lato Regular", false, 24));
        sc.add(english, LEFT + 100, AFTER + 100, PREFERRED + 100, PREFERRED + 25);

        btnApply.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnApply, LEFT + 130, BOTTOM - 10);

        btnTeacher = new Button("choose teacher");
        btnTeacher.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnTeacher, RIGHT - 10, BOTTOM - 10);
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnApply) {
                for (String key : studentMap.getMap().keySet()) {
                    Student value = studentMap.getMap().get(key);
                    if (mathematics.isChecked()) {
                        matSubject.enrollStudent(value);
                        subjects.add(matSubject);
                    }
                    if (chemical.isChecked()) {
                        cheSubject.enrollStudent(value);
                        subjects.add(cheSubject);
                    }
                    if (biology.isChecked()) {
                        bioSubject.enrollStudent(value);
                        subjects.add(bioSubject);
                    }
                    if (physical.isChecked()) {
                        phySubject.enrollStudent(value);
                        subjects.add(phySubject);
                    }
                    if (english.isChecked()) {
                        engSubject.enrollStudent(value);
                        subjects.add(engSubject);
                    }
                }
            }
        }

        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnTeacher) {
                TeacherView teacherWindow = new TeacherView(this);
                teacherWindow.popup();
            }
        }
    }

    public ArrayList<Subject> getSubjects() {
        return this.subjects;
    }
}
