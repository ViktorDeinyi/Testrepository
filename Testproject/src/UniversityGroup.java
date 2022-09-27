import java.util.Arrays;
import java.util.Scanner;

public class UniversityGroup {
    Scanner sc = new Scanner(System.in);
    private String groupName;
    private int startYear;
    private int endYear;
    private String[] studentArray;

    public String getGroupName() {
        return groupName;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public String[] getStudentArray() {
        return studentArray;
    }

    public UniversityGroup(String groupName, int startYear) {
        this.groupName = groupName;
        this.startYear = startYear;
        endYear = startYear + 5;
    }

    public UniversityGroup(String groupName, int startYear, String[] studentArray) {
        this.groupName = groupName;
        this.startYear = startYear;
        this.studentArray = studentArray;
        endYear = startYear + 5;
    }

    public void setaddStudents(String[] studentArray) {
        if (!studentArray.equals(null)) {
            System.out.println("проверка");
            String str = sc.nextLine();
            String[] student = str.split(", ");
            this.studentArray = student;
        }
    }

    public void getGroupDescription() {
        System.out.println(getGroupName());
        System.out.println(getStartYear());
        System.out.println(getEndYear());
        System.out.println(Arrays.toString(getStudentArray()));}

    public static void main (String[] args) {
        UniversityGroup firstGroup = new UniversityGroup("freshman", 2020, new String[]{"tim", "tom", "tor"});
        UniversityGroup secondGroup = new UniversityGroup("oldman", 2018);
        firstGroup.setaddStudents(new String[]{"ama", "ima", "rima"});
        secondGroup.setaddStudents(new String[]{"ama", "ima", "rima"});
        firstGroup.getGroupDescription();
        secondGroup.getGroupDescription();




    }


}
