/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExistJavaDAO;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xveri
 */
class RankingTO {
    
    private Map<String, Integer> myRanking;
    
    public Map<String, Integer> getRanking() {
        if (myRanking == null) {
            myRanking = new HashMap<>();
        }
        return myRanking;
    }
    
    public void setRanking(Map<String, Integer> myRanking) {
        this.myRanking = myRanking;
    }
}
