#include <iostream>
#include <vector>
#include <string>
using namespace std;

 void init(vector<vector<int>>& arr, const string& str){
        int n=str.length();
        arr[str[0]-'a'][0]++;
        for(int i=1;i<n;i++){

            for(int k=0;k<26;k++){
                arr[k][i]=arr[k][i-1];
            }

            arr[str[i]-'a'][i]++;
        }
    }

int main() {
   
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string str;
    cin>>str;

    int N;
    cin>>N;

    vector<vector<int>> arr(26,vector<int>(str.length(),0));
    init(arr,str);
    string ans;
    for(int i=0;i<N;i++){
        char a;
        int l, r;
        cin >> a >> l >> r;

        if(l>0){
           ans+=to_string(arr[a - 'a'][r] - arr[a - 'a'][l - 1]) + '\n';
        }else{
             ans+=to_string(arr[a - 'a'][r]) + '\n';
        }
    }
    
    cout<<ans;

    return 0;
}
