/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.background_thread;

/**
 *
 * @author pc
 * @param <INPUT>
 * @param <OUT_PUT>
 */
public abstract class BackgroundThread<INPUT, OUT_PUT> {

    public abstract OUT_PUT doInBackground(INPUT input);

    public void beforeStart() {

    }

    public OUT_PUT afterEndWork(INPUT input) {
        return null;
    }
}
