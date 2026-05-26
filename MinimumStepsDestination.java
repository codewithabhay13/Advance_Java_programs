// package Abstract;

public class MinimumStepsDestination {
	   static int minSteps(int source, int step, int destination) {
	        if (source == destination)
	            return step;
	        if (step > destination + 1)
	            return Integer.MAX_VALUE;
	        int forward = minSteps(source + step + 1, step + 1, destination);             
	        int backward = minSteps(source - step - 1, step + 1, destination);	               
	        return Math.min(forward, backward);
	    }
	    public static void main(String[] args) {
	        int target1 = 2;
	        System.out.println("Minimum steps = " + minSteps(0, 0, target1));
	        int target2 = 3;
	        System.out.println("Minimum steps = " + minSteps(0, 0, target2));
	        

	    }
}