public interface BagInterface<Food> {
    
    
    public int getCurrentSize();
    
    
    public boolean isEmpty();
    
    
    public boolean add(Food newEntry);
    
    
    public Food remove();
    
    
    public boolean remove(Food anEntry);
    
    
    public void clear();
    
    
    public int getFrequencyOf(Food anEntry);
    
    
    public boolean contains(Food anEntry);
    
    
    public Food[] toArray();
}
