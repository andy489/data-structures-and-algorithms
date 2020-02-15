

          Node* removeDuplicates(Node *head)
          {
            //Write your code here
            Node* traverse=head;
            while(traverse&&traverse->next){
                if(traverse->data==traverse->next->data){
                    Node* duplicate=traverse->next;
                    traverse->next=duplicate->next;
                    delete duplicate;
                }
                else{
                    traverse=traverse->next;
                }
            }
            return head;
          }

