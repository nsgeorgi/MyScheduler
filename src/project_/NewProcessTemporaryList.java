
package project_;
import java.util.ArrayList;
import java.util.List;


public class NewProcessTemporaryList {
    private List<Process> processList;  //h lista pou periexei tis nees diergasies 
    
    public NewProcessTemporaryList() {
    processList=new ArrayList<>(); } // arxikopoiisi tis listas kai allwn pediwn
    
    public NewProcessTemporaryList(List<Process> tmp) {
    processList=new ArrayList<>();
    processList=tmp;} // arxikopoiisi tis listas kai allwn pediwn
    
    public void addNewProcess(Process proc) {
    processList.add(proc);
    } //eisagwgi mias neas diergasias stin lista
    
    public Process getFirst(int tmp) {   
       
        return      (processList.get(tmp));
    
} /* επιστροφή της πρώτης διεργασίας της λίστας */
    
/* εκτύπωση της λίστας με τις νέες διεργασίες στην οθόνη */
public void printList() {
int i=0;
while (i<processList.size())
{    
    
    System.out.println(processList.get(i).getArrivalTime());
    System.out.println(processList.get(i).getcpuTotalTime());
     
    i++;
}}

    
    
    
    
}
