class Phone {
    String ownerName;
    String countryCode;
    String cityCode;
    String number;

    Phone(String _ownerName, String _number){
        this.ownerName = _ownerName;
        this.number = _number;
    }

    Phone(String _ownerName, String _countryCode, String _cityCode, String _number){
        this.ownerName = _ownerName;
        this.countryCode = _countryCode;
        this.cityCode = _cityCode;
        this.number = _number;
    }
}