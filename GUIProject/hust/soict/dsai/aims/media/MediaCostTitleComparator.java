package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaCostTitleComparator implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int costComparison = Float.compare(media2.getCost(), media1.getCost());  
        
        if (costComparison == 0) {
            return media1.getTitle().compareToIgnoreCase(media2.getTitle());
        }
        
        return costComparison;
    }
}

