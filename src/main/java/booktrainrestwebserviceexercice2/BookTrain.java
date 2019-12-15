package booktrainrestwebserviceexercice2;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Date: October 2014
 */
@XmlRootElement(name = "booktrain")
public class BookTrain {

    private String numBook;

    private Train currenTrain;

    private int numberPlaces;

    public String getNumBook() {
        return numBook;
    }

    public void setNumBook(String bookNumber) {
        this.numBook = bookNumber;
    }

    public Train getCurrenTrain() {
        return currenTrain;
    }

    public void setCurrenTrain(Train currenTrain) {
        this.currenTrain = currenTrain;
    }

    public int getNumberPlaces() {
        return numberPlaces;
    }

    public void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }
}
