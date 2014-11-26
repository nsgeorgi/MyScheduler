/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_;

public class Process {

    /* περιέχει την χρονική στιγμή άφιξης της διεργασίας στο σύστημα */
    private int arrivalTime;
    /* περιέχει το συνολικό χρόνο απασχόλησης της CPU από τη διεργασία */
    private int cpuTotalTime;
    /* περιέχει τον εναπομείναντα χρόνο απασχόλησης της CPU από τη διεργασία */
    private int cpuRemainingTime;
    /* περιέχει την τρέχουσα κατάσταση της διεργασίας: 0 – Created/New, 1 – Ready/Waiting, 2 –
     Running, 3 – Terminated */
    private int currentState;
    private int c; //xrisimopoiw auti ti metavliti mesa sti klassi cpu gia na brw to response time tou kathe process an i c parei timi 1 simainei oti to process mpike gia prwti fora sti cpu 
    /* constructor – αρχικοποίηση των πεδίων */

    public Process(int aT, int cBT) {


        arrivalTime = aT;
        cpuTotalTime = cBT;
        cpuRemainingTime = cBT;
        currentState = 0;
        c = 0;
    }
    /* θέτει την κατάσταση της διεργασίας ίση με την παράμετρο newState (αλλαγή της
     κατάστασής της) */

    public int setProcessState(int newState) {
        currentState = newState;
        return currentState;
    }
    /* αλλάζει τον εναπομείναντα χρόνο απασχόλησης της CPU από τη διεργασία */

    public void changeCpuRemainingTime(int q) {
        cpuRemainingTime = cpuRemainingTime - q;
        if (cpuRemainingTime <= 0) {
            setProcessState(3);
        }
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getcpuTotalTime() {
        return cpuTotalTime;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void changeC(int t) {
        c = c + t;  //auksanw to c kata 1 , oso einai to c simainei oti toses fores mpike to idio process mesa sti cpu 
    }

    public int getC() {
        return c;
    }
}
