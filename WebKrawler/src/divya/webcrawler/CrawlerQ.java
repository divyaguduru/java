package divya.webcrawler;

public class CrawlerQ extends Queue{
     
	int rear,front,maxsize,nitems;
	
	String[] arr;
	
	CrawlerQ(){
		
		maxsize=1000000;
		front=0;
		rear=-1;
		nitems=0;
		arr =new String[maxsize];
	}
	
	@Override
	public boolean isEmpty(){
		return(nitems==0);
	}


	@Override
	public void insert(String link) {
		if(rear == maxsize-1) 
			rear = -1;
			arr[++rear] = link; 
			nitems++; 
			//System.out.print(nitems);
			
	}


	@Override
	public String remove() {
		
		String link=arr[front++];
		
		if(front == maxsize) 
			front = 0;
		nitems--;
		return link;
			
	}



	
}
