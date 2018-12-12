package management.stuant.com.stuant.models;

/**
 * Created by USER on 11/25/2018.
 */

public class DashboardItem {

    private String dashboarLogoName;
    private String itemDescription;
    private int dashboardImage;

    public DashboardItem(String flowerName, String flowerDescription, int flowerImage) {
        this.dashboarLogoName = flowerName;
        this.itemDescription = flowerDescription;
        this.dashboardImage = flowerImage;
    }

    public String getDashboarLogoName() {
        return dashboarLogoName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getDashboardImage() {
        return dashboardImage;
    }

}
