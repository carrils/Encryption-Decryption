class Time {
    int hours;
    int minutes;
    int seconds;

    Time(int _hours){
        this.hours = _hours;
    }

    Time(int _hours, int _minutes){
        this.hours = _hours;
        this.minutes = _minutes;
    }

    Time(int _hours, int _minutes, int _seconds){
        this.hours = _hours;
        this.minutes = _minutes;
        this.seconds = _seconds;
    }
}