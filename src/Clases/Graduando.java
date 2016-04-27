package Clases;

/**
 *
 * @author wcarrasco
 */
public class Graduando implements Comparable<Graduando> {

    String LastName;
    String FirstName;
    String NombreCompleto;
    String Email;
    String Campus;
    String University;
    String MasterDescription;
    String ProgramName;
    String Language;
    String FirstMod;
    String HorasModulo1;
    String HorasTotal;
    String Track;
    String CourseKey;
    String LearningStartDate; //Puede que se cambie a Date

    public Graduando() {
    }

    public Graduando(String LastName, String FirstName, String NombreCompleto, String Email, String Campus, String University, String MasterDescription, String ProgramName, String Language, String FirstMod, String HorasModulo1, String HorasTotal, String Track, String CourseKey, String LearningStartDate) {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.NombreCompleto = NombreCompleto;
        this.Email = Email;
        this.Campus = Campus;
        this.University = University;
        this.MasterDescription = MasterDescription;
        this.ProgramName = ProgramName;
        this.Language = Language;
        this.FirstMod = FirstMod;
        this.HorasModulo1 = HorasModulo1;
        this.HorasTotal = HorasTotal;
        this.Track = Track;
        this.CourseKey = CourseKey;
        this.LearningStartDate = LearningStartDate;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCampus() {
        return Campus;
    }

    public void setCampus(String Campus) {
        this.Campus = Campus;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String University) {
        this.University = University;
    }

    public String getMasterDescription() {
        return MasterDescription;
    }

    public void setMasterDescription(String MasterDescription) {
        this.MasterDescription = MasterDescription;
    }

    public String getProgramName() {
        return ProgramName;
    }

    public void setProgramName(String ProgramName) {
        this.ProgramName = ProgramName;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public String getFirstMod() {
        return FirstMod;
    }

    public void setFirstMod(String FirstMod) {
        this.FirstMod = FirstMod;
    }

    public String getHorasModulo1() {
        return HorasModulo1;
    }

    public void setHorasModulo1(String HorasModulo1) {
        this.HorasModulo1 = HorasModulo1;
    }

    public String getHorasTotal() {
        return HorasTotal;
    }

    public void setHorasTotal(String HorasTotal) {
        this.HorasTotal = HorasTotal;
    }

    public String getTrack() {
        return Track;
    }

    public void setTrack(String Track) {
        this.Track = Track;
    }

    public String getCourseKey() {
        return CourseKey;
    }

    public void setCourseKey(String CourseKey) {
        this.CourseKey = CourseKey;
    }

    public String getLearningStartDate() {
        return LearningStartDate;
    }

    public void setLearningStartDate(String LearningStartDate) {
        this.LearningStartDate = LearningStartDate;
    }

    @Override
    public int compareTo(Graduando o) {
        return MasterDescription.compareTo(o.getMasterDescription());
    }

}
