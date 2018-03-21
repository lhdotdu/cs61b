public class disc02_4 {
	/** Squaring a List
		For disc02 question 4: */
	public static void main(String[] args) {
		IntList L = new IntList(1, null);
		L = new IntList(2, L);
		L = new IntList(3, L);
		L = new IntList(2, L);
		L = new IntList(3, L);
		L = new IntList(2, L);
		printIntList("Lo",L);

		IntList L2 = square(L);
		printIntList("L2",L2);

		IntList L3 = square2(L);
		printIntList("L3",L3);

		squareMutative2(L);
		printIntList("Lc",L);

		System.out.println();
	}

	/** Square to a new IntList recursively. */
	public static IntList square(IntList L) {
		if (L == null) {
			return L;
		}
		IntList rest = square(L.rest);
		IntList M = new IntList(L.first * L.first, rest);
		return M;
	}

	/** Square to a new IntList iteratively. */
	public static IntList square2(IntList L) {
		if (L == null) {
			return L;
		}
		IntList B = L.rest;
		IntList R = new IntList(L.first*L.first, null);
		IntList C = R;
		while (B != null) {
			C.rest = new IntList(B.first*B.first, null);
			B = B.rest;
			C = C.rest;
		}
		return R;
	}

	/** Square to the same IntList iteratively. */
	public static IntList squareMutative(IntList L) {
		IntList B = L;
		while (B != null) {
			B.first *= B.first;
			B = B.rest;
		}
		return L;
	}

	/** Square to the same IntList recursively. */
	public static IntList squareMutative2(IntList L) {
		if (L == null) {
			return L;
		}
		squareMutative2(L.rest);
		L.first *= L.first;
		return L;
	}

	/** Prints out a IntList */
	public static void printIntList(String name, IntList L) {
		System.out.print("\n"+name+": ");
		IntList B = L;
		while (B != null) {
			System.out.print(B.first);
			B = B.rest;
		}
	}
}