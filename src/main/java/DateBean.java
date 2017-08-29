
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dateBean")
@SessionScoped
public class DateBean {
    private Date startDate;
    private Date endDate;
    private String start;
    private String end;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    
    
    
    public String dateToStr(Date date){
        SimpleDateFormat df = new SimpleDateFormat("MM.dd.yy");
        String str = df.format(date);
        return str;
    }
    
    public String returnDate(){
        start = dateToStr(startDate);
        end = dateToStr(endDate);
        return "date";
    }
}
