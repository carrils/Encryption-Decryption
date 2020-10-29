class Movie {
    private String title;
    private String desc;
    private int year;

    // write two constructors here
    Movie(String _title, String _desc, int _year){
        this.title = _title;
        this.desc = _desc;
        this.year = _year;
    }

    Movie(String _title, int _year){
        this.title = _title;
        this.year = _year;
        this.desc = "empty";
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getYear() {
        return year;
    }
}