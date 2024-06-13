import java.util.Scanner;

public class Main {
    static  int maxGrade (int[] a) {   // find maximum grade in passed array
        int max =a[0];

        for(int i = 1; i< a.length; i++){
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    static  int minGrade (int[] a) {   // find minimum grade in passed array
        int min =a[0];

        for(int i = 1; i< a.length; i++){
            if(a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    static  double averageGrades (int[] a) {   // calculate average of grades
        int sum =0;

        for(int i = 0; i< a.length; i++){
            sum += a[i];
        }
        return (double) sum /a.length;
    }

    static  void generateGraph (int a, int[] stats) {    // generate and display the graph of passed array
        String[] graphString= new String[a];
        for(int y = 0; y < maxGrade(stats); y++){
            if(stats[0]>=y+1) {
                graphString[y] = "\t#######\t";
            } else {
                graphString[y] = "\t\t\t";
            }
            if(stats[1]>=y+1) {
                graphString[y] += "\t#######\t";
            }else {
                graphString[y] += "\t\t\t";
            }
            if(stats[2]>=y+1) {
                graphString[y] += "\t#######\t";
            }else {
                graphString[y] += "\t\t\t";
            }
            if(stats[3]>=y+1) {
                graphString[y] += "\t#######\t";
            }else {
                graphString[y] += "\t\t\t";
            }
            if(stats[4]>=y+1) {
                graphString[y] += "\t#######\t";
            }else {
                graphString[y] += "\t\t\t";
            }
        }

        for(int y = maxGrade(stats)-1; y>=0; y--){
            int yAxis = y + 1;
            System.out.println(yAxis + "\t>" + graphString[y]);
        }
    }

    public static void main(String[] args) {

        Scanner input =new Scanner(System.in);

        System.out.println("Please insert grade of each student");
        String inputGradeString = input.nextLine();
        String[] gradesArr = inputGradeString.split(" ");
        int[] scores = new int[gradesArr.length];
        int[] stats = {0, 0, 0, 0, 0};

        for(int j = 0; j < gradesArr.length; j++) {
            scores[j] = Integer.parseInt(gradesArr[j]);
        }

        for(int x = 0; x< scores.length; x++) {    // counting number of students having grades in specified ranges
            if(scores[x] > 80 && scores[x] <=100) {
                stats[4] += 1;
            } else
            if(scores[x] > 60 && scores[x] <=80) {
                stats[3] += 1;
            } else
            if(scores[x] > 40 && scores[x] <=60) {
                stats[2] += 1;
            } else
            if(scores[x] > 20 && scores[x] <= 40) {
                stats[1] += 1;
            } else
            if(scores[x] >= 0 && scores[x] <=20) {
                stats[0] += 1;
            } else
            if(scores[x] >= 80 && scores[x] <=100) {
                stats[4] += 1;
            }
        }


        System.out.println("\nValues:\n");
        System.out.println("The maximum grade is: " + maxGrade(scores));
        System.out.println("The minimum grade is: " + minGrade(scores));
        System.out.println("The average grade is: " + averageGrades(scores));

        System.out.println("\nGraph:\n");     // displaying graph
        generateGraph(maxGrade(stats),stats);
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\tI\t0-20\tI\t21-40\tI\t41-60\tI\t61-80\tI\t81-100\tI");


    }
}