class NumberContainers {
    Map<Integer,Integer> indexToNumber;
    Map<Integer,TreeSet<Integer>> numberToIndex;
    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndex = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indexToNumber.containsKey(index)){
            int oldNumber = indexToNumber.get(index);
            if(oldNumber != number){
                numberToIndex.get(oldNumber).remove(index);
                if(numberToIndex.get(oldNumber).isEmpty()){
                    numberToIndex.remove(oldNumber);
                }
            }
        }

        indexToNumber.put(index,number);
        numberToIndex.putIfAbsent(number, new TreeSet<>());
        numberToIndex.get(number).add(index);
    }
    
    public int find(int number) {
        if(numberToIndex.containsKey(number) && !numberToIndex.get(number).isEmpty()){
            return numberToIndex.get(number).first();
        }

        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

