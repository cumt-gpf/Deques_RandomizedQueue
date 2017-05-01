Week 2 Stacks and Queues, Elementary Sorts
------
- Stacks and Queues
    - Stacks
        - linked-list implementation
            - every operation takes *constant* time in the worst case
            - per stack node:16 bytes for object, 8 bytes for inner class, 8 for item, 8 for Node
        - resizint-array implementation
            - create a new array of twice the size and copy items
            - amorized cost of adding to a stack: 3N
            
链表实现的栈占用内存多，但是操作起来是常数级的。数组实现的栈插入操作摊还分析下来也是常数级，并且占用内存少。一定要搞清楚摊还分析！
查了一下Java标准库中的Stack实现，Stack类继承自Vector类，Vector含有成员变量Object[]，默认两倍增长，并且可以设置数组增长幅度。

- Elementary Sorts
    - selection sort
        - 何为选择？选择右边所有之中最小的换过来
        - 最好和最坏情况都是O(n^2)
    - insertion sort
        - 插入排序，只和旁边的比较，
        - 最好（排好序）只需N-1次比较，最坏O(n^2)
    - shell sot
        - insertion sort with stride length h
        - 受增长序列的影响，3x+1为O(N^3/2)
        - 有很多现实应用
    - shuffling
        - Knuth shuffling:迭代到i时，从0-i中选一个交换
        - 为什么从0-i中选择就是uniform的，而从全部中选就不是uniform?
    -Convex hull
    
- Assignment
        



            