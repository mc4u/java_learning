package com.cloud4u.membership.util;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.dom4j.DocumentException;

import com.cloud4u.membership.domain.entity.MemberDetailEntity;
import com.cloud4u.membership.domain.entity.MemberShipDetailEntity;



public class UserPDFExporter {
	public final String PDF_BACKGROUND_COLOR= "#FFFFFF";
	public static final float CONTENT_BOX_DETAIL_HEIGHT = 200;
	public static final float SPACE_Y = 12;
	private String ICON_PATH = "";
	public static float XPACE = 10;
	
	public String pdfFileSavePath= "";
	private MemberDetailEntity listMembers;
	private MemberShipDetailEntity detailEntity;

	public UserPDFExporter(MemberDetailEntity listMembers,MemberShipDetailEntity detailEntity ) {
		this.listMembers = listMembers;
		this.detailEntity=detailEntity;
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		pdfFileSavePath=getPorperty("pdfFileSavePath")+File.separator;
		ICON_PATH=getPorperty("IconPath")+File.separator;
		PDDocument document = new PDDocument();
		PDPage page = new PDPage(PDRectangle.A4);

		document.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.setLineWidth(0.25f);

		fillBox(contentStream, 0, 0, page.getBBox().getWidth(), page.getBBox().getHeight(), PDF_BACKGROUND_COLOR);
		float boxXSppace = (page.getBBox().getWidth() - (160*3))/4;
		XPACE=boxXSppace;
        float x = boxXSppace;
        float nxtX=(page.getBBox().getWidth()/2)-10;
        float y = page.getBBox().getHeight() - SPACE_Y-10;
        drawText("Receipt", contentStream, PDType1Font.TIMES_BOLD,20, nxtX, y, Color.DARK_GRAY);
        y=y-SPACE_Y-30;
        drawText("Name: "+listMembers.getMember_name(), contentStream, PDType1Font.TIMES_BOLD,10, x, y, Color.DARK_GRAY);
          
        x=x+boxXSppace+160-20;
        drawText("Age: "+listMembers.getAge(), contentStream, PDType1Font.TIMES_BOLD,10, x, y, Color.DARK_GRAY);
        
        x=x+boxXSppace+160-60;
        drawText("Sex: "+listMembers.getSex(), contentStream, PDType1Font.TIMES_BOLD,10, x, y, Color.DARK_GRAY);
        x=x+boxXSppace+160-70;
        drawText("Dob: "+listMembers.getDob(), contentStream, PDType1Font.TIMES_BOLD,10, x, y, Color.DARK_GRAY);
        x=boxXSppace;
        y=y-SPACE_Y-30;
        drawText("Adress: "+listMembers.getMember_address(), contentStream, PDType1Font.TIMES_BOLD,10, x, y, Color.DARK_GRAY);
        x=boxXSppace;
        y=y-SPACE_Y-30;
        drawText("Membership Type: "+detailEntity.getMembershipType(), contentStream, PDType1Font.TIMES_BOLD,10, x, y, Color.DARK_GRAY);
        x=x+boxXSppace+160-20;
        drawText("Joining Date: "+detailEntity.getJointingDate(), contentStream, PDType1Font.TIMES_BOLD,10, x, y, Color.DARK_GRAY);
        
        x=x+boxXSppace+160-60;
        drawText("Ending Date: "+detailEntity.getEndingDate(), contentStream, PDType1Font.TIMES_BOLD,10, x, y, Color.DARK_GRAY);
        PDImageXObject imgObj = PDImageXObject.createFromFile(ICON_PATH + "subscription.jpg", document);
		float imgy = y-SPACE_Y-30;
		float scale = 0.2f; // alter this value to set the image size
		imgy = imgy - imgObj.getHeight()*scale + 10;
		//x = x + CONTENT_BOX_WIDTH - imgObj.getWidth()*scale - BOX_IMAGE_RIGHT_SPACE; 
		contentStream.drawImage(imgObj, x+20, imgy, imgObj.getWidth()*scale, imgObj.getHeight()*scale);
        
        contentStream.close();
        File file1 = new File(pdfFileSavePath+"Reciept.pdf");
		document.save(file1);
         
		//Closing the document
		document.close();
    	
	}
	private void fillBox(PDPageContentStream contentStream, float x, float y, float width, float height, String hexColor) {
		try {
			contentStream.setNonStrokingColor(hex2Rgb(hexColor));
			contentStream.fillRect(x, y, width, height);
			contentStream.closeAndFillAndStroke();
		} catch (IOException e) {
		      System.out.println("Error in fillBox: "+ e);
		}
	}
	public static Color hex2Rgb(String colorStr) {
		return new Color(
				Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
				Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
				Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
	private void drawText(String textContent, PDPageContentStream contentStream, PDType1Font font, float fontSize, float x, float y, Color color) {
		try {
			if(color != null) {
				contentStream.setNonStrokingColor(color);
			}
			//Begin the Content stream 
			contentStream.beginText(); 
			//Setting the font to the Content stream  
			contentStream.setFont(font, fontSize);

			//Setting the position for the line 
			contentStream.newLineAtOffset(x, y);
			//Adding text in the form of string 
			contentStream.showText(textContent);      
			//Ending the content stream
			contentStream.endText();
		} catch (IOException e) {
			System.out.println(">> drawText encountered error: "+ e);
		}
	}
	public static String getPorperty(String key) throws IOException
	{
		InputStream inputStream= UserPDFExporter.class.getClassLoader().getResourceAsStream("application.properties");
		Properties myproperties = new Properties();
		/////////////load the properties file
		myproperties.load(inputStream);
		
		return myproperties.getProperty(key);
	}

}
