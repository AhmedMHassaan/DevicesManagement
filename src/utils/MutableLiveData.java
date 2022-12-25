/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author pc
 * @param <T>
 */
public final class MutableLiveData<T> extends LiveData<T>{

    public MutableLiveData(T data) {
        super(data);
//        System.out.println("Data is "+data);
//        postData(data);
    }

    public MutableLiveData() {
        super();
    }

 
    
    
    
      public void postData(T data_){
          super.data = data_;
        if (dataListener != null) {
            dataListener.observeData(data);
//            System.out.println("Posted to data "+data);
        }
//          System.out.println("Listener is null "+dataListener);
//        
    }
}
