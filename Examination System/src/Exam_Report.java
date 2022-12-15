import java.util.Arrays;
public class Exam_Report {
    private Exam exam;
    private int exam_code;
    private Histogram histo;
    private Question[] tough_qes;
    public Exam_Report(Exam exam, Histogram histo) {
        this.exam = exam;
        exam_code = exam.getID();
        this.histo = histo;
    }
    public void display_tough(){
        sortquestions();
        int n = 0;
        for(int i = exam.getQuestions().length - 1; i > exam.getQuestions().length - 6 && i >= 0; i--){
            n++;
            System.out.println(n + " " + exam.getQuestions()[i].getName());
        }
    }
    public void showrank(){
        sortquestions();
        float n = 0, st = (float)histo.getGrades().length;
        String[] s = {"low","medium", "high"};
        for(int i = exam.getQuestions().length - 1; i >= 0; i--){
            n++;
            if((exam.getQuestions()[i].countf/st) < .4)
                exam.getQuestions()[i].setEvaloution_rank(s[0]);
            else if((exam.getQuestions()[i].countf/st) > 0.7)
                exam.getQuestions()[i].setEvaloution_rank(s[2]);
            else
                exam.getQuestions()[i].setEvaloution_rank(s[1]);
            System.out.println(n + ". " + exam.getQuestions()[i].getName());
            System.out.println("Question evaluation rank is: " + exam.getQuestions()[i].getEvaloution_rank());
        }
    }
    public void sortquestions(){
        Arrays.sort(exam.getQuestions(), (a, b) -> a.countf.compareTo(b.countf));
    }

    public Histogram getHisto() {
        return histo;
    }

    public void display_histo(){
        histo.display();
    }
}
