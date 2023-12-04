import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.*;

public class Main {

    public static Integer getSubarraySum(List<Integer> arr, int index, int size) {
        Integer sum = 0;
        for(int i=0; i<size; i++){
            sum += arr.get(index+i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); 
        int n = Integer.parseInt(reader.nextLine());
        
        List<Integer> arr = new ArrayList<>();
        
        arr = Arrays.asList(reader.nextLine().split(" "))
            .stream()
            .map(Integer::parseInt)
            .collect(toCollection(ArrayList::new));
        reader.close();
        
        Integer negativeSums = 0;
        
        for(int size = 1; size<=n; size++) {
            for(int ind = 0; ind+size<=n; ind++){
                if(getSubarraySum(arr, ind, size) < 0) negativeSums++;
            }    
        }
        
        System.out.println(negativeSums);
    }
}
