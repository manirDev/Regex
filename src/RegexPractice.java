import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

    public static void main(String[] args) {
        String transcript = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender: 	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	    3.46
                """;
        String regex = """
                       Student\\sNumber:\\s(?<stdNumber>\\w{10}).* #student number
                       Grade:\\s+(?<grade>\\d{2})\\b.*
                       Birthdate:\\s+(?<birthDate>\\d{2}/\\d{2}/\\d{4})\\b.*
                       Gender:\\s+(?<gender>\\w?)\\b.*
                       State\\sID:\\s+(?<stateId>\\d{10})\\b.*
                       Weighted\\)\\s+(?<weightedGPA>\\d\\.\\d*)\\b.*
                       Unweighted\\)\\s+(?<UnWeightedGPA>[\\d\\.]+)\\b.*
                       """;
        Pattern pattern = Pattern.compile(regex, Pattern.COMMENTS | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(transcript);
        if (matcher.matches()){
            System.out.format("Student Number: %s", matcher.group("stdNumber"));
            System.out.format("\nGrade: %s", matcher.group("grade"));
            System.out.format("\nBirthdate: %s", matcher.group("birthDate"));
            System.out.format("\nGender: %s", matcher.group("gender"));
            System.out.format("\nState ID: %s", matcher.group("stateId"));
            System.out.format("\nCumulative GPA (Weighted): %s", matcher.group("weightedGPA"));
            System.out.format("\nCumulative GPA (Unweighted): %s", matcher.group("UnWeightedGPA"));
        }
    }
}
