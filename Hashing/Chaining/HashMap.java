package Hashing.Chaining;

import java.util.ArrayList;
import java.util.LinkedList;


public class HashMap<K,V> {
    private ArrayList<LinkedList<Entity<K,V>>> Bucket = new ArrayList<>();
    private int initialSize = 10;
    private float loadFactor = 0.5f;
    public int  size =0;

    public HashMap() {
        for (int i = 0; i < initialSize; i++) {
            Bucket.add(new LinkedList<Entity<K,V>>());
        }
        size=0;
    }

    int getHash(K key){
        return Math.floorMod(key.hashCode(), initialSize);
    }

    public void put(K key , V value){
        int index = getHash(key);
        LinkedList<Entity<K,V>> curr = Bucket.get(index);
        for(Entity<K,V> entity : curr){
            if(entity.key.equals(key)){
                entity.value = value;
                return ;
            }
        }
        Entity<K,V> newEntry = new Entity<K,V>(key, value);
        curr.add(newEntry);
        size++;
        double lf = (double)size/initialSize;
        if(lf > loadFactor){
            rehash();
        }

    }



     private void rehash() {
        initialSize *=2;
        ArrayList<LinkedList<Entity<K,V>>> newBucket = new ArrayList<>(initialSize);
        for(int i=0;i<initialSize;i++){
            newBucket.add(new LinkedList<>());
        }
        for(LinkedList<Entity<K,V>> oldEn : Bucket){
           for(Entity<K,V> e : oldEn){
            int hash = getHash(e.key);
            newBucket.get(hash).add(e);
           }
        }
        Bucket = newBucket;

    }
    public V get(K key){
        int idx = getHash(key);
        LinkedList<Entity<K,V>> li = Bucket.get(idx);
        for(Entity<K,V> e : li){
            if(e.key.equals(key)){
                return e.value;
            }
        }
        return  null;
    }



     class Entity<K, V> {
        K key;
        V value;

        Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
