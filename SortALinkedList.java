/*
Solution:
1.Bubble Sort
2.Merge Sort
 */
public class SortALinkedList {
	// bubble sort
	public ListNode sort1(ListNode head) {
		if (head == null) {
			return null;
		}
		int count = getLen(head);
		System.out.println(count);
		ListNode run = null;// use ListNode to store the ListNodes
		ListNode prev = null;
		ListNode second = null;
		ListNode third = null;
		while (count > 1) {
			run = head;
			while (run.next != null) {
				second = run.next;
				third = second.next;
				if (run.val > second.val) {
					second.next = run;
					run.next = third;
					if (prev != null) {// middle node
						prev.next = second;
					} else {// first node
						head = second;
					}

				}
				prev = run;
				run = second;

			}
			count--;

		}
		return head;

	}

	public int getLen(ListNode head) {
		ListNode curr = head;
		int l = 0;
		while (curr != null) {
			curr = curr.next;
			l++;
		}
		return l;
	}

	// merge sort
	public ListNode sort2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode first = null;
		ListNode second = null;
		Pair res = splitIntoTwo(head);// divide
		first = res.a;
		second = res.b;
		ListNode a =sort2(first);// conquer
		ListNode b = sort2(second);
		return mergeTwoLists(a, b);

	}
	class Pair{
		ListNode a=null;
		ListNode b=null;
		Pair(ListNode m, ListNode n){
			a=m;
			b=n;
		}
	}
	
	public Pair splitIntoTwo(ListNode head) {
		if (head == null||head.next==null) {
			return new Pair(head,null);
		}
		if(head.next.next==null){//note: consider case: length == 2
			ListNode back = head.next;
			head.next=null;
			return new Pair(head,back);
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {// shorter than two case
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;

		}
		ListNode first = head;
		ListNode second = slow.next;
		slow.next = null;
		return new Pair(first,second);

	}

	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		ListNode head = null;
		ListNode tail = null;
		while (a != null && b != null) {
			if (a.val < b.val) {
				if (head == null) {
					head = a;
					tail = head;
					a = a.next;
				} else {
					tail.next = a;
					tail = tail.next;
					a = a.next;
				}
			} else {
				if (head == null) {
					head = b;
					tail = head;
					b = b.next;
				} else {
					tail.next = b;
					tail = tail.next;
					b = b.next;
				}
			}

		}
		if(a!=null){
			tail.next = a;
		}
		if(b!=null){
			tail.next=b;
		}
		return head;
	}

	public static void main(String[] args) {
		SortALinkedList o = new SortALinkedList();
		ListNode a = new ListNode(26);
		a.next = new ListNode(24);
		a.next.next = new ListNode(1);
		ListNode res = o.sort2(a);
		while (res != null) {
			System.out.println("res " +res.val);
			res = res.next;
		}
	}

}
