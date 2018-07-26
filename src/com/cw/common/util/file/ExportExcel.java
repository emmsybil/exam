package com.cw.common.util.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 生成Excel表格
 * 
 * @author yuanguangjie
 *
 */
public class ExportExcel {
	/***
	 * 构造方法
	 */
	private ExportExcel() {

	}

	/***
	 * 工作簿
	 */
	public static XSSFWorkbook workbook;

	/***
	 * sheet
	 */
	public static XSSFSheet sheet;
	/***
	 * 标题行开始位置
	 */
	public static final int TITLE_START_POSITION = 0;

	/***
	 * 时间行开始位置
	 */
	public static final int DATEHEAD_START_POSITION = 1;

	/***
	 * 表头行开始位置
	 */
	public static final int HEAD_START_POSITION = 2;

	/***
	 * 文本行开始位置
	 */
	public static final int CONTENT_START_POSITION = 3;

	/**
	 * 
	 * @param dataList
	 *            对象集合
	 * @param titleMap
	 *            表头信息（对象属性名称->要显示的标题值)[按顺序添加]
	 * @param sheetName
	 *            sheet名称和表头值
	 */
	public static String excelExport(List<?> dataList, Map<String, String> titleMap, String sheetName,
			HttpServletRequest request, HttpServletResponse response) {
		// 设置时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 初始化workbook
		initHSSFWorkbook(sheetName);
		// 标题行
		createTitleRow(titleMap, sheetName);
		// 时间行
		createDateHeadRow(titleMap);
		// 表头行
		createHeadRow(titleMap);
		// 文本行
		createContentRow(dataList, titleMap);
		// 设置自动伸缩
		// autoSizeColumn(titleMap.size());

		// 写入处理结果，文件名
		String fileName = "学员名单";
		// try {
		// // 生成文件名称
		// String filedisplay = fileName + ".xls";
		//
		// //
		// 如果web项目，1、设置下载框的弹出（设置response相关参数)；2、通过httpservletresponse.getOutputStream()获取
		// //
		// D:\\serv-FTP\\software\\apche\\tomcat\\apache-tomcat-8.0.39-windows-x64\\apache-tomcat-8.0.39\\webapps\\files\\excel
		// OutputStream out = new FileOutputStream("D:/" + filedisplay);
		// workbook.write(out);
		// System.out.println("out:\t" + workbook);
		// out.close();
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }

		return fileName;
	}

	// 获取当前访问者的真实IP
	public static String getIp(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		// System.out.println(remoteAddr);
		String forwarded = request.getHeader("X-Forwarded-For");
		String realIp = request.getHeader("X-Real-IP");
		// System.out.println(realIp);
		String ip = null;
		if (realIp == null) {
			if (forwarded == null) {
				ip = remoteAddr;
			} else {
				ip = remoteAddr + "/" + forwarded;
			}
		} else {
			if (realIp.equals(forwarded)) {
				ip = realIp;
			} else {
				ip = realIp + "/" + forwarded.replaceAll(", " + realIp, "");
			}
		}
		return ip;
	}

	/***
	 * 
	 * @param sheetName
	 *            sheetName
	 */
	public static void initHSSFWorkbook(String sheetName) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet(sheetName);
	}

	/**
	 * 生成标题（第零行创建）
	 * 
	 * @param titleMap
	 *            对象属性名称->表头显示名称
	 * @param sheetName
	 *            sheet名称
	 */
	public static void createTitleRow(Map<String, String> titleMap, String sheetName) {
		// 设置合并单元格，参数为（参数1：起始行 ；参数2：终止行； 参数3：起始列；参数4：终止列）
		CellRangeAddress titleRange = new CellRangeAddress(0, 0, 0, titleMap.size() - 1);

		// 为薄片设置合并后的单元格
		sheet.addMergedRegion(titleRange);

		// 创建第零行，用于设置标题
		XSSFRow titleRow = sheet.createRow(TITLE_START_POSITION);

		// 创建第0个单元格，显示标题内容
		XSSFCell titleCell = titleRow.createCell(0);

		// 创建单元格字体
		XSSFFont font = workbook.createFont();

		// 设置为粗体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// 设置字体大小
		font.setFontHeightInPoints((short) 24);

		// 创建单元格样式
		XSSFCellStyle cellStyle = workbook.createCellStyle();

		// 设置单元格字体居中样式
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

		// 设置单元格字体样式
		cellStyle.setFont(font);

		// 将单元格样式设置到标题单元格中
		titleCell.setCellStyle(cellStyle);

		// 设置单元格内容
		titleCell.setCellValue(sheetName);
	}

	/**
	 * 创建时间行（第一行创建）
	 * 
	 * @param titleMap
	 *            对象属性名称->表头显示名称
	 */
	public static void createDateHeadRow(Map<String, String> titleMap) {
		// 设置合并单元格，参数为（参数1：起始行 ；参数2：终止行； 参数3：起始列；参数4：终止列）
		CellRangeAddress dateRange = new CellRangeAddress(1, 1, 0, titleMap.size() - 1);

		// 为薄片设置合并后的单元格
		sheet.addMergedRegion(dateRange);

		// 创建第零行，用于设置下载时间
		XSSFRow dateRow = sheet.createRow(DATEHEAD_START_POSITION);

		// 创建第0个单元格，显示时间内容
		XSSFCell dateCell = dateRow.createCell(0);

		// 创建单元格样式
		XSSFCellStyle cellStyle = workbook.createCellStyle();

		// 设置居中单元格样式
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

		// 将单元格样式设置到时间单元格中
		dateCell.setCellStyle(cellStyle);

		dateCell.setCellValue(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
	}

	/**
	 * 创建表头行（第二行创建）
	 * 
	 * @param titleMap
	 *            对象属性名称->表头显示名称
	 */
	public static void createHeadRow(Map<String, String> titleMap) {
		// 创建第二行
		XSSFRow headRow = sheet.createRow(HEAD_START_POSITION);

		// 创建单元格样式
		XSSFCellStyle cellStyle = workbook.createCellStyle();

		// 设置居中单元格样式
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

		// 创建单元格字体
		XSSFFont font = workbook.createFont();

		// 设置为粗体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// 将字体样式设置到单元格样式对象中
		cellStyle.setFont(font);

		int i = 0;
		for (String entry : titleMap.keySet()) {
			// 创建单元格
			XSSFCell headCell = headRow.createCell(i);

			// 为单元格设置样式  
			headCell.setCellStyle(cellStyle);

			headCell.setCellValue(titleMap.get(entry));

			i++;
		}
	}

	/**
	 * 
	 * @param dataList
	 *            对象数据集合
	 * @param titleMap
	 *            表头信息
	 */
	public static void createContentRow(List<?> dataList, Map<String, String> titleMap) {
		try {
			int i = 0;
			// 遍历集合
			for (Object obj : dataList) {
				XSSFRow textRow = sheet.createRow(CONTENT_START_POSITION + i);

				int j = 0;
				for (String entry : titleMap.keySet()) {
					// 获取实体方法名称
					String method = "get" + entry.substring(0, 1).toUpperCase() + entry.substring(1);
					System.out.println("查看method的值为：" + method);

					Method m = obj.getClass().getMethod(method, null);

					// 获取值
					String value = m.invoke(obj, null).toString();

					XSSFCell textcell = textRow.createCell(j);

					if (textcell.getCellType() != 1) {
						textcell.setCellType(XSSFCell.CELL_TYPE_STRING);
					}

					// 设置cell格式为文本格式:先设置为data类型，在转换为文本类型
					XSSFCellStyle cellStyle = workbook.createCellStyle();
					XSSFDataFormat format = workbook.createDataFormat();
					cellStyle.setDataFormat(format.getFormat("@"));
					textcell.setCellStyle(cellStyle);

					textcell.setCellValue(value);
					textcell.setCellType(XSSFCell.CELL_TYPE_STRING);

					j++;
				}
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自动伸缩列（如非必要，请勿打开此方法，耗内存）
	 * 
	 * @param size
	 *            列数
	 */
	public static void autoSizeColumn(Integer size) {
		for (int j = 0; j < size; j++) {
			sheet.autoSizeColumn(j);
		}
	}
}
