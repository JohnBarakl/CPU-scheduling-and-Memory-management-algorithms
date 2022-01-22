import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SOTesting {
    @BeforeEach
    public void setUp(){
        CPU.clock = 0; // Re-initialize clock time.
    }

    @Test
    public void TestNormalFCFSWithFirstFit()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(1, 5, 40),
                        new Process(3, 2, 35),
                        new Process(4, 1, 12),
                        new Process(5, 6, 23)
                };
        final int[] availableBlockSizes = {35,57,40,25}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new FirstFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();


        // Process 1
        assertEquals(8.0,processes[0].getTurnAroundTime());
        assertEquals(3.0,processes[0].getWaitingTime());
        assertEquals(3.0,processes[0].getResponseTime());

        //Process 2
        assertEquals(13.0,processes[1].getTurnAroundTime());
        assertEquals(11.0,processes[1].getWaitingTime());
        assertEquals(11.0,processes[1].getResponseTime());


        // Process 3
        assertEquals(15.0,processes[2].getTurnAroundTime());
        assertEquals(14.0,processes[2].getWaitingTime());
        assertEquals(14.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(22.0,processes[3].getTurnAroundTime());
        assertEquals(16.0,processes[3].getWaitingTime());
        assertEquals(16.0,processes[3].getResponseTime());
    }

    @Test
    public void TestNormalFCFSWithNextFit()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(1, 5, 40),
                        new Process(3, 2, 35),
                        new Process(4, 1, 12),
                        new Process(5, 6, 23)
                };
        final int[] availableBlockSizes = {35,57,40,25}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new NextFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(8.0,processes[0].getTurnAroundTime());
        assertEquals(3.0,processes[0].getWaitingTime());
        assertEquals(3.0,processes[0].getResponseTime());

        //Process 2
        assertEquals(13.0,processes[1].getTurnAroundTime());
        assertEquals(11.0,processes[1].getWaitingTime());
        assertEquals(11.0,processes[1].getResponseTime());

        // Process 3
        assertEquals(15.0,processes[2].getTurnAroundTime());
        assertEquals(14.0,processes[2].getWaitingTime());
        assertEquals(14.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(22.0,processes[3].getTurnAroundTime());
        assertEquals(16.0,processes[3].getWaitingTime());
        assertEquals(16.0,processes[3].getResponseTime());
    }

    @Test
    public void TestNormalFCFSWithBestFit()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(1, 5, 40),
                        new Process(3, 2, 35),
                        new Process(4, 1, 12),
                        new Process(5, 6, 23)
                };
        final int[] availableBlockSizes = {35,57,40,25}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new BestFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(8.0,processes[0].getTurnAroundTime());
        assertEquals(3.0,processes[0].getWaitingTime());
        assertEquals(3.0,processes[0].getResponseTime());

        //Process 2
        assertEquals(13.0,processes[1].getTurnAroundTime());
        assertEquals(11.0,processes[1].getWaitingTime());
        assertEquals(11.0,processes[1].getResponseTime());

        // Process 3
        assertEquals(15.0,processes[2].getTurnAroundTime());
        assertEquals(14.0,processes[2].getWaitingTime());
        assertEquals(14.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(22.0,processes[3].getTurnAroundTime());
        assertEquals(16.0,processes[3].getWaitingTime());
        assertEquals(16.0,processes[3].getResponseTime());
    }

    @Test
    public void TestNormalFCFSWithWorstFit()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(1, 5, 40),
                        new Process(3, 2, 35),
                        new Process(4, 1, 12),
                        new Process(5, 6, 23)
                };
        final int[] availableBlockSizes = {35,57,40,25}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new WorstFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(8.0,processes[0].getTurnAroundTime());
        assertEquals(3.0,processes[0].getWaitingTime());
        assertEquals(3.0,processes[0].getResponseTime());

        //Process 2
        assertEquals(13.0,processes[1].getTurnAroundTime());
        assertEquals(11.0,processes[1].getWaitingTime());
        assertEquals(11.0,processes[1].getResponseTime());

        // Process 3
        assertEquals(15.0,processes[2].getTurnAroundTime());
        assertEquals(14.0,processes[2].getWaitingTime());
        assertEquals(14.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(22.0,processes[3].getTurnAroundTime());
        assertEquals(16.0,processes[3].getWaitingTime());
        assertEquals(16.0,processes[3].getResponseTime());
    }

    @Test
    public void FCFSWithFirstFitSameArrival()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(2, 3, 55),
                        new Process(2, 5, 30),
                        new Process(2, 9, 15),
                        new Process(2, 4, 45)
                };
        final int[] availableBlockSizes = {20,70,35,55}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new FirstFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(9.0,processes[0].getTurnAroundTime());
        assertEquals(6.0,processes[0].getWaitingTime());
        assertEquals(6.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(16.0,processes[1].getTurnAroundTime());
        assertEquals(11.0,processes[1].getWaitingTime());
        assertEquals(11.0,processes[1].getResponseTime());


        // Process 3
        //assertEquals(,processes[2].getTurnAroundTime());
        //assertEquals(,processes[2].getWaitingTime());
        //assertEquals(,processes[2].getResponseTime());

        // Process 4
        //assertEquals(,processes[3].getTurnAroundTime());
        //assertEquals(,processes[3].getWaitingTime());
        //assertEquals(,processes[3].getResponseTime());
    }

    @Test
    public void FCFSWithNextFitSameArrival()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(2, 3, 55),
                        new Process(2, 5, 30),
                        new Process(2, 9, 15),
                        new Process(2, 4, 45)
                };
        final int[] availableBlockSizes = {20,70,35,55}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new NextFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(8.0,processes[0].getTurnAroundTime());
        assertEquals(5.0,processes[0].getWaitingTime());
        assertEquals(5.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(16.0,processes[1].getTurnAroundTime());
        assertEquals(11.0,processes[1].getWaitingTime());
        assertEquals(11.0,processes[1].getResponseTime());

        // Process 3
        assertEquals(27.0,processes[2].getTurnAroundTime());
        assertEquals(18.0,processes[2].getWaitingTime());
        assertEquals(18.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(33.0,processes[3].getTurnAroundTime());
        assertEquals(29.0,processes[3].getWaitingTime());
        assertEquals(29.0,processes[3].getResponseTime());
    }

    @Test
    public void FCFSWithBestFitSameArrival()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(2, 3, 55),
                        new Process(2, 5, 30),
                        new Process(2, 9, 15),
                        new Process(2, 4, 45)
                };
        final int[] availableBlockSizes = {20,70,35,55}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new BestFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(9.0,processes[0].getTurnAroundTime());
        assertEquals(6.0,processes[0].getWaitingTime());
        assertEquals(6.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(16.0,processes[1].getTurnAroundTime());
        assertEquals(11.0,processes[1].getWaitingTime());
        assertEquals(11.0,processes[1].getResponseTime());

        // Process 3
        assertEquals(27.0,processes[2].getTurnAroundTime());
        assertEquals(18.0,processes[2].getWaitingTime());
        assertEquals(18.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(33.0,processes[3].getTurnAroundTime());
        assertEquals(29.0,processes[3].getWaitingTime());
        assertEquals(29.0,processes[3].getResponseTime());
    }

    @Test
    public void FCFSWithWorstFitSameArrival()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(2, 3, 55),
                        new Process(2, 5, 30),
                        new Process(2, 9, 15),
                        new Process(2, 4, 45)
                };
        final int[] availableBlockSizes = {20,70,35,55}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new WorstFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(8.0,processes[0].getTurnAroundTime());
        assertEquals(5.0,processes[0].getWaitingTime());
        assertEquals(5.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(16.0,processes[1].getTurnAroundTime());
        assertEquals(11.0,processes[1].getWaitingTime());
        assertEquals(11.0,processes[1].getResponseTime());

        // Process 3
        assertEquals(27.0,processes[2].getTurnAroundTime());
        assertEquals(18.0,processes[2].getWaitingTime());
        assertEquals(18.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(33.0,processes[3].getTurnAroundTime());
        assertEquals(29.0,processes[3].getWaitingTime());
        assertEquals(29.0,processes[3].getResponseTime());
    }

    @Test
    public void FCFSWithFirstFitWhenNoneOfTheProcessesFit()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(2, 3, 40),
                        new Process(2, 5, 30),
                        new Process(2, 9, 32),
                        new Process(2, 4, 55)
                };
        final int[] availableBlockSizes = {25,15,24,17}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new FirstFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());


        // Process 3
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());


        // Process 4
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());

    }

    @Test
    public void FCFSWithNextFitWhenNoneOfTheProcessesFit()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(2, 3, 40),
                        new Process(2, 5, 30),
                        new Process(2, 9, 32),
                        new Process(2, 4, 55)
                };
        final int[] availableBlockSizes = {25,15,24,17}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new NextFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());


        // Process 3
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());


        // Process 4
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());

    }

    @Test
    public void FCFSWithBestFitWhenNoneOfTheProcessesFit()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(2, 3, 40),
                        new Process(2, 5, 30),
                        new Process(2, 9, 32),
                        new Process(2, 4, 55)
                };
        final int[] availableBlockSizes = {25,15,24,17}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new BestFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());


        // Process 3
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());


        // Process 4
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());

    }

    @Test
    public void FCFSWithFWorstFitWhenNoneOfTheProcessesFit()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(2, 3, 40),
                        new Process(2, 5, 30),
                        new Process(2, 9, 32),
                        new Process(2, 4, 55)
                };
        final int[] availableBlockSizes = {25,15,24,17}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new WorstFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());


        // Process 3
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());


        // Process 4
        assertEquals(-1.0,processes[0].getTurnAroundTime());
        assertEquals(-1.0,processes[0].getWaitingTime());
        assertEquals(-1.0,processes[0].getResponseTime());

    }

    @Test
    public void FCFSWithFirstFitConvoyEffect()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(1, 27, 10),
                        new Process(9, 3, 15),
                        new Process(10, 2, 32),
                        new Process(12, 1, 25)
                };
        final int[] availableBlockSizes = {60,35,42,15}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new FirstFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(30.0,processes[0].getTurnAroundTime());
        assertEquals(3.0,processes[0].getWaitingTime());
        assertEquals(3.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(30.0,processes[1].getTurnAroundTime());
        assertEquals(27.0,processes[1].getWaitingTime());
        assertEquals(27.0,processes[1].getResponseTime());


        // Process 3
        assertEquals(33.0,processes[2].getTurnAroundTime());
        assertEquals(31.0,processes[2].getWaitingTime());
        assertEquals(31.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(34.0,processes[3].getTurnAroundTime());
        assertEquals(33.0,processes[3].getWaitingTime());
        assertEquals(33.0,processes[3].getResponseTime());
    }

    @Test
    public void FCFSWithNextFitConvoyEffect()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(1, 27, 10),
                        new Process(9, 3, 15),
                        new Process(10, 2, 32),
                        new Process(12, 1, 25)
                };
        final int[] availableBlockSizes = {60,35,42,15}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new NextFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(30.0,processes[0].getTurnAroundTime());
        assertEquals(3.0,processes[0].getWaitingTime());
        assertEquals(3.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(30.0,processes[1].getTurnAroundTime());
        assertEquals(27.0,processes[1].getWaitingTime());
        assertEquals(27.0,processes[1].getResponseTime());


        // Process 3
        assertEquals(33.0,processes[2].getTurnAroundTime());
        assertEquals(31.0,processes[2].getWaitingTime());
        assertEquals(31.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(34.0,processes[3].getTurnAroundTime());
        assertEquals(33.0,processes[3].getWaitingTime());
        assertEquals(33.0,processes[3].getResponseTime());
    }

    @Test
    public void FCFSWithBestFitConvoyEffect()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(1, 27, 10),
                        new Process(9, 3, 15),
                        new Process(10, 2, 32),
                        new Process(12, 1, 25)
                };
        final int[] availableBlockSizes = {60,35,42,15}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new BestFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(30.0,processes[0].getTurnAroundTime());
        assertEquals(3.0,processes[0].getWaitingTime());
        assertEquals(3.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(30.0,processes[1].getTurnAroundTime());
        assertEquals(27.0,processes[1].getWaitingTime());
        assertEquals(27.0,processes[1].getResponseTime());


        // Process 3
        assertEquals(33.0,processes[2].getTurnAroundTime());
        assertEquals(31.0,processes[2].getWaitingTime());
        assertEquals(31.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(34.0,processes[3].getTurnAroundTime());
        assertEquals(33.0,processes[3].getWaitingTime());
        assertEquals(33.0,processes[3].getResponseTime());
    }

    @Test
    public void FCFSWithWorstFitConvoyEffect()
    {
        final Process[] processes =
                {
                        // Process parameters are: arrivalTime, burstTime, memoryRequirements (kB)
                        new Process(1, 27, 10),
                        new Process(9, 3, 15),
                        new Process(10, 2, 32),
                        new Process(12, 1, 25)
                };
        final int[] availableBlockSizes = {60,35,42,15}; // sizes in kB
        MemoryAllocationAlgorithm algorithm = new WorstFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new FCFS();
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        // Process 1
        assertEquals(30.0,processes[0].getTurnAroundTime());
        assertEquals(3.0,processes[0].getWaitingTime());
        assertEquals(3.0,processes[0].getResponseTime());

        // Process 2
        assertEquals(30.0,processes[1].getTurnAroundTime());
        assertEquals(27.0,processes[1].getWaitingTime());
        assertEquals(27.0,processes[1].getResponseTime());


        // Process 3
        assertEquals(33.0,processes[2].getTurnAroundTime());
        assertEquals(31.0,processes[2].getWaitingTime());
        assertEquals(31.0,processes[2].getResponseTime());

        // Process 4
        assertEquals(34.0,processes[3].getTurnAroundTime());
        assertEquals(33.0,processes[3].getWaitingTime());
        assertEquals(33.0,processes[3].getResponseTime());
    }

}
