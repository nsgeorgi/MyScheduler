package project_;

import java.io.File;
import java.io.IOException;

public class Project_ {

    public static NewProcessTemporaryList nptl;
    public static CPU cpu;
    public static ProcessGenerator pro_gen;
    public static Clock clock;
    public static ReadyProcessesList rpl;
    public static Statistics statistics;
    public static RRScheduler rr;

    public static void main(String[] args) throws IOException {
            int q1=3;
            int q2=9;
        boolean flag = false;
        File f;
        f = new File("myfile.txt");     //Prwti roi ektelesis
        if (!f.exists()) {              //ean to arxeio den  uparxei tote to dimiourgw
            rr = new RRScheduler(q1);        // me tin prwti roi ektelesis ethesa to quantum=3 
            nptl = new NewProcessTemporaryList();
            flag = true;
            f.createNewFile();
            System.out.println("New file \"myfile.txt\" has been created   to the current directory");
            pro_gen = new ProcessGenerator("myfile.txt", flag); //dimiourgw pseudotuxaia xaraktiristika gia ta processes
            for (int i = 0; i < 5; i++) {      //dimiourgw tin lista me ta new processes  
                
                nptl.addNewProcess(pro_gen.createProcess());
                pro_gen.storeProcessToFile(nptl.getFirst(i), i);  //apothikeusi twn pseudotuxaiwn xaraktiristikwn se mia lista me processes
            }

        } else {        //Deuteri roi ektelesis 
            rr = new RRScheduler(q2);
            pro_gen = new ProcessGenerator("myfile.txt", flag);
            nptl = new NewProcessTemporaryList(pro_gen.parseProcessFile());

         }

        clock = new Clock();
        cpu = new CPU();
        rpl = new ReadyProcessesList();        
        statistics = new Statistics("output.txt");     //dimiourgw to arxeio output gia na grapsw ta statistika 

        while (clock.ShowTime() < 2000) { // Ksekinaei to roloi kai mazi kai o algorithmos RR gia na steilei tin kathe diergasia

            rr.RR(cpu, rpl, nptl, clock, statistics);  //Algorithmos RR

            clock.Time_Run();       //auksanetai o xronos kata 1
        }
        
        if (flag) { 
        statistics.WriteStatistics2File(q1); }
        else {statistics.WriteStatistics2File(q2);}  //grafw ta statistika sto arxeio
    }
}