package booktrainrestwebserviceexercice2;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Date: October 2014
 */
@XmlRootElement(name = "train")
public class Train {

    private String numTrain;
    
    private String villeDepart;
    
    private String villeArrivee;
    
    private int heureDepart; // Format : 1230 = 12h30

    public Train() {
    }

    public Train(String numTrain, String villeDepart, String villeArrivee, int heureDepart) {
        this.numTrain = numTrain;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.heureDepart = heureDepart;
    }

    public int getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(int heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getNumTrain() {
        return numTrain;
    }

    public void setNumTrain(String numTrain) {
        this.numTrain = numTrain;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }
}
