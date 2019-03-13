package viktor.paperno.demo.model;

public class Student {
    private int id;
    private String Surname;
    private String Name;
    private String SecondName;
    private int StudyGroupId;


    public Student(int id,String Surname,String Name, String SecondName, int StudyGroupId)
    {
        this.id = id;
        this.Name = Name;
        this.Surname = Surname;
        this.SecondName = SecondName;
        this.StudyGroupId = StudyGroupId;
    }


    public int getId()
    {
        return id;
    }

    public int getStudyGroupId()
    {
        return StudyGroupId;
    }

    public String getName()
    {
        return Name;
    }

    public String getSurname()
    {
        return Surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public void setStudyGroupId(int studyGroupId) {
        StudyGroupId = studyGroupId;
    }

    public String getSecondName()
    {
        return SecondName;
    }

}
