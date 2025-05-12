class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
         int n = triangle.size();

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int down = triangle.get(i + 1).get(j);
                int diagonal = triangle.get(i + 1).get(j + 1);
                
                int updatedValue = triangle.get(i).get(j) + Math.min(down, diagonal);
                triangle.get(i).set(j, updatedValue);
            }
        }
        
        return triangle.get(0).get(0);
    }
}