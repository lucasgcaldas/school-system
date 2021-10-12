package com.totalcross.view;

import com.totalcross.model.Grade;
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
    public Set<SubjectEnum> subjectsSet = new LinkedHashSet<>();
    public Edit[] edits = new Edit[5];

    StudentView studentView;

    public SubjectView(StudentView studentView, Set<SubjectEnum> subjectsSet) {
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

    private Grade matGrade;
    private Grade cheGrade;
    private Grade bioGrade;
    private Grade phyGrade;
    private Grade engGrade;

    private Radio mathematics;
    private Radio chemical;
    private Radio biology;
    private Radio physical;
    private Radio english;

    public Button btnApply = new Button("apply");

    public void onPopup() {

        for (int i = 0; i < 5; i++) {
            edits[i] = new Edit();
        }

        mathematics = new Radio(matSubject.getName().toString());
        chemical = new Radio(cheSubject.getName().toString());
        biology = new Radio(bioSubject.getName().toString());
        physical = new Radio(phySubject.getName().toString());
        english = new Radio(engSubject.getName().toString());

        Label matDes = new Label("Vacancies = " + matSubject.getVacancies());
        Label cheDes = new Label("Vacancies = " + cheSubject.getVacancies());
        Label bioDes = new Label("Vacancies = " + bioSubject.getVacancies());
        Label phyDes = new Label("Vacancies = " + phySubject.getVacancies());
        Label engDes = new Label("Vacancies = " + engSubject.getVacancies());

        ScrollContainer sc = new ScrollContainer(false, true);
        add(sc, LEFT, AFTER, FILL, 390);

        mathematics.setFont(Font.getFont("Lato Regular", false, 20));
        matDes.setFont(Font.getFont("Lato Regular", false, 15));
        sc.add(mathematics, LEFT + 100, AFTER + 50, PREFERRED + 100, PREFERRED + 25);
        sc.add(matDes, LEFT + 200, AFTER);
        sc.add(edits[0], LEFT + 200, AFTER + 50, 70, 50);

        chemical.setFont(Font.getFont("Lato Regular", false, 20));
        cheDes.setFont(Font.getFont("Lato Regular", false, 15));
        sc.add(chemical, LEFT + 100, AFTER + 50, PREFERRED + 100, PREFERRED + 25);
        sc.add(cheDes, LEFT + 200, AFTER);
        sc.add(edits[1], LEFT + 200, AFTER + 50, 70, 50);

        biology.setFont(Font.getFont("Lato Regular", false, 20));
        bioDes.setFont(Font.getFont("Lato Regular", false, 15));
        sc.add(biology, LEFT + 100, AFTER + 50, PREFERRED + 100, PREFERRED + 25);
        sc.add(bioDes, LEFT + 200, AFTER);
        sc.add(edits[2], LEFT + 200, AFTER + 50, 70, 50);

        physical.setFont(Font.getFont("Lato Regular", false, 20));
        phyDes.setFont(Font.getFont("Lato Regular", false, 15));
        sc.add(physical, LEFT + 100, AFTER + 50, PREFERRED + 100, PREFERRED + 25);
        sc.add(phyDes, LEFT + 200, AFTER);
        sc.add(edits[3], LEFT + 200, AFTER + 50, 70, 50);

        english.setFont(Font.getFont("Lato Regular", false, 20));
        engDes.setFont(Font.getFont("Lato Regular", false, 15));
        sc.add(english, LEFT + 100, AFTER + 50, PREFERRED + 100, PREFERRED + 25);
        sc.add(engDes, LEFT + 200, AFTER);
        sc.add(edits[4], LEFT + 200, AFTER + 50, 70, 50);

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

                    Student valueStudent = studentView.getMap().get(key);

                    if (mathematics.isChecked()) {
                        matGrade = new Grade(valueStudent, matSubject.getName(), Double.parseDouble(edits[0].getText()));
                        matSubject.enrollStudent(valueStudent, matGrade);
                        subjectsSet.add(matSubject.getName());
                    }
                    if (chemical.isChecked()) {
                        cheGrade = new Grade(valueStudent, cheSubject.getName(), Double.parseDouble(edits[1].getText()));
                        cheSubject.enrollStudent(valueStudent, cheGrade);
                        subjectsSet.add(cheSubject.getName());
                    }
                    if (biology.isChecked()) {
                        bioGrade = new Grade(valueStudent, bioSubject.getName(), Double.parseDouble(edits[2].getText()));
                        bioSubject.enrollStudent(valueStudent, bioGrade);
                        subjectsSet.add(bioSubject.getName());
                    }
                    if (physical.isChecked()) {
                        phyGrade = new Grade(valueStudent, phySubject.getName(), Double.parseDouble(edits[3].getText()));
                        phySubject.enrollStudent(valueStudent, phyGrade);
                        subjectsSet.add(phySubject.getName());
                    }
                    if (english.isChecked()) {
                        engGrade = new Grade(valueStudent, engSubject.getName(), Double.parseDouble(edits[4].getText()));
                        engSubject.enrollStudent(valueStudent, engGrade);
                        subjectsSet.add(engSubject.getName());
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

    public ArrayList<SubjectEnum> getSubjects() {
        return new ArrayList<>(subjectsSet);
    }
}
