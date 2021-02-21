#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Node{
    int data; // 데이터가 들어갈 자리
    struct Node* prev; // 이전 노드를 가리키는 포인터

}Node;


typedef struct Stack{
    Node* top; // 스택의 상단을 가리키는 포인터
    int count; // 노드의 개수 파악
}Stack;


void InitStack(Stack** s){ // 스택 생성 함수
    (*s) = (Stack*)malloc(sizeof(Stack)); // 메모리 할당
    (*s)->top = NULL; // top값 초기화
    (*s)->count = 0;
}

Node* CreateNode(int data){ // 새로운 노드 생성
    Node* n = (Node*)malloc(sizeof(Node));
    n -> data = data;
    n -> prev = NULL;
    return n;
}

void PushNode(Stack** stack, Node * node){ //새로 생성된 노드를 가리키게
    if((!stack)) return;

    node -> prev = (*stack) -> top;
    (*stack) -> top = node;
} // 호출은 PushNode(&myStack, CreateNode(5));

Node* PopNode(Stack** stack){
    if (!(*stack) || !((*stack)->top)) return NULL; // 데이터가 없을 경우 NULL을 리턴해준다 

    Node* n = (*stack) -> top;
    (*stack)->top = n -> prev;
    return n;
}

Node* PeekNode(Stack** stack){
    if(!(*stack) || !((*stack)->top))
        return NULL;
    
    Node* n = ((*stack)->top);
    return n;
}

int main()
{
    int order_num=0,data=0;
    char order[7];
    int i;
    Stack* stack = NULL;
    InitStack(&stack);
 
    scanf("%d",&order_num);

    for(i=0;i<order_num;i++){
        scanf("%s",order);

        if(!strcmp(order,"push")){
            scanf("%d",&data);
            PushNode(&stack,CreateNode(data));
            stack -> count++;
        }
        else if(!strcmp(order,"pop")){
            Node* n = PopNode(&stack);
            if(n == NULL)
                printf("-1\n");
            else{
                printf("%d\n",n -> data);
                stack -> count--;
            }
            //free(n);
        }
        else if(!strcmp(order,"size")){
            printf("%d\n",stack -> count);
        }
        else if(!strcmp(order,"empty")){
            if(stack -> count == 0)
                printf("1\n");
            else
                printf("0\n");
            
            
        }
        else if(!strcmp(order,"top")){
            Node* n = PeekNode(&stack);

            if(n==NULL)
                printf("-1\n");
            else
                printf("%d\n",n -> data);
            
            //free(n);
            
        }
    }

    return 0;
}

