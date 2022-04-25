package tutorial.second;

/*  Trees — Challenge 2

    • This challenge will focus on showing how delete and insert operations work in a tree.


    Initial tree for operations
                                [25]
                  [20]                        [27]
            [15]        [22]            [26]         [30]
                [17]                             [29]    [32]


    Insert "28"
                                [25]
                  [20]                        [27]
            [15]        [22]            [26]         [30]
                [17]                             [29]    [32]
                                              [28]
    OBS: When dealing with a binary search tree we go to the left if the value is smaller than the value that we are
         comparing, otherwise we go to the right.


    Insert "16"
                                [25]
                  [20]                        [27]
            [15]        [22]            [26]         [30]
                [17]                             [29]    [32]
           [16]                               [28]


    Insert "23"
                                [25]
                  [20]                        [27]
            [15]        [22]            [26]         [30]
              [17]         [23]                  [29]    [32]
           [16]                               [28]


    Insert "14"
                                [25]
                    [20]                        [27]
              [15]        [22]            [26]         [30]
        [14]      [17]       [23]                  [29]    [32]
               [16]                             [28]


    Delete "28"
                                [25]
                    [20]                        [27]
              [15]        [22]            [26]         [30]
        [14]        [17]      [23]                 [29]    [32]
                [16]


    Delete "22"
                                [25]
                    [20]                        [27]
              [15]        [23]            [26]         [30]
        [14]    [17]                             [29]    [32]
                [16]
    OBS: When deleting a node with one child, the child takes the node's place.


    Delete "15" (looking for replacement in right subtree)
                                [25]
                    [20]                        [27]
              [16]        [23]            [26]         [30]
        [14]        [17]                           [29]    [32]
    OBS: As the replacement is in the right subtree we have to look for the smallest value.


    Delete "27" (looking for replacement in right subtree)
                                [25]
                    [20]                        [29]
              [16]        [23]            [26]         [30]
        [14]        [17]                                   [32]


    Delete "40" (looking for replacement in right subtree)
                                [30]
                    [20]                        [46]
              [16]        [23]            [34]         [66]
        [14]        [17]                           [60]
                                                        [62]
 */

public class Main
{
    public static void main(String[] args)
    {

    }

}
