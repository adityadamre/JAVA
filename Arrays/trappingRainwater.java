package Arrays;

public class TrappingRainwater {
    public static int rainwater(int arr[]) {
        int water = 0, waterLevel;
        if(arr.length <= 2) {
            return water;
        }

        int rightBoundary[] = new int[arr.length];
        rightBoundary[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2; i >= 0; i--) {
            rightBoundary[i] = Math.max(rightBoundary[i+1], arr[i]);
        }

        int leftBoundary[] = new int[arr.length];
        leftBoundary[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            leftBoundary[i] = Math.max(leftBoundary[i-1], arr[i]);
        }

        for(int i = 0; i < arr.length; i++) {
            waterLevel = Math.min(leftBoundary[i], rightBoundary[i]);
            water += waterLevel - arr[i];
        }
        return water;
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 0, 6, 3, 2, 5};
        System.out.println("Trapped Rainwater = " + rainwater(arr));
    }
}
