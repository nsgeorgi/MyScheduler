
package project_;


public class CPU extends Clock{
    
    /* περιέχει τη διεργασία που χρησιμοποιεί τη CPU την τρέχουσα στιγμή */
private Process runningProcess;
/* περιέχει τη χρονική στιγμή της επόμενης διακοπής */
private int timeToNextContextSwitch;
/* περιέχει τη χρονική στιγμή έναρξης της τελευταίας διεργασίας */
private int lastProcessStartTime;
/* constructor – αρχικοποίηση των πεδίων*/

public CPU() {runningProcess=null;
        lastProcessStartTime=ticks;
        timeToNextContextSwitch=0;
                
}

/* εισαγωγή της διεργασίας προς εκτέλεση στη CPU */
public void addProcess(Process pro){
    runningProcess=pro;
    
}
/* εξαγωγή της τρέχουσας διεργασίας από τη CPU */
public Process removeProcessFromCpu(){return runningProcess;
}
/* εκτέλεση της διεργασίας με αντίστοιχη μέιωση του χρόνου εκτέλεσής της */
public void execute(int q,Statistics statistics) {
    if (runningProcess.getC()==0)  
    {
    statistics.changeResponseTime(ShowTime() - runningProcess.getArrivalTime() ); //response time 
    }
    runningProcess.changeC(1);
   timeToNextContextSwitch=ticks+q;
   runningProcess.setProcessState(2);
   runningProcess.changeCpuRemainingTime(q); //meinw to cpuremainingtime kata to quantum 
                                      
   
}
  
public int gettimeToNextContextSwitch()
{
    return timeToNextContextSwitch;
}


}

