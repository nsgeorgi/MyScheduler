package project_;

public class RRScheduler {
    /* αναπαριστά την τιμή του quantum με βάση το οποίο γίνεται η δρομολόγηση */

    private int quantum;

    /* constructor της κλάσης */
    RRScheduler(int q) {
        quantum = q;
    }
    /* τοποθετεί μια διεργασία στην κατάλληλη θέση της λίστας των έτοιμων διεργασιών*/

    public void addProcessToReadyList(Process process) {
    }
    /* εκτελεί την εναλλαγή διεργασίας στη CPU με βάση τη λίστα έτοιμων διεργασιών και την τιμή
     του quantum */

    public void RR(CPU cpu, ReadyProcessesList rpl, NewProcessTemporaryList nptl, Clock clock, Statistics statistics) {

        if (cpu.gettimeToNextContextSwitch() == clock.ShowTime()) { //an o xronos tis teleutaias diakopis apo tin cpu einai isos me to roloi tote i cpu einai eleutheri
            if (cpu.removeProcessFromCpu() != null && cpu.removeProcessFromCpu().getCurrentState() != 3) { //an den exei termatisei i diergasia pou vrisketai sti cpu

                rpl.addProcess(cpu.removeProcessFromCpu());  //ekxwrw tin diergasia pou teleiwse apo tin cpu pali stin readylista giati den teleiwsei akoma
                cpu.removeProcessFromCpu().setProcessState(1); //thetw tin katastasi tis se Waiting 
            } else if (cpu.removeProcessFromCpu() != null && cpu.removeProcessFromCpu().getCurrentState() == 3) {
                
                 statistics.changeTurnaroundTime(clock.ShowTime() - cpu.removeProcessFromCpu().getArrivalTime());
                statistics.changeWaitingTime(clock.ShowTime() - cpu.removeProcessFromCpu().getArrivalTime() - (quantum * cpu.removeProcessFromCpu().getC())); //upologizw to waiting time tis 
            }
        }
        for (int j = 0; j < 5; j++) {
            if (clock.ShowTime() == nptl.getFirst(j).getArrivalTime()) //an to roloi einai iso me to xrono afikseis mia apo tis diergasies
            {
                nptl.getFirst(j).setProcessState(1);
                rpl.addProcess(nptl.getFirst(j)); //ekxwreitai i process stin ready list 
            }
        }
        if (rpl.returnList().size() > statistics.getmaximumLengthOfReadyProcessesList()) { //vriskw to maxlength tis Ready list
            statistics.changemaximumLengthOfReadyProcessesList(rpl.returnList().size());
        }


        if (cpu.gettimeToNextContextSwitch() <= clock.ShowTime()) { // an o xronos tis teleutaias diakopis apo tin cpu einai mikroteros apo to roloi
            Process tmp;                //simainei oti i cpu einai eleutheri
            tmp = rpl.getProcessToRunInCPU();
            if (tmp != null) {
                // an i lista den einai adeia afairw tin diergasia apo tin readylist

                cpu.addProcess(tmp);// kai tin stelnw stin cpu
                cpu.execute(quantum, statistics);// ekteleita i process stin cpu
            }
        }
    }
}
