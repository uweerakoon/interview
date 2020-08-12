package Wayfair;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

  //  Time complexity : O(n+m)
  // Because each recursive call increments the pointer to 11 or l2 by one (approaching the dangling null at the end of each list), there will be exactly one call to mergeTwoLists per element in each list. Therefore, the time complexity is linear in the combined size of the lists.
  //  Space complexity : O(n+m)
  //  The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached, so n + mn+m stack frames consume O(n + m)O(n+m) space.
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    else if (l2 == null) {
      return l1;
    }
    else if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    }
    else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  // Iterative approach
  // Time complexity : O(n+m)
  // Because exactly one of l1 and l2 is incremented on each loop iteration, the while loop runs for a number of iterations equal to the sum of the lengths of the two lists. All other work is constant, so the overall complexity is linear.
  // Space complexity : O(1)
  // The iterative approach only allocates a few pointers, so it has a constant overall memory footprint.
  public ListNode mergeTwoListsIteration(ListNode l1, ListNode l2) {
    // maintain an unchanging reference to node ahead of the return node.
    ListNode prehead = new ListNode(-1);

    ListNode prev = prehead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }

    // exactly one of l1 and l2 can be non-null at this point, so connect
    // the non-null list to the end of the merged list.
    prev.next = l1 == null ? l2 : l1;

    return prehead.next;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
