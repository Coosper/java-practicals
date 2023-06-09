public class Library
{
    private Book [] bookList;
    private int total;
    
    //Constructor for Library
    public Library(int sizeIn)
    {
        bookList = new Book[sizeIn];
        total = 0;
    }
    
    //A getter method for the total field.
    public int getTotal()
    {
      return total;  
    }
    
    /*The getItem method takes in a book's unique ISBN number 
    and returns the Book object associated with the ISBN. */
    public Book getItem(String isbnIn)
    {
        int bookPosition = search(isbnIn);
        
        if(search(isbnIn) == -999)
        {
            return null;
        } else {
            return bookList[bookPosition];
        }
    }
    
    //IsFull Method to check if it is full.
    public boolean isFull()
    {
        if(total == bookList.length)
        {
            return true;
        } else {
            return false;
        }
    }
    
    //A method to check if it is empty.
    public boolean isEmpty() 
    {
        if(total == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    //A search method to check if the ISBN inputted in matches the tempNum.
    //If it does, it returns the position of the ISBN otherwise it returns -999.
    public int search(String isbnIn)
    {
        for(int i = 0; i < total; i++)
        {
            String tempNum;
            tempNum = bookList[i].getISBN();
            if(tempNum.equals(isbnIn) == true)
            {
                return i;
            }
        }
        
        return -999;
    }
    
    public boolean add(Book bookIn)
    {
       if (isFull() == false)
       {
           bookList[total] = bookIn; //Add in the new book.
           total++;                  //Increments the total.
           return true;              //Indicates the success!
       } else {
           return false;             //Indicates the failure...
       }
    }
    
    //A method to remove a book from the array.
    public boolean remove(String isbnIn)
    {
        int index = search(isbnIn);
        
        if (index == -999)
        {
            //No such book found.
            return false;
        } else {
            for(int i = index; i < total-1; i++)
            {
                bookList[i] = bookList[i+1];
            }
            
            total--;
            return true;
        }
    }
}
