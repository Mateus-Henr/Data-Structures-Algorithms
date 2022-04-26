package tutorial;

// We will be implementing a max heap.
public class Heap
{
    private int[] heap;
    private int size;

    public Heap(int capacity)
    {
        this.heap = new int[capacity];
    }

    public void insert(int value)
    {
        if (isFull())
        {
            // We can either resize the array or throw an exception.
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;

        // After inserting the value we have to heapify.
        fixHeapAbove(size);

        size++;
    }

    // This name is due to the fact that we are going up the tree.
    public void fixHeapAbove(int index)
    {
        int newValue = heap[index];

        // Loop until it finds a parent smaller than the value.
        while (index > 0 && newValue > heap[getParent(index)])
        {
            // Assigning the parent to where the new value is at.
            heap[index] = heap[getParent(index)];

            index = getParent(index);
        }

        // WE ONLY ASSIGN THE NEW VALUE WHEN WE FIND ITS CORRECT POSITION. Otherwise, we wouldn't be unnecessary
        // swapping. It's similar to insertion sort.
        heap[index] = newValue;
    }

    public int getParent(int index)
    {
        // We don't have to use floor since we are doing division with integers. It rounds down automatically.
        return (index - 1) / 2;
    }

    public boolean isFull()
    {
        return size == heap.length;
    }

}
