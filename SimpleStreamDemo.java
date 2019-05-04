package simplestreamdemo;

import java.io.PrintStream;
import java.time.LocalDate;

// imports left as hints
import static java.time.LocalDate.of;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import java.util.stream.IntStream;

/**
 * Class demo.
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class SimpleStreamDemo {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        Collection<Student> students = getStudents();
        PrintStream out = System.out;

        //TODO
        
    }
    
    public Collection<Student> getStudentCollection() {
        Collection<Student> students = getStudents();
        return students;
    }
    
    public int countStudents() {
        int studentCount = (int) getStudentCollection()
                .stream()
                .count();
        return studentCount;
    }
    
    public int maleCount() {
        int maleCount = (int) getStudentCollection()
                .stream()
                .filter(s -> s.getGender() == 'M')
                .count();
        return maleCount;
    }
    
    public Optional<Student> getYoungestStudent() {
        LocalDate last = getStudentCollection()
                .stream()
                .map(s -> s.getDob())
                .max(Comparator.comparing(LocalDate::toEpochDay))
                .get();
        
        Optional<Student> youngest = getStudentCollection()
                .stream()
                .filter(s -> s.getDob() == last)
                .findFirst();
        
        return youngest;
    }
    
    public List<Student> getStudentsWithA() {
        List<Student> withA = new ArrayList<>();
        withA = getStudentCollection()
                .stream()
                .filter(s -> s.getFirstName().contains("a").and(s.getLastName().contains("a")))
                .collect(Collectors.toList());
                
    }

    static String fullName( Student s ) {
        return s.firstName + ' ' + s.lastName;
    }

    //<editor-fold defaultstate="collapsed" desc="defining students, NO WORK HERE">
    static final Collection<Student> getStudents() {
        return Arrays.asList( new Student[]{
            s( 3134521, "Malvina", "Moulden", of( 1995, 01, 25 ), 'F' ),
            s( 3134522, "Eugenio", "Elias", of( 1998, 8, 9 ), 'M' ),
            s( 3134523, "Eleanore", "Estey", of( 1996, 07, 28 ), 'F' ),
            s( 3134524, "Olympia", "Oliphant", of( 1997, 03, 8 ), 'F' ),
            s( 3134525, "Candi", "Cortinas", of( 1997, 02, 23 ), 'F' ),
            s( 3134526, "Edmundo", "Evett", of( 1999, 04, 01 ), 'M' ),
            s( 3134527, "Nicol", "Neufeld", of( 1995, 05, 22 ), 'F' ),
            s( 3134528, "Dewitt", "Dossey", of( 1994, 8, 12 ), 'M' ),
            s( 3134529, "Waneta", "Woodley", of( 1997, 06, 06 ), 'F' ),
            s( 3134530, "Patrica", "Paden", of( 1998, 11, 14 ), 'F' ),
            s( 3134531, "Alanna", "Ardoin", of( 1999, 10, 31 ), 'F' ),
            s( 3134532, "Sixta", "Savala", of( 1999, 04, 9 ), 'F' ),
            s( 3134533, "Melva", "Maillet", of( 1993, 01, 16 ), 'F' ),
            s( 3134534, "Basilia", "Benge", of( 1996, 03, 29 ), 'F' ),
            s( 3134535, "Mirna", "Mcglothin", of( 1995, 07, 22 ), 'F' ),
            s( 3134536, "Laurie", "Lampley", of( 1994, 07, 06 ), 'F' ),
            s( 3134537, "Enid", "Eddins", of( 1997, 12, 06 ), 'F' ),
            s( 3134538, "Leanna", "Luton", of( 1996, 01, 30 ), 'F' ),
            s( 3134539, "Shirleen", "Simpson", of( 1999, 12, 30 ), 'F' ),
            s( 3134540, "Elida", "Esposito", of( 1998, 05, 13 ), 'F' ),
            s( 3134541, "Dominga", "Dinapoli", of( 1997, 11, 28 ), 'F' ),
            s( 3134542, "Terence", "Toenjes", of( 1996, 04, 05 ), 'M' ),
            s( 3134543, "Lavette", "Lockman", of( 1993, 06, 16 ), 'F' ),
            s( 3134544, "Sofia", "Shoulders", of( 1997, 07, 10 ), 'F' ),
            s( 3134545, "Marci", "Mayon", of( 1995, 01, 21 ), 'F' ),
            s( 3134546, "Horace", "Halbert", of( 1997, 10, 20 ), 'M' ),
            s( 3134547, "Ethan", "Eisenberg", of( 1996, 03, 19 ), 'M' ),
            s( 3134548, "Greg", "Gumm", of( 1998, 11, 23 ), 'M' ),
            s( 3134549, "Jeremy", "Jin", of( 1997, 05, 29 ), 'M' ),
            s( 3134550, "Shaunte", "Stollings", of( 1995, 9, 15 ), 'M' ),
            s( 3134551, "Jovita", "Jacobi", of( 1997, 05, 23 ), 'F' ),
            s( 3134552, "Jonathan", "Junkin", of( 1997, 06, 15 ), 'M' ),
            s( 3134553, "Willetta", "Woelfel", of( 1998, 05, 03 ), 'F' ),
            s( 3134554, "Mara", "Malcom", of( 1999, 12, 11 ), 'F' ),
            s( 3134555, "Charles", "Coward", of( 1999, 05, 8 ), 'M' ),
            s( 3134556, "Tisha", "Tischler", of( 1995, 12, 18 ), 'F' ),
            s( 3134557, "Armandina", "Aldrete", of( 1999, 05, 25 ), 'F' ),
            s( 3134558, "Talisha", "Tomasi", of( 1997, 12, 25 ), 'F' ),
            s( 3134559, "Jude", "Jarrett", of( 1998, 06, 17 ), 'M' ),
            s( 3134560, "Nona", "Napoles", of( 1994, 03, 22 ), 'F' ),
            s( 3134561, "Ma", "Montelongo", of( 1995, 03, 9 ), 'F' ),
            s( 3134562, "Arleen", "Anderton", of( 1994, 07, 02 ), 'F' ),
            s( 3134563, "Glayds", "Gathers", of( 1996, 05, 24 ), 'F' ),
            s( 3134564, "Khadijah", "Kozel", of( 1993, 05, 24 ), 'F' ),
            s( 3134565, "Deja", "Darnell", of( 1999, 9, 13 ), 'F' ),
            s( 3134566, "Dave", "Dycus", of( 1995, 9, 27 ), 'M' ),
            s( 3134567, "Analisa", "Alam", of( 1997, 07, 03 ), 'M' ),
            s( 3134568, "Otto", "Oconnell", of( 1996, 06, 02 ), 'M' ),
            s( 3134569, "Oliver", "Oconnell", of( 1996, 06, 02 ), 'M' ),
            s( 3134570, "Scottie", "Summa", of( 1996, 05, 27 ), 'M' ),
            s( 3134571, "Lynda", "Lundberg", of( 1999, 01, 30 ), 'F' ), 
            s( 3134572, "Quentin", "Quack", of( 1999, 01, 30 ), 'F' ), 
        
        } );
    }

    static class Student {

        static int studentSerialSeq = 0;

        enum EyeColor {
            BROWN, BLUE, GREY, GREEN, HAZEL, AMBER, RED;
        }

        enum HairColor {
            BLACK, BLOND, BLACKBLUE, DARKBROWN, AUBRUN, GINGER, GREY, WHITE;
        }
        final int id;
        final String firstName;
        final String lastName;
        final LocalDate dob;
        final char gender;
        final EyeColor eyeColor;
        final HairColor hairColor;
        static final Random rnd = new Random();

        public Student( int id, String fname, String lname, LocalDate dob, char gender ) {
            this.id = id;
            this.firstName = fname;
            this.lastName = lname;
            this.dob = dob;
            this.gender = gender;
            eyeColor = EyeColor.values()[ rnd.nextInt( EyeColor.values().length ) ];
            hairColor
                    = HairColor.values()[ studentSerialSeq++ % HairColor.values().length ];
        }

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", name=" + padTo( 18, firstName + " " + lastName ) + ", dob=" + dob + ", gender=" + gender
                    + ", eye " + padTo( 5, eyeColor ) + ", hair " + padTo( 10, hairColor ) + '}';
        }

        public static int getStudentSerialSeq() {
            return studentSerialSeq;
        }

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public LocalDate getDob() {
            return dob;
        }

        public char getGender() {
            return gender;
        }

        public EyeColor getEyeColor() {
            return eyeColor;
        }

        public HairColor getHairColor() {
            return hairColor;
        }

        public static Random getRnd() {
            return rnd;
        }

    }

    static Student s( int id, String fname, String lname, LocalDate dob, char gender ) {
        return new Student( id, fname, lname, dob, gender );
    }

    static String padTo( int max, Object s ) {
        StringBuilder sb = new StringBuilder( s.toString() );
        while ( sb.length() < max ) {
            sb.append( ' ' );
        }
        return sb.toString();
    }
    //</editor-fold>
}
