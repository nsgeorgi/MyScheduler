package project_;

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessGenerator {

    public static Process process;
    /* αρχείο που αποθηκεύονται τα δεδομένα των νέων διεργασιών */
    private File inputFile;
    private FileWriter inputFile1; //grafw sto arxeio
    private Scanner inputFile2; //diavazw apo to arxeio
    /* constructor της κλάσης; αν readFile == false δημιουργεί το αρχείο inputFile με όνομα
     filename για αποθήκευση, αλλιώς ανοίγει το αρχείο inputFile για ανάγνωση */

    public ProcessGenerator(String filename, boolean readFile) throws FileNotFoundException, IOException {
        if (readFile == true) {  // otan einai true simainei oti to arxeio molis dimiourgithike kai ara tha grapsw se auto

            inputFile1 = new FileWriter("myfile.txt");
        } else {   // otan einai false simainei oti to arxeio uparxei idi ara tha diavasw apo auto

            inputFile2 = new Scanner(new File("myfile.txt"));
        }
    }

    /* δημιουργία μιας νέας διεργασίας με (ψευδο-)τυχαία χαρακτηριστικά */
    public Process createProcess() {
        int aT, cBT;

        Random r1 = new Random();


        aT = r1.nextInt(20 - 1) + 1; // oi times einai tuxai apo to 1 mexri to 20
        cBT = r1.nextInt(20 - 1) + 1;

        process = new Process(aT, cBT);

        return process;
    }

    /* αποθήκευση των στοιχείων της νέας διεργασίας στο αρχείο inputFile1 */
    public void storeProcessToFile(Process proces, int i) throws IOException {


        inputFile1.write(new Integer(proces.getArrivalTime()).toString());
        inputFile1.write("   ");
        inputFile1.write(new Integer(proces.getcpuTotalTime()).toString());
        inputFile1.write("   ");
        if (i == 4) {
            inputFile1.close();
        }
    }
    /* ανάγνωση των στοιχείων νέων διεργασιών από το αρχείο inputFile2 */

    public List<Process> parseProcessFile() {

        List<Process> temp;
        int i = 0;
        temp = new ArrayList<>();
        while (inputFile2.hasNextInt()) {
            process = new Process(inputFile2.nextInt(), inputFile2.nextInt());
            temp.add(i, process);
        }
        return temp;
    }
}
