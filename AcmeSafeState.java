// Design and implement a new class AcmeSafeState of that is safe without using the synchronized keyword. 
// Your imlementation should use java.util.concurrent.atomic.AtomicLongArray. The goal is to achieve better performance than SynchronizedState while 
// retaining safety. Put the implementation into a new file AcmeSafeState.java.

// AtomicLong ,and AtomicReference each provide access and updates to a single variable of the corresponding type
import  java.util.concurrent.atomic.AtomicLongArray; 
//implementaion of AcmeSafeState
//it's faster as it doen't use Synchronization but it's safe as AtomicLongArray provides safety
class AcmeSafeState implements State {
    // private final ReentrantLock lock = new ReentrantLock();
    //create an AtomicLongArray value
    private AtomicLongArray value;
    AcmeSafeState(int length) { 
        // Creates a new AtomicLongArray of the given length, with all elements initially zero.
        value = new AtomicLongArray(length);
    }
    // Returns the length of the array.
    public int size() { return value.length();}
    //return the current array
    public long[] current() {
        // create a new temp long array, store the values in value in temp and return that as the current 
        long[] temp = new long[size()];
        // loop through the array
        for (int i=0 ; i< size(); i++){
            temp[i]= (long) value.get(i);
        }
        // return temp
        return temp;
    }
    // A state transition, called a swap, consists of subtracting 1 from one of the entries, and adding 1 to an entry – 
    // typically a different entry although the two entries can be the same in which case a swap does nothing.
    public void swap(int i, int j) {
        //set the new value for the desired indexs, by using .set(i,new_value)
        //new_val = current val + or - 1 depending on i,j
        //as follows
        value.decrementAndGet(i);     /*value[i]--;*/
        value.incrementAndGet(j);     /*value[j]++;*/
    }
}