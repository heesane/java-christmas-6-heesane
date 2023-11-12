package christmas.Enum;

public enum Badge {
    BADGE_STAR("별",5000),
    BADGE_TREE("트리",10000),
    BADGE_SANTA("산타",20000);

    private final String badgeName;
    private final Integer badgePrice;

    Badge(String badgeName, Integer badgePrice){
        this.badgeName = badgeName;
        this.badgePrice = badgePrice;
    }
    public String getBadgeName() {
        return badgeName;
    }
    public Integer getPrice() {
        return badgePrice;
    }
}
