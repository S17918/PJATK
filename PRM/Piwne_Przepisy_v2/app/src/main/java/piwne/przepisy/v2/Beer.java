package piwne.przepisy.v2;

public class Beer {
    private int nameId;
    private int descriptionId;
    private int imageId;

    public static final Beer[] beers = {
            new Beer(R.string.ipa_poland,R.string.ipa_poland_description, R.drawable.ipa_poland),
            new Beer(R.string.polskie_jasne, R.string.polskie_jasne_description, R.drawable.polskie_jasne)
    };

    public Beer(int nameId, int descriptionId, int imageId) {
        this.nameId = nameId;
        this.descriptionId = descriptionId;
        this.imageId = imageId;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
