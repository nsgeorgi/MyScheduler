
package project_;


public class Clock {
    
    /* αποθηκεύει τον τρέχοντα αριθμό χτύπων ρολογιού που έχουν παρέλθει */
protected static int ticks;
/* constructor της κλάσης */
public Clock(){
ticks=0;}
/* αύξηση των χτύπων του ρολογιού (+1) */
public void Time_Run(){
ticks++;}
/* επιστροφή της ώρας βάσει της μεταβλητής ticks */
public int ShowTime(){return ticks;
}
    
}
