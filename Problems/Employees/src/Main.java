class Employee {
    String name;
    String email;
    int experience;

    Employee(String _name, String _email, int _exp){
        this.name = _name;
        this.email = _email;
        this.experience = _exp;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
}

class Developer extends Employee {
    String mainLanguage;
    String [] skills;

    Developer(String _name, String _email, int _exp, String _mainLang, String[] _skills){
        super(_name, _email, _exp);
        this.mainLanguage = _mainLang;
        this.skills = _skills;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        return skills;
    }

}

class DataAnalyst extends Employee {
    Boolean phd;
    String[] methods;

    DataAnalyst(String _name, String _email, int _exp, Boolean _phd, String[] _methods){
        super(_name, _email, _exp);
        this.phd = _phd;
        this.methods = _methods;
    }

    public Boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods;
    }
}