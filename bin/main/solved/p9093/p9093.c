#include <stdio.h>
#include <string.h>
int main(){
    char str[1000];
    char prt[1000];
    int word_start=0,word_end=0,prt_index=0;
    int T,i,j,k;

    printf("input T :");
    scanf("%d",&T);
    getchar();
    printf("start input\n");
    for(i=0;i<T;i++){
        word_start=0;
        word_end=0;
        prt_index=0;
        memset(str,'\0',sizeof(char)*1000);
        memset(prt,'\0',sizeof(char)*1000);
     

        printf("input text : ");
        gets(str);

        for(j=0;str[j] != '\0';j++){//한 문장 끝까지
            if(str[j] == ' '){
                word_end = j-1;
                prt_index = word_start;
                for(k=word_end;k>=word_start;k--){

                    prt[prt_index++] = str[k];

                }
                prt[j] = ' ';
                word_start = j+1;
            }

        }

        word_end = j-1;
        prt_index = word_start;
        for(k=word_end;k>=word_start;k--){

            prt[prt_index++] = str[k];

        }
        prt[j] = ' ';
        word_start = j+1;

        printf("print text : ");
        printf("%s\n",prt);
        
    }

    return 0;
}