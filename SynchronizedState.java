// SynchronizedState
// An implementation of State that uses the Synchronized class so that it is safe but slow.
class SynchronizedState implements State {
    //array of longs
    //Each array entry starts at zero
    private long[] value;

    SynchronizedState(int length) { value = new long[length]; }

    public int size() { return value.length; }

    public long[] current() { return value; }
    // A state transition, called a swap, consists of subtracting 1 from one of the entries, and adding 1 to an entry – 
    // typically a different entry although the two entries can be the same in which case a swap does nothing.
    public synchronized void swap(int i, int j) {
        //i and j could be same
        value[i]--;
        value[j]++;
    }
    // --------------   END RESULT---------:
    // The sum of all the array entries should therefore remain zero; if it becomes nonzero, that indicates that one or more transitions weren't done correctly.
}
