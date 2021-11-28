class Solution {
public:
    bool checkValidString(string s) {
        //use stack to store chars in s
        //cancel last '(' if ')' is met, otherwise cancel '*'
        //scan stack to check if '(' can be all canceled by '*'
        stack<int> s_left, s_star;
        for(int k=0; k<s.size(); k++){
            char c = s[k];
            if(c=='(') s_left.push(k); 
            else if(c==')'){
                if(s_left.size()>0) s_left.pop();
                else if(s_star.size()>0) s_star.pop();
                else return false;
            }
            else s_star.push(k);
        }
        while(s_left.size()){
            if(s_star.size()==0) return false;
            if(s_left.top()>s_star.top()) return false;
            s_left.pop();
            s_star.pop();
        }
        return true;
    }
};
