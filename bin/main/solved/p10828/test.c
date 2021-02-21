#include <stdio.h>
#include <string.h>

void main(){
    int i=0;

    char order[10];
    while(1){
        scanf("%s",order);

        if(!strcmp(order,"push"))
            printf("push\n");
        
        else if(!strcmp(order,"pop"))
            printf("pop\n");

        else
            printf("nop\n");
        
        
        
        //printf("[%s]\n",order);
    }
}