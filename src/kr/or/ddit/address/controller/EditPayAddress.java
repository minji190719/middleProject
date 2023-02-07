package kr.or.ddit.address.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.or.ddit.address.service.AddressServiceImpl;
import kr.or.ddit.address.service.IAddressService;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class UpdateAddress
 */
@WebServlet("/address/editPay.do")
public class EditPayAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String[] splitString = getBody(request).split("\\n");
		
		String inputZip = splitString[3].trim();
		String inputAddr1 = splitString[7].trim();
		String inputAddr2 = splitString[11].trim();

		MemberVO member = (MemberVO) request.getSession(false).getAttribute("member");
		String memId = member.getMem_id();
		
		IAddressService addrService = AddressServiceImpl.getInstance();
		AddressVO addrVo = addrService.selectAddress(memId);
		String addrNo = addrVo.getAddr_no();
		
		AddressVO vo = new AddressVO();
		
		vo.setMem_id(memId);
		vo.setAddr_zip(inputZip);
		vo.setAddr1(inputAddr1);
		vo.setAddr2(inputAddr2);
		vo.setAddr_no(addrNo);
		
		int check = addrService.updateAddress2(vo);
		
		if (check < 1) {
		} else {			
			response.setContentType("application/json; charset=UTF-8");
			
			JsonObject object = new JsonObject();
			
			object.addProperty("memZip", inputZip);
			object.addProperty("memAddr1", inputAddr1);
			object.addProperty("memAddr2", inputAddr2);
			
			PrintWriter out = response.getWriter();
			
			out.print(object);
			out.flush();
			out.close();
		}

	}

	public static String getBody(HttpServletRequest request)
			throws IOException {

		request.setCharacterEncoding("UTF-8");

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(
						new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();

		return body;

	}

}
