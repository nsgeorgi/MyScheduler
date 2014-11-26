package project_;

import java.util.LinkedList;
import java.util.Queue;

public class ReadyProcessesList {
    /* η λίστα που περιέχει τις έτοιμες διεργασίες */

    private Queue<Process> processList; //dimiourgw mia oura Fifo giaa tin Rready list
    /* constructor της κλάσης */

    public ReadyProcessesList() {
        processList = new LinkedList<>();
    }
    /* προσθήκη μιας νέας έτοιμης διεργασίας στη λίστα*/

    public void addProcess(Process item) {
        processList.add(item);
    }
    /* επιστροφή της διεργασίας της οποίας η σειρά είναι να εκτελεστεί στη CPU σύμφωνα με τον
     εκάστοτε αλγόριθμο δρομολόγησης */

    public Process getProcessToRunInCPU() {
        return processList.poll();
    }
    /* εκτύπωση του περιεχομένου της λίστας στην οθόνη */

    public Queue<Process> returnList() {
        return processList;
    }

    public void printList() {
        Queue<Process> tmp;
        tmp = processList;
        while (!tmp.isEmpty()) {
            System.out.println(tmp.poll());
        }
    }
}
