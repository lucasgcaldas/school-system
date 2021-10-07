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
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SubjectView extends Window {

    private Button btnTeacher;
    private Button btnStudent;
    public Set<Subject> subjectsSet = new LinkedHashSet<>();

    StudentView studentView;

    public SubjectView(StudentView studentView, Set<Subject> subjectsSet) {
        super("", BORDER_NONE);
        this.studentView = studentView;
        if (subjectsSet != null) {
            this.subjectsSet.addAll(subjectsSet);
        }

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

    public Radio mathematics = new Radio(matSubject.getName().toString() + "                Vacancies: " + matSubject.getVacancies());
    public Radio chemical = new Radio(cheSubject.getName().toString() + "                   Vacancies: " + cheSubject.getVacancies());
    public Radio biology = new Radio(bioSubject.getName().toString() + "                    Vacancies: " + bioSubject.getVacancies());
    public Radio physical = new Radio(phySubject.getName().toString() + "                   Vacancies: " + phySubject.getVacancies());
    public Radio english = new Radio(engSubject.getName().toString() + "                    Vacancies: " + engSubject.getVacancies());

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
        add(btnApply, CENTER, BOTTOM - 10);

        btnTeacher = new Button("choose teacher");
        btnTeacher.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnTeacher, RIGHT - 10, BOTTOM - 10);

        btnStudent = new Button("choose student");
        btnStudent.setFont(Font.getFont(Font.DEFAULT, false, 18));
        add(btnStudent, LEFT + 10, BOTTOM - 10);
    }

    public void onEvent(Event event) {
        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnApply) {
                for (String key : studentView.getMap().keySet()) {

                    Student value = studentView.getMap().get(key);

                    if (mathematics.isChecked()) {
                        matSubject.enrollStudent(value);
                        subjectsSet.add(matSubject);
                    }
                    if (chemical.isChecked()) {
                        cheSubject.enrollStudent(value);
                        subjectsSet.add(cheSubject);
                    }
                    if (biology.isChecked()) {
                        bioSubject.enrollStudent(value);
                        subjectsSet.add(bioSubject);
                    }
                    if (physical.isChecked()) {
                        phySubject.enrollStudent(value);
                        subjectsSet.add(phySubject);
                    }
                    if (english.isChecked()) {
                        engSubject.enrollStudent(value);
                        subjectsSet.add(engSubject);
                    }
                }
            }
        }

        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnTeacher) {
                TeacherView teacherWindow = new TeacherView(this, studentView);
                teacherWindow.popup();
            }
        }

        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnStudent) {
                StudentView studentView = new StudentView(this, subjectsSet);
                studentView.popup();
            }
        }
    }

    public Map<String, Student> getMap() {
        return studentView.getMap();
    }

    public ArrayList<Subject> getSubjects() {
        return new ArrayList<>(subjectsSet);
    }
}
