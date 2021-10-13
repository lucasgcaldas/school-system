package com.totalcross.view;

import com.totalcross.model.Grade;
import com.totalcross.model.Student;
import com.totalcross.model.Subject;
import com.totalcross.model.SubjectEnum;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

import java.util.*;

/**
 * Class responsible for create a
 * Window to select which subject the
 * student want to do and the grade
 * @author Lucas Gomes
 */
public class SubjectView extends Window {

    private Button btnTeacher, btnStudent;
    private Button btnApply = new Button("apply");
    private Set<SubjectEnum> subjectsSet = new LinkedHashSet<>();
    private List<Grade> grades = new ArrayList<>();
    private Edit[] edits = new Edit[5];
    private Subject matSubject = new Subject(SubjectEnum.MATHEMATICS);
    private Subject cheSubject = new Subject(SubjectEnum.CHEMICAL);
    private Subject bioSubject = new Subject(SubjectEnum.BIOLOGY);
    private Subject phySubject = new Subject(SubjectEnum.PHYSICAL);
    private Subject engSubject = new Subject(SubjectEnum.ENGLISH);
    private StudentView studentView;
    private Grade matGrade, cheGrade, bioGrade, phyGrade, engGrade;
    private Radio mathematics, chemical, biology, physical, english;


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
                        matSubject.enrollStudent(valueStudent);
                        valueStudent.enrollSubject(matGrade);
                        subjectsSet.add(matSubject.getName());
                        grades.add(matGrade);
                    }
                    if (chemical.isChecked()) {
                        cheGrade = new Grade(valueStudent, cheSubject.getName(), Double.parseDouble(edits[1].getText()));
                        cheSubject.enrollStudent(valueStudent);
                        valueStudent.enrollSubject(cheGrade);
                        subjectsSet.add(cheSubject.getName());
                        grades.add(cheGrade);
                    }
                    if (biology.isChecked()) {
                        bioGrade = new Grade(valueStudent, bioSubject.getName(), Double.parseDouble(edits[2].getText()));
                        bioSubject.enrollStudent(valueStudent);
                        valueStudent.enrollSubject(bioGrade);
                        subjectsSet.add(bioSubject.getName());
                        grades.add(bioGrade);
                    }
                    if (physical.isChecked()) {
                        phyGrade = new Grade(valueStudent, phySubject.getName(), Double.parseDouble(edits[3].getText()));
                        phySubject.enrollStudent(valueStudent);
                        valueStudent.enrollSubject(phyGrade);
                        subjectsSet.add(phySubject.getName());
                        grades.add(phyGrade);
                    }
                    if (english.isChecked()) {
                        engGrade = new Grade(valueStudent, engSubject.getName(), Double.parseDouble(edits[4].getText()));
                        engSubject.enrollStudent(valueStudent);
                        valueStudent.enrollSubject(engGrade);
                        subjectsSet.add(engSubject.getName());
                        grades.add(engGrade);
                    }
                }
            }
        }

        if (event.type == ControlEvent.PRESSED) {
            if (event.target == btnTeacher) {
                MessageBox mb;
                for (String key : studentView.getMap().keySet()) {

                    Student valueStudent = studentView.getMap().get(key);

                    mb = new MessageBox("Summary of the assessments of " + valueStudent.getName() + "!", valueStudent.getSummary(), new String[]{"Nice!"});
                    mb.setRect(CENTER, CENTER, SCREENSIZE + 50, SCREENSIZE + 30);
                    mb.popup();
                }

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

    /**
     * method responsible for
     * return the map of student
     */
    public Map<String, Student> getMap() {
        return studentView.getMap();
    }

    /**
     * method responsible for return
     * the array list of subjects
     */
    public ArrayList<SubjectEnum> getSubjects() {
        return new ArrayList<>(subjectsSet);
    }
}
