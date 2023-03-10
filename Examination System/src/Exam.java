public class Exam {
    private int ID;
    private Course course;
    private String course_Code;
    private String insName;
    private float duration;
    private float startTime;
    private float endTime;
    private int mark;
    private String date;
    private Question questions[];
    private boolean validation_status;
    private int num_of_questions;
    private boolean first_question;
    private Exam_Report exam_report;
    private static int n_of_exams;
    public int getMark() {
        return mark;
    }

    public void setExam_report(Exam_Report exam_report) {
        this.exam_report = exam_report;
    }

    public Exam_Report getExam_report() {
        return exam_report;
    }

    public Exam( Course course, String date) {
        this.ID = ++n_of_exams;
        this.course = course;
        course_Code = this.course.getCourse_code();
        insName = this.course.getInstructor().getName();
        this.date = date;
        questions = new Question[1];

    }

    public Exam(String ID, Course course, float duration, float startTime, float endTime, String date) {
        this(course, date);
        this.ID = ++n_of_exams;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Exam(){

    }


    public int getID() {
        return ID;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public int getNum_of_questions() {
        return num_of_questions;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void addquestoin(Question question){
        this.mark += question.getGrade();
        if(first_question == true) {
            Question[] temp = new Question[num_of_questions + 1];
            System.arraycopy(questions, 0, temp, 0, questions.length);
            questions = temp;
            questions[num_of_questions++] = question;
        }else {
            questions[num_of_questions++] = question;
            first_question = true;
        }
    }
}
