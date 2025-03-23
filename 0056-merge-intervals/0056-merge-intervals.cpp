class Solution {
private:    
    void sortIntervals(vector<vector<int>>& intervals){
        int n = intervals.size();
        for(int i = 0; i<n; i++){
            int j = i+1;
            int mini = i;
            while(j<n){
                if(intervals[j][0]<intervals[mini][0]){mini = j;}
                j++;
            }
            swap(intervals[i], intervals[mini]);
        }

        for(int i  =0; i<intervals.size(); i++){
            cout << intervals[i][0] << " " << intervals[i][1] << endl;
        }
    }
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sortIntervals(intervals);
        vector<vector<int>> ans;
        vector<int> temp;
        temp.push_back(intervals[0][0]);
        temp.push_back(intervals[0][1]);
        ans.push_back(temp);
        int j = 0;
        for(int i = 1; i<intervals.size(); i++){
            if(ans[j][1] >= intervals[i][0]){
                vector<int> temp;
                temp.push_back(ans[j][0]);
                temp.push_back(max(ans[j][1], intervals[i][1]));
                ans.pop_back();
                ans.push_back(temp);
            }else{
                vector<int> temp;
                temp.push_back(intervals[i][0]);
                temp.push_back(intervals[i][1]);
                ans.push_back(temp);
                j++;
            }
        }
        return ans;
    }
};