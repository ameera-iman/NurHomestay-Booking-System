package nurhomestay.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import nurhomestay.dao.HomestayDAO;
import nurhomestay.dao.HomestayImgDAO;
import nurhomestay.model.Homestay;
import nurhomestay.model.HomestayImg;

/**
 * Servlet implementation class HomestayController
 */
@WebServlet("/HomeImgController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 15 // 15 MB
)

public class HomeImgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomestayImgDAO daoHomestayImg;
	private HomestayDAO daoHomestay;
	private static final String SAVE_DIR = "imageHomestay"; //nama folder yang akan di create dalam root directory
	String forward="";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeImgController() {
        super();
        daoHomestayImg = new HomestayImgDAO();
        daoHomestay = new HomestayDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("viewimage"))
		{
			int imageId = Integer.parseInt(request.getParameter("imageId"));
			
			HomestayImg homestayImg = new HomestayImg();
			homestayImg = daoHomestayImg.getHomestayImgById(imageId);
			
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + homestayImg.getHome_image();
			
			try {
				File file = new File(savePath);
				if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
				{  
				System.out.println("not supported");  
				return;  
				}  
				else
				{System.out.println("support");
				}
				
				Desktop desktop = Desktop.getDesktop();  
				if(file.exists())//checks file exists or not  
				{
					desktop.open(file); 
				}
				
			} catch(Exception e)  {  
				e.printStackTrace();  
			}  
			
			forward = "adminviewimage.jsp";
			request.setAttribute("homestayImg", homestayImg);
		}
		else if (action.equalsIgnoreCase("listImage"))
		{
    		forward="adminlistimage.jsp";
    		request.setAttribute("homestayImg", daoHomestayImg.getAllHomestayImg());
		}
		else if (action.equalsIgnoreCase("deleteImage")) {

			int imageId=  Integer.parseInt(request.getParameter("imageId"));
			int homestayId = Integer.parseInt(request.getParameter("homestayId"));
				
	   		daoHomestayImg.deleteImage(imageId);
	   		Homestay homestay = daoHomestay.getHomestayById(homestayId);        	
        	
        	forward ="adminaddimage.jsp";       		
            request.setAttribute("homestay", homestay); 
			request.setAttribute("homestayImg", daoHomestayImg.getAllHomestayImgByHomeid(homestayId));
				
				
	        } 
		
		 RequestDispatcher view = request.getRequestDispatcher(forward);
		    view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("addimage"))
		{
            int homestayId = Integer.parseInt(request.getParameter("homestayId"));
			
			// gets absolute path of the web application
		    String appPath = request.getServletContext().getRealPath("");
						//appPath punya value untuk komputer aku => D:\eclipse-workspace.metadata.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\groupProject570\ 
		    
		    String savePath = appPath + SAVE_DIR; // SAVE_DIR tu create new folder name 'uploadPaymentReceipt'
			
			// creates the save directory if it does not exists
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			
			Part homeimage  = request.getPart("home_image"); //dapatkan name untuk <input type='file'>
			
			//input type file return bukan nama file shj, tapi sekali dgn directory semua
			String homeimagename = Paths.get(homeimage.getSubmittedFileName()).getFileName().toString(); //trim dan dapatkan nama file shj
			
			homeimagename = new File(homeimagename).getName(); //masukkan nama file tadi dlm variable
			
			String ImageSimpanName = savePath + File.separator + homeimagename; //masukkan path directory ke dalam variable, file yang diupload akan masuk ikut directory ni
			homeimage.write(ImageSimpanName); //masukkan file ke dalam directory
			System.out.println(ImageSimpanName); //ni untuk tgk dalam console eclipse, directory tadi macam mana
			
			//dalam database kita tak guna directory yang sama, kita simpan nama folder yang baru create dgn nama file shj
			String ImageSimpanNamedb = SAVE_DIR +File.separator + homeimagename; 
			System.out.println("pathnyaa :"+ImageSimpanNamedb);
			
			HomestayImg homestayImg = new HomestayImg(ImageSimpanNamedb,homestayId);
			//homestayImg.setHome_image(ImageSimpanNamedb); //set kan yang nama folder+nama file tadi guna set method
			//homestayImg.setHomestayId(homestayId);
			
			daoHomestayImg.addImage(homestayImg); //simpan dalam DB guna DAO
			forward ="adminaddimage.jsp";  
			Homestay homestay = daoHomestay.getHomestayById(homestayId);  
            request.setAttribute("homestay", homestay); 
			request.setAttribute("homestayImg", daoHomestayImg.getAllHomestayImgByHomeid(homestayId));
			System.out.println("dahh masuk yee");
			
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
   
}


//Integer homestayId=Integer.parseInt(request.getParameter("homestayId"));
	//String home_image=request.getParameter("home_image");
	
//   HomestayImg homestayImg = new HomestayImg(home_image,homestayId);							
	
//	homestayImg= daoHomestayImg.getHomestayImg(homestayImg);
//	if(!homestayImg.isValid())
//	{
//		daoHomestayImg.addImage(homestayImg);
		
//	}
	//RequestDispatcher view = request.getRequestDispatcher(forward);
//  view.forward(request, response);
 // System.out.println("gambar dah masuk");