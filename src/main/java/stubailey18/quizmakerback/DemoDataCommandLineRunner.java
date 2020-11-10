package stubailey18.quizmakerback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoDataCommandLineRunner implements CommandLineRunner {

    @Autowired
    private QuizRepo repo;

    @Override
    public void run(String... args) throws Exception {
        Quiz quiz1 = new Quiz();
        quiz1.setName("Berries");
        quiz1.setAuthor("Stuart");
        Question q1 = new Question();
        q1.setQuestion("What type of berry is this?");
        q1.setCorrectAnswer("Raspberry");
        q1.setDistractors(List.of("Blackberry", "Blueberry", "Gooseberry"));
        q1.setImageUrl("https://res.cloudinary.com/dswezohlv/image/upload/v1605042059/quiz-maker/r0t7vc0txkgkoec0slfw.jpg");
        Question q2 = new Question();
        q2.setQuestion("What type of berry is this?");
        q2.setCorrectAnswer("Blueberry");
        q2.setDistractors(List.of("Raspberry", "Blueberry", "Gooseberry"));
        q2.setImageUrl("https://res.cloudinary.com/dswezohlv/image/upload/v1605042271/quiz-maker/unvziwrp1khcjksdwr4x.jpg");
        Question q3 = new Question();
        q3.setQuestion("What type of berry is this?");
        q3.setCorrectAnswer("Gooseberry");
        q3.setDistractors(List.of("Raspberry", "Blueberry", "Blackberry"));
        q3.setImageUrl("https://res.cloudinary.com/dswezohlv/image/upload/v1605042598/quiz-maker/dpxtdbec9eos9vhgs27y.jpg");
        quiz1.setQuestions(List.of(q1, q2, q3));
        repo.save(quiz1);

        Quiz quiz2 = new Quiz();
        quiz2.setName("British History");
        quiz2.setAuthor("Stuart");
        Question q4 = new Question();
        q4.setQuestion("Which king led the English to victory at the battle of Agincourt in 1415?");
        q4.setCorrectAnswer("Henry V");
        q4.setDistractors(List.of("James I", "Charles II", "Edward III"));
        q4.setImageUrl("https://res.cloudinary.com/dswezohlv/image/upload/v1605044474/quiz-maker/lfrsokye0jqmuady1kd2.jpg");
        Question q5 = new Question();
        q5.setQuestion("Winston Churchill was demoted and resigned from the government after which disastrous WW1 campaign?");
        q5.setCorrectAnswer("Gallipoli");
        q5.setDistractors(List.of("Jutland", "Mons", "Cambrai"));
        q5.setImageUrl("https://res.cloudinary.com/dswezohlv/image/upload/v1605045016/quiz-maker/xnsht3tfhruslnt8ga6b.jpg");
        Question q6 = new Question();
        q6.setQuestion("In what year did England and Scotland cease to be separate states with separate legislatures?");
        q6.setCorrectAnswer("1707");
        q6.setDistractors(List.of("1603", "1509", "1805"));
        q6.setImageUrl("https://res.cloudinary.com/dswezohlv/image/upload/v1605045499/quiz-maker/xzi5rxx8xq3te8i2lavq.jpg");
        quiz2.setQuestions(List.of(q4, q5, q6));
        repo.save(quiz2);
    }
}
