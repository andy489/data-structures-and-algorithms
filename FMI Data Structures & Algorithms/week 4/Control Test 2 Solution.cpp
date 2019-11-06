void removeComplex(int devidedBy) 
{	//  TODO: write your code here   
	Node* temp = head, * prev;
	while (temp != nullptr && temp->data % devidedBy == 0)
	{
		head = temp->next;
		delete temp;
		temp = head;
	}
	while (temp != nullptr)
	{
		while (temp != nullptr && temp->data % devidedBy != 0)
		{
			prev = temp;
			temp = temp->next;
		}

		if (temp == nullptr) return;

		prev->next = temp->next;
		delete temp;
		temp = prev->next;
	}
} 
