package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SchoolAllotment {

    static class Student
    {
        int id;
        int score;
        int[] schools;

        @Override
        public String toString() {
            return String.format("[id: %d , score: %d, school choices: %s ]", id, score, Arrays.toString(schools));
        }
    }

    public static int[] AllocateSchools()
    {
        int[] schoolAllotedSeats = new int[] { 2,3,4,1,5};
        int[] studentScores = new int[] {78,77,53,90,80,50,88,77,67,98,95,35,92,84};
        int[][] studentChoices =new int[][] {
                {  1,2,3 },
                {  1,2,3 },
                {  1,2,3 },
                {  1,2,3 },
                {  1,2,3 },
                {  1,2,3 },
                {  1,2,3 },
                {  1,2,3 },
                {  1,2,3 },
                {  2,3,4 },
                {  2,3,4 },
                {  2,3,5 },
                {  2,3,5 },
                {  1,2,3 },
        };

        Student[] students = new Student[studentScores.length];
        for(int i=0;i < students.length;i++) {
            students[i] = new Student();
            Student s = students[i];
            s.id = i; s.score = studentScores[i]; s.schools = studentChoices[i];
        }

        HashMap<Integer,Integer> seats = new HashMap<Integer, Integer>();
        for(int i=0;i<schoolAllotedSeats.length;i++) {
            seats.put(i,schoolAllotedSeats[i]);
            System.out.printf("[school %d = %d seats ]", i+1, schoolAllotedSeats[i]);
        }

        System.out.println();
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s2.score - s1.score; // s2 - s1 to order it descendingly
            }
        });

        int remainingStudnets = 0;
        for(int i=0;i < students.length; i++) {
            Student s = students[i];
            boolean alloted = false;
            for(int j=0;j<s.schools.length;j++) {
                int school = s.schools[j]-1;
                int available = seats.get(school);
                if(available > 0) { // the school is available for this student
                    alloted = true;
                    seats.put(school, --available);
                    System.out.printf("Student %d is going to school %d. %s\n" , s.id, school+1, s);
                    break;
                }
        }

        if(!alloted)
        {
            System.out.printf("Student %d has no school to go. %s\n", s.id, s);
            remainingStudnets++;
        }
    }

        int remainingSeats = 0;
        for(int i=0;i < seats.size(); i++) {
            int available = seats.get(i);
            if(available > 0) remainingSeats+=available;
        }

        System.out.println("\nUnallocated Students:" + remainingStudnets);
        System.out.println("Unallocated School Seats:" + remainingSeats);
        return new int[] {remainingSeats, remainingStudnets};
    }

    public static void main(String[] args) {
        AllocateSchools();
    }

}
