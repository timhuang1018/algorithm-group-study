class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        //compare each query with pattern
        //queries len: n, average query len: m
        //time O(mn), space O(1)
        vector<bool> vret;
        for(auto &query: queries)
            vret.push_back(is_match(query, pattern));
        return vret;
    }
private:
    bool is_match(string &query, string &pattern){
        if(query.size()<pattern.size()) return false;
        
        int pos_p = 0;
        for(auto c: query){
            if(pos_p<pattern.size() && c==pattern[pos_p]) pos_p++;
            else if(c>='A' && c<='Z')
                return false;
        }
        if(pos_p!=pattern.size()) return false;
        return true;
    }
};
