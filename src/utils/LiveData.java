/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author pc
 */
public class LiveData<T> {

    IData<T> dataListener;
    protected  T data;

    public LiveData(T data) {
        this.data = data;
//        System.out.println("Data is => "+data);
//        pushData(data);
    }

    public LiveData() {
        this.data = null;
    }

    public T getData() {
        return data;
    }

    public void observe(IData<T> _dataListener) {
//        System.out.println("Now OBserved !"+data);
        this.dataListener = _dataListener;
        pushData(data);

    }

    private void pushData(T data) {
        if (data != null && dataListener != null) {
            dataListener.observeData(data);
//            System.out.println("Data bushed to Listener"+data);
        }
    }

    public interface IData<T> {

        void observeData(T data);
    }
}
