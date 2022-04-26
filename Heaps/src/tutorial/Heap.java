package tutorial;

import java.util.NoSuchElementException;

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

    // We take the index, so we don't have to search for the value in the heap. Therefore, we would have to perform a
    // linear search. Delete methods that don't take any parameters delete the root.
    public int delete(int index)
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index]; // Saving the deleted value to change after finding the position.

        heap[index] = heap[size - 1]; // The rightmost value in the heap replaces the deleted value's index.

        // If we are deleting the root, of if the replacement value is less than its parent.
        if (index == 0 || heap[index] < heap[parent])
        {
            fixHeapBelow(index, size - 1);
        }
        else
        {
            fixHeapAbove(index);
        }

        size--;

        return deletedValue;
    }

    // This name is due to the fact that we are going up the tree.
    private void fixHeapAbove(int index)
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

    // This second parameter will be used when we need to sort the heap.
    private void fixHeapBelow(int index, int lastHeapIndex)
    {
        int childToSwap;

        // We need to swap the value with the child with the greatest value. As we are fixing the heap below we don't
        // have to look the values greater than the index.
        while (index <= lastHeapIndex)
        {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            // Checking if the node has a left child. We don't have to check right child in this condition because a
            // node could have only a left child.
            if (leftChild <= lastHeapIndex)
            {
                // Checking if it doesn't have a right child. If it doesn't have a right child, it means that the only
                // value that we need to check for a possible swap is the left child.
                if (rightChild > lastHeapIndex)
                {
                    childToSwap = leftChild;
                }
                else // If it has a right child, we need to figure out which child is the greatest for a possible swap.
                {
                    // Assigning the child that has the greatest value.
                    childToSwap = (heap[leftChild] > heap[rightChild]) ? leftChild : rightChild;
                }

                // Only swap if the child is greater than the parent.
                if (heap[index] < heap[childToSwap])
                {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }
                else // If the child is not greater than the parent it means that we are done.
                {
                    break;
                }

                // If it didn't break, it means that a replacement occurred. So we need to check its new children.
                index = childToSwap;
            }
            else // If it doesn't have any children.
            {
                break;
            }
        }
    }

    public int peek()
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    public void printHeap()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public int getParent(int index)
    {
        // We don't have to use floor since we are doing division with integers. It rounds down automatically.
        return (index - 1) / 2;
    }

    public int getChild(int index, boolean left)
    {
        return 2 * index + (left ? 1 : 2);
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean isFull()
    {
        return size == heap.length;
    }

}
