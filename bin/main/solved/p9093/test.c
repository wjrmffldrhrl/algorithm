#include <stdio.h>

int main(){
    char c;

    while(1){
        scanf("%c",&c);

        if(c == '\n')
            printf("pop!\n");
        else if(c == ' ')
            printf("hello\n");
    }
}