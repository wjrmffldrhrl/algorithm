#include <stdio.h>
#include <string.h>

int main(){

    int T,count=0;
    char ps[51];
    
    int vps;

    int i,j;
    scanf("%d",&T);
    getchar();

    for(i=0;i<T;i++){
        memset(ps,'\0',sizeof(char)*51);
        gets(ps);

        for(j=0;ps[j]!='\0';j++){
            if(ps[j]=='(')
                count++;
            else
                count--;

            if(count<0){
                vps = -1;
                break;
            }

        }

        if(vps == -1){
            printf("NO\n");
        }
        else if(count != 0){
            printf("NO\n");
        }
        else
            printf("YES\n");

        vps = 0;
        count = 0;
    }


    return 0;
}