public class Association<K,V1,V2> {

    private K key;
    private V1 value1;
    private V2 value2;

    public  Association(K k, V1 v1, V2 v2) {
        this.key = k;
        this.value1 = v1;
        this.value2 = v2;
    }
    
    public void setKey(K newKey){
        this.key = newKey;
    }

    public K getKey(){
        return this.key;
    }

    public void setValue1(V1 newValue1){
        this.value1 = newValue1;
    }

    public V1 getValue1(){
        return this.value1;
    }

    public void setValue2(V2 newValue2){
        this.value2 = newValue2;
    }

    public V2 getValue2(){
        return this.value2;
    }
}
