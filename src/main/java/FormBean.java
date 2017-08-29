
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name = "formBean")
@SessionScoped
public class FormBean implements Serializable
{
  private static final long serialVersionUID = 1L;
 
  /**
   * Download file.
   */
  public void downloadFile() throws IOException{
    String fileName = "wetter";
     File file = new File("D:\\"+fileName+".csv");
     InputStream fis = new FileInputStream(file);
     byte[] buf = new byte[(int)file.length()];
     int offset = 0;
     int numRead = 0;
     int n=0;
     while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) 
     {
       offset += numRead;
      
     }
     fis.close();
     HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance()
            .getExternalContext().getResponse();
    
    response.setContentType("application/octet-stream");
    response.setHeader("Content-Disposition", "attachment;filename="+fileName+n+".txt");
    response.getOutputStream().write(buf);
    response.getOutputStream().flush();
    response.getOutputStream().close();
    FacesContext.getCurrentInstance().responseComplete();
  }
}