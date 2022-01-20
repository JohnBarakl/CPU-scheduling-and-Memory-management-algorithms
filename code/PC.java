
public class PC {

    public static void main(String[] args) {
        final Process[] processes = {
                // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                new Process(2, 3, 55),
                new Process(2, 5, 30),
                new Process(2, 9, 15),
                new Process(2, 4, 45)
        };
        final int[] availableBlockSizes = {20, 70, 35, 55}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new FirstFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);        
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();
    /*
         final Process[] processes2 = {
        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
        new Process(1, 15, 15),
        new Process(9, 7 , 32),
        new Process(9, 4, 5),
        new Process(12, 1, 18)
        };
        final int[] availableBlockSizes2 = {50, 26 , 75, 10}; // sizes in kB
        MemoryAllocationAlgorithm algorithm2 = new NextFit(availableBlockSizes2);
        MMU mmu2 = new MMU(availableBlockSizes2, algorithm2);
        Scheduler scheduler2 = new FCFS();
        CPU cpu2 = new CPU(scheduler2, mmu2, processes2);
        cpu2.run();

        final Process[] processes3 = {
        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
        new Process(1, 5, 40),
        new Process(3, 2, 30),
        new Process(3, 1, 32),
        new Process(5, 6, 55)
        };
        final int[] availableBlockSizes3 = {25, 15, 24, 17}; // sizes in kB
        MemoryAllocationAlgorithm algorithm3 = new FirstFit(availableBlockSizes3);
        MMU mmu3 = new MMU(availableBlockSizes3,algorithm3);
        Scheduler scheduler3= new SRTF();
        CPU cpu3= new CPU(scheduler3,mmu3,processes3);
        cpu3.run();

        final Process[] processes4= {
        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
        new Process(1, 27, 10),
        new Process(9,3 , 15),
        new Process(9,  2,32),
        new Process(12, 1, 25)
        };
        final int[] availableBlockSizes4 = {60, 35 , 42, 15}; // sizes in kB
        MemoryAllocationAlgorithm algorithm4 = new BestFit(availableBlockSizes4);
        MMU mmu4 = new MMU(availableBlockSizes4, algorithm4);
        Scheduler scheduler4 = new FCFS();
        CPU cpu4 = new CPU(scheduler4, mmu4, processes4);
        cpu4.run();


        final Process[] processes5= {
        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
        new Process(0, 3, 19),
        new Process(1,10, 25),
        new Process(5, 35,12),
        new Process(7, 18, 9)
        };
        final int[] availableBlockSizes5 = {46,34,25,10}; // sizes in kB
        MemoryAllocationAlgorithm algorithm5 = new WorstFit(availableBlockSizes5);
        MMU mmu5 = new MMU(availableBlockSizes5, algorithm5);
        Scheduler scheduler5 = new RoundRobin();
        CPU cpu5 = new CPU(scheduler5, mmu5, processes5);
        cpu5.run();

        final Process[] processes6= {
        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
        new Process(2, 6, 25),
        new Process(3,5, 13),
        new Process(1, 9,7),
        new Process(5, 10, 2)
        };
        final int[] availableBlockSizes6 = {6,24,33,12}; // sizes in kB
        MemoryAllocationAlgorithm algorithm6 = new BestFit(availableBlockSizes6);
        MMU mmu6 = new MMU(availableBlockSizes6, algorithm6);
        Scheduler scheduler6 = new RoundRobin();
        CPU cpu6 = new CPU(scheduler6, mmu6, processes6);
        cpu6.run();

        final Process[] processes7= {
        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
        new Process(8, 8, 21),
        new Process(4,3, 17),
        new Process(3,  2,6),
        new Process(5, 6, 6)
        };
        final int[] availableBlockSizes7 = {8,5,18,45}; // sizes in kB
        MemoryAllocationAlgorithm algorithm7 = new WorstFit(availableBlockSizes7);
        MMU mmu7 = new MMU(availableBlockSizes7, algorithm7);
        Scheduler scheduler7 = new SRTF();
        CPU cpu7 = new CPU(scheduler7, mmu7, processes7);
        cpu7.run();

        final Process[] processes8= {
        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
        new Process(2, 7, 20),
        new Process(6,13, 40),
        new Process(6,  7,14),
        new Process(9, 4, 7)
        };
        final int[] availableBlockSizes8 = {80,35,10,33}; // sizes in kB
        MemoryAllocationAlgorithm algorithm8 = new  NextFit(availableBlockSizes8);
        MMU mmu8 = new MMU(availableBlockSizes8, algorithm8);
        Scheduler scheduler8 = new SRTF();
        CPU cpu8 = new CPU(scheduler8, mmu8, processes8);
        cpu8.run();

        final Process[] processes9= {
        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
        new Process(2, 4, 20),
        new Process(6,14, 12),
        new Process(6,  6,6),
        new Process(9, 2, 9)
        };
        final int[] availableBlockSizes9 = {60,52,42,30}; // sizes in kB
        MemoryAllocationAlgorithm algorithm9 = new  FirstFit(availableBlockSizes9);
        MMU mmu9 = new MMU(availableBlockSizes9, algorithm9);
        Scheduler scheduler9 = new RoundRobin();
        CPU cpu9 = new CPU(scheduler9, mmu9, processes9);
        cpu9.run();

              final Process[] processes10= {
        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
        new Process(0, 6, 25),
        new Process(2,2, 35),
        new Process(2,  5,25),
        new Process(2, 1, 20 )
        };
        final int[] availableBlockSizes10 = {20,45,60,25}; // sizes in kB
        MemoryAllocationAlgorithm algorithm10 = new  BestFit(availableBlockSizes10);
        MMU mmu10 = new MMU(availableBlockSizes10, algorithm10);
        Scheduler scheduler10 = new FCFS();
        CPU cpu10 = new CPU(scheduler10, mmu10, processes10);
        cpu10.run();
*/
    }

}
