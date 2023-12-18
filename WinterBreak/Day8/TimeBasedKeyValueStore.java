// https://leetcode.com/problems/time-based-key-value-store/description/
//Approach1: Using List (May be better solution than Approach2)
//Approach2: Using TreeMap
class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        TreeMap<Integer, String> timeValueMap = map.get(key);
        //floorKey return the greatest key <= given key
        //ceilingKey return the smallest key >= given key
        Integer floorTS = timeValueMap.floorKey(timestamp);
        return (floorTS == null) ? "" : timeValueMap.get(floorTS);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */