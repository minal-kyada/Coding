package WinterBreak.Day4;

//https://leetcode.com/problems/car-fleet/description/ 

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[] time = new float[target];

        for (int i = 0; i < position.length; i++) {
            time[position[i]] = (float) (target - position[i]) / speed[i];
        }
        int fleet = 0;
        float maxTime = 0;
        for (int i = target - 1; i >= 0; i--) {
            if (time[i] > maxTime) {
                maxTime = time[i];
                fleet++;
            }
        }
        return fleet;
    }
}
