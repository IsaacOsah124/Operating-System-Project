# Operating-System-Project
# Bankers algorithm
## The banker’s algorithm is a resource allocation and deadlock avoidance algorithm that tests for safety by simulating the allocation for predetermined maximum possible amounts of all resources, then makes an “s-state” check to test for possible activities, before deciding whether allocation should be allowed to continue.
## Bankers algorithm make use of the following variables
- Available : indicating the number of available resources of each type.
- Max : defines the maximum demand of each process in a system.
- Allocation : defines the number of resources of each type currently allocated to each process.
- Need : indicates the remaining resource need of each process.

## Characteristics of Banker's Algorithm
- Keep many resources that satisfy the requirement of at least one client
- Whenever a process gets all its resources, it needs to return them in a restricted period.
- When a process requests a resource, it needs to wait
- The system has a limited number of resources
- Advance feature for max resource allocation

## Drawbacks of Bankers Algorthim
- Does not allow the process to change its Maximum need while processing
- It allows all requests to be granted in restricted time, but one year is a fixed period for that.
- All processes must know and state their maximum resource needs in advance.


# Best Fit
The best fit deals with allocating the smallest free partition which meets the requirement of the requesting process. This algorithm first searches the entire list of free partitions and considers the smallest hole that is adequate. It then tries to find a hole which is close to actual process size needed.

## Advantage
Memory utilization is much better than first fit as it searches the smallest free partition first available.

##Disadvantage
It is slower and may even tend to fill up memory with tiny useless holes.

# Circular SCAN (C-SCAN) scheduling algorithm 
Circular SCAN (C-SCAN) scheduling algorithm is a modified version of SCAN disk scheduling algorithm that deals with the inefficiency of SCAN algorithm by servicing the requests more uniformly. Like SCAN (Elevator Algorithm) C-SCAN moves the head from one end servicing all the requests to the other end. However, as soon as the head reaches the other end, it immediately returns to the beginning of the disk without servicing any requests on the return trip and starts servicing again once reaches the beginning. This is also known as the “Circular Elevator Algorithm” as it essentially treats the cylinders as a circular list that wraps around from the final cylinder to the first one.




# FCFS Scheduling
First come first serve (FCFS) scheduling algorithm simply schedules the jobs according to their arrival time. The job which comes first in the ready queue will get the CPU first. The lesser the arrival time of the job, the sooner will the job get the CPU. FCFS scheduling may cause the problem of starvation if the burst time of the first process is the longest among all the jobs.

## Advantages of FCFS
Simple
Easy

## Disadvantages of FCFS

The scheduling method is non preemptive, the process will run to the completion.
Due to the non-preemptive nature of the algorithm, the problem of starvation may occur.
Although it is easy to implement, but it is poor in performance since the average waiting time is higher as compare to other scheduling algorithms.


# FCFS Disk Scheduling Algorithm

FCFS (First-Come-First-Serve) is the easiest disk scheduling algorithm among all the scheduling algorithms. In the FCFS disk scheduling algorithm, each input/output request is served in the order in which the requests arrive. In this algorithm, starvation does not occur because FCFS address each request.

## Advantages of FCFS Disk scheduling Algorithm
The advantages of FCFS disk scheduling algorithm are:

- In FCFS disk scheduling, there is no indefinite delay.
- There is no starvation in FCFS disk scheduling because each request gets a fair chance.

## Disadvantages of FCFS Disk Scheduling Algorithm
The disadvantages of FCFS disk scheduling algorithm are:

- FCFS scheduling is not offered as the best service.
- In FCFS, scheduling disk time is not optimized.

# First Fit
In the first fit approach is to allocate the first free partition or hole large enough which can accommodate the process. It finishes after finding the first suitable free partition.

## Advantage
Fastest algorithm because it searches as little as possible.

## Disadvantage
The remaining unused memory areas left after allocation become waste if it is too smaller. Thus request for larger memory requirement cannot be accomplished.


# Multileve Queue Scheduling Algorithm
## A multi-level queue scheduling algorithm partitions the ready queue into several separate queues. The processes are permanently assigned to one queue, generally based on some property of the process, such as memory size, process priority, or process type. Each queue has its own scheduling algorithm.

## Advantages of Multilevel Queue Scheduling
- With the help of this scheduling we can apply various kind of scheduling for different kind of processes

## Disadvantages of Multilevel Queue Scheduling
- The main disadvantage of Multilevel Queue Scheduling is the problem of starvation for lower-level processes. Due to starvation lower-level processes either never execute or have to wait for a long amount of time because of lower priority or higher priority process taking a large amount of time.

# Multiprogramming with Fixed Number of Task
## MFT is one of the old memory management techniques in which the memory is partitioned into fixed size partitions and each job is assigned to a partition. The memory assigned to a partition does not change. Memory allocation is in contiguous form.
## MFT suffers with the problem of internal fragmentation
## Merit of MFT
-The algorithm to implement mft is easy
- Processing of Fixed Partitioning require lesser excess and indirect computational power. 
## The Drawbacks of MFT are :
- Degree of multiprogramming is not flexible. This is because the number of blocks is fixed resulting in memory wastage due to fragmentation.

# Multiprogramming with variable number of task
## MVT support for contiguous memory allocation technique.
## MVT is the memory management technique in which each job gets just the amount of memory it needs. That is, the partitioning of memory is dynamic and changes as jobs enter and leave the system.

## Advantages of Variable Partitioning 
- No Internal Fragmentation: In variable Partitioning, space in main memory is allocated strictly according to the need of process, hence there is no case of internal fragmentation. There will be no unused space left in the partition.
- No restriction on Degree of Multiprogramming: More number of processes can be accommodated due to absence of internal fragmentation. A process can be loaded until the memory is empty.
- No Limitation on the size of the process: In Fixed partitioning, the process with the size greater than the size of the largest partition could not be loaded and process can not be divided as it is invalid in contiguous allocation technique. Here, In variable partitioning, the process size can’t be restricted since the partition size is decided according to the process size.

## Disadvantages of Variable Partitioning
- Difficult Implementation:Implementing variable Partitioning is difficult as compared to Fixed Partitioning as it involves allocation of memory during run-time rather than during system configure.
- External Fragmentation:There will be external fragmentation inspite of absence of internal fragmentation.
For example, suppose in above example- process P1(2MB) and process P3(1MB) completed their execution. Hence two spaces are left i.e. 2MB and 1MB. Let’s suppose process P5 of size 3MB comes. The empty space in memory cannot be allocated as no spanning is allowed in contiguous allocation. The rule says that process must be contiguously present in main memory to get executed. Hence it results in External Fragmentation. 


# Paging
Paging is a memory management technique in which process address space is broken into blocks of the same size called pages (size is power of 2, between 512 bytes and 8192 bytes). The size of the process is measured in the number of pages.

Similarly, main memory is divided into small fixed-sized blocks of (physical) memory called frames and the size of a frame is kept the same as that of a page to have optimum utilization of the main memory and to avoid external fragmentation.

Page address is called logical address and represented by page number and the offset.

Frame address is called physical address and represented by a frame number and the offset.

A data structure called page map table is used to keep track of the relation between a page of a process to a frame in physical memory.

When the system allocates a frame to any page, it translates this logical address into a physical address and create entry into the page table to be used throughout execution of the program.

When a process is to be executed, its corresponding pages are loaded into any available memory frames.
This process continues during the whole execution of the program where the OS keeps removing idle pages from the main memory and write them onto the secondary memory and bring them back when required by the program.

##Advantages of Paging
Given below are some advantages of the Paging technique in the operating system:

- Paging mainly allows to storage of parts of a single process in a non-contiguous fashion.
- With the help of Paging, the problem of external fragmentation is solved.
- Paging is one of the simplest algorithms for memory management.

## Disadvantages of Paging
Disadvantages of the Paging technique are as follows:
- In Paging, sometimes the page table consumes more memory.

- Internal fragmentation is caused by this technique.

- There is an increase in time taken to fetch the instruction since now two memory accesses are required.


