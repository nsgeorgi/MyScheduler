package project_;

import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;

public class Statistics {
   //o trexwn xronos epistrofis twn diergasiwn 
    private static float TurnaroundTime;
    
    /* ο τρέχων μέσος χρόνος αναμονής των διεργασιών προς εκτέλεση */
    private static float averageWaitingTime;
   
    /* ο τρέχων συνολικός χρόνος αναμονής διεργασιών */
    private static float totalWaitingTime;
    /* ο μέσος χρόνος απόκρισης */
    private static int responseTime;
    /* το τρέχον μέγιστο πλήθος διεργασιών προς εκτέλεση */
    private static int maximumLengthOfReadyProcessesList;
    /* ο τρέχων συνολικός αριθμός διεργασιών */
    public static int totalNumberOfProcesses;
    /*αρχείο που αποθηκεύονται τα στατιστικά δεδομένα */
    private File outputFile;
    private FileWriter outputFile1;
    /* constructor της κλάσης */

    public Statistics(String filename) throws IOException {
        outputFile1 = new FileWriter(filename);
        responseTime = 0;
        averageWaitingTime = 0;
        maximumLengthOfReadyProcessesList = 0;
        totalNumberOfProcesses = 5;
        totalWaitingTime = 0;
    }
    /* ελέγχει το μήκος της λίστας έτοιμων διεργασιών και ενημερώνει, αν είναι απαραίτητο, την
     τιμή της μεταβλητής maximumLengthOfReadyProcessesList */

    public void UpdateMaximumListLength() {
    }
    /*υπολογίζει τον μέσο χρόνο αναμονής*/

    public String CalculateAverageWaitingTime() {
        return (new Float(totalWaitingTime / totalNumberOfProcesses).toString());
    }
    /* προσθέτει  τα τρέχοντα στατιστικά στο αρχείο outputFile1 */

    public void WriteStatistics2File(int q) throws IOException {
         outputFile1.write("         *** STATISTICS OF 5 PROCESSES  RUNNING IN CPU WITH ALGORITH RR [QUANTUM="+q+"] ***"+"\r\n"+"\r\n"+"\r\n");
        outputFile1.write("Average Waiting Time [" + CalculateAverageWaitingTime() + " sec ] " + "\r\n");
        outputFile1.write("Average Response TIme  [" + responseTime / totalNumberOfProcesses);
        outputFile1.write(" sec ] \r\nMaximum Length Of Ready Processes List   [" + maximumLengthOfReadyProcessesList + " sec]"+ "\r\n");
         outputFile1.write("Average TurnAround Time  ["+ TurnaroundTime/totalNumberOfProcesses +" sec ]" );
        outputFile1.close();
    }

    public void changeResponseTime(int x) {
        responseTime = x;
    }

    public void changemaximumLengthOfReadyProcessesList(int x) {
        maximumLengthOfReadyProcessesList = x;
    }

    public void changeTurnaroundTime(int x)
    { TurnaroundTime=TurnaroundTime + x;
}    
    public void changeWaitingTime(int x) {
        totalWaitingTime = totalWaitingTime + x;
    }

    public int getmaximumLengthOfReadyProcessesList() {
        return maximumLengthOfReadyProcessesList;
    }
}