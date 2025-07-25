package Greedy;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {  // Given that, solution if exist is unique!
        int totalGas = 0, totalCost = 0;
        int currentTank = 0, startIdx = 0;

        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];

            if(currentTank < 0) {
                startIdx = i+1;
                currentTank = 0;
            }
        }

        return totalGas >= totalCost ? startIdx : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
}