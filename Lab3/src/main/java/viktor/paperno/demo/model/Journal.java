package viktor.paperno.demo.model;

public class Journal {
    private int id;
    private int student_id;
    private int study_plan_id;


    public Journal(int id,int student_id, int study_plan_id)
    {
        this.id = id;
        this.student_id = student_id;
        this.study_plan_id = study_plan_id;
    }

    public int getId() {
        return id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getStudy_plan_id() {
        return study_plan_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setStudy_plan_id(int study_plan_id) {
        this.study_plan_id = study_plan_id;
    }
}


