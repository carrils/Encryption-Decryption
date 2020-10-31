class Publication {
    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        String x = "";
        switch (getType()){
            case "Newspaper":
                x = getType() + " (source - " + getDetails() + "): " + title;
                break;
            case "Article":
                x = getType() + " (author - " + getDetails() + "): " + title;
                break;
            case"Announcement":
                x = getType() + " (days to expire - " + getDetails() + "): " + title;
                break;
            default:
                x =  getType() + ": " + title;
                break;
        }
        return x;
    }

    public String getType() {
        return "Publication";
    }

    public String getDetails() {
        return title;
    }

}

class Newspaper extends Publication {
    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    @Override
    public String getDetails() {
        return source;
    }

    @Override
    public String getType() {
        return "Newspaper";
    }
}

class Article extends Publication {
    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String getType() {
        return "Article";
    }

    @Override
    public String getDetails() {
        return author;
    }
}

class Announcement extends Publication {
    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String getType() {
        return "Announcement";
    }

    @Override
    public String getDetails() {
        return Integer.toString(daysToExpire);
    }
}